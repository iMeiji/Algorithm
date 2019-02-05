package struct.stack;

/**
 * 基于单链表实现的栈
 *
 * @param <T>
 */
public class StackBasedOnLinkedList<T> {

    private Node<T> top;

    public void push(T data) {
        Node newNode = new Node(data, null);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public T pop() {
        if (top == null) {
            return null;
        }
        T value = top.data;
        top = top.next;
        return value;
    }

    public void printAll() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + ",");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackBasedOnLinkedList<Integer> list = new StackBasedOnLinkedList<>();
        list.push(1);
        list.push(2);
        list.push(3);
        list.printAll();
        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list.pop());
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
