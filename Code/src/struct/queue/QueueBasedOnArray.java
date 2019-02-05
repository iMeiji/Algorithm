package struct.queue;


/**
 * 基于数组实现的队列
 */
public class QueueBasedOnArray<T> {

    // items 表示数组，capacity 表示数组大小
    private T[] items;
    private int capacity;
    // head表示队头下标，tail表示队尾下标
    private int head;
    private int tail;

    public QueueBasedOnArray(int capacity) {
        this.capacity = capacity;
        this.items = (T[]) new Object[this.capacity];
    }

    public boolean enqueue(T data) {
        // 队列尾部没有空间了
        if (tail == capacity) {

            if (head == 0) {
                // 整个队列都占满了
                return false;
            }

            // 数据搬移
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            // 搬移后更新 head 和 tail
            tail = tail - head;
            head = 0;
        }
        items[tail] = data;
        tail++;
        return true;
    }

    public T dequeue() {
        if (head == tail) {
            return null;
        }

        T value = items[head];
        head++;
        return value;
    }

    public void printAll() {
        for (int i = 0; i < tail; i++) {
            System.out.print(items[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueBasedOnArray<Integer> queue = new QueueBasedOnArray<>(4);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.printAll();

        System.out.println(queue.dequeue());
        queue.enqueue(5);
        queue.printAll();
    }

}
