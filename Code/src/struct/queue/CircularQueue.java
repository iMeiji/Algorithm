package struct.queue;

/**
 * 循环队列
 *
 * @param <T>
 */
public class CircularQueue<T> {

    // items 表示数组，capacity 表示数组大小
    private T[] items;
    private int capacity;
    // head表示队头下标，tail表示队尾下标
    private int head;
    private int tail;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.items = (T[]) new Object[this.capacity];
    }

    public boolean enqueue(T data) {
        // 队列满了
        if ((tail + 1) % capacity == head) {
            return false;
        }
        items[tail] = data;
        tail = (tail + 1) % capacity;
        return true;
    }

    public T dequeue() {
        if (head == tail) {
            return null;
        }

        T value = items[head];
        head = (head + 1) % capacity;
        return value;
    }

    public void printAll() {
        if (capacity == 0) {
            return;
        }

        for (int i = head; (i % capacity) != tail; i++) {
            System.out.print(items[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>(8);
        for (int i = 1; i <= 8; i++) {
            queue.enqueue(i);
        }
        queue.printAll();

        for (int i = 0; i < 8; i++) {
            System.out.println(queue.dequeue());
        }
    }
}
