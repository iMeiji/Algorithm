package struct.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于数组实现的 LRU 缓存
 */
public class LRUBasedOnArray<T> {

    private static final int DEFAULT_CAPACITY = (1 << 4);

    private int capacity;

    private int count;

    private T[] value;

    private Map<T, Integer> holder;

    public LRUBasedOnArray() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBasedOnArray(int capacity) {
        this.capacity = capacity;
        value = (T[]) new Object[capacity];
        count = 0;
        holder = new HashMap<>(capacity);
    }

    public void offer(T object) {
        if (object == null) {
            throw new IllegalArgumentException("LRU cache don't support null value");
        }

        Integer index = holder.get(object);
        if (index == null) {
            if (isFull()) {
                removeAndCache(object);
            } else {
                cache(object, count);
            }
        } else {
            update(index);
        }
    }

    /**
     * 若缓存中有指定的值，则更新位置
     *
     * @param end
     */
    public void update(int end) {
        T target = value[end];
        rightShift(end);
        value[0] = target;
        holder.put(target, 0);
    }

    /**
     * 缓存数据到头部，但要先右移
     *
     * @param object
     * @param end    数组右移的边界
     */
    public void cache(T object, int end) {
        rightShift(end);
        value[0] = object;
        holder.put(object, 0);
        count++;
    }

    /**
     * 缓存满的情况，踢出后，再缓存到数组头部
     *
     * @param object
     */
    public void removeAndCache(T object) {
        value[--count] = null;
        cache(object, count);
    }

    private void rightShift(int end) {
        for (int i = end - 1; i >= 0; i--) {
            value[i + 1] = value[i];
            holder.put(value[i], i + 1);
        }
    }

    public boolean isContain(T object) {
        return holder.containsKey(object);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(value[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LRUBasedOnArray<Integer> lru = new LRUBasedOnArray<>();
        lru.offer(1);
        lru.offer(2);
        lru.offer(3);
        lru.offer(4);
        lru.offer(5);
        System.out.println(lru);
    }


}
