package struct.queue;

/**
 * 基于单链表实现的队列
 */
public class QueueBasedOnSingleLinkedlist<T> {

    // 队列的队首和队尾
    private Node<T> head;
    private Node<T> tail;

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data, null);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public T dequeue() {
        if (head == null) {
            return null;
        }

        T value = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }

    public static void main(String[] args) {
        QueueBasedOnSingleLinkedlist<Integer> queue = new QueueBasedOnSingleLinkedlist<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.enqueue(4);
        System.out.println(queue.dequeue());
    }

    public static class Node<T> {
        private T data;
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
