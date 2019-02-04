package struct.linkedlist;

/**
 * 基于单链表的 LRU 缓存
 *
 * @param <T>
 */
public class LRUBasedSingleLinkedList<T> {

    private final int DEFAULT_CAPACITY = 1 << 4;

    private Node<T> headNode;

    private int length;

    private int capacity;

    public LRUBasedSingleLinkedList() {
        this.headNode = new Node<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBasedSingleLinkedList(int capacity) {
        this.headNode = new Node<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T data) {
        Node preNode = findPreNode(data);
        // 链表中存在，删除原数据，再插入到链表头部
        if (preNode != null) {
            deleteNextNode(preNode);
            insertToHead(data);
        } else {
            if (length >= capacity) {
                // 删除尾结点
                deleteTailNode();
            }
            // 插入到链头部
            insertToHead(data);
        }
    }

    /**
     * 删除尾结点
     */
    private void deleteTailNode() {
        Node found = headNode;
        if (found.next == null) {
            return;
        }

        while (found.next.next != null) {
            found = found.next;
        }

        found.next = null;
        length--;
    }

    private void insertToHead(T data) {
        Node next = headNode.next;
        headNode.next = new Node(data, next);
        length++;
    }

    /**
     * 删除 preNode 结点的下一个节点
     *
     * @param preNode
     */
    private void deleteNextNode(Node preNode) {
        Node deleteNode = preNode.next;
        preNode.next = deleteNode.next;
        deleteNode = null;
        length--;
    }

    /**
     * 获取查找到元素的前一个结点
     *
     * @param data
     * @return
     */
    private Node findPreNode(T data) {
        Node node = headNode;
        while (node.next != null) {
            if (node.next.data.equals(data)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    private void printAll() {
        Node node = headNode.next;
        while (node != null) {
            System.out.print(node.toString() + ",");
            node = node.next;
        }
        System.out.println();
    }

    public static class Node<T> {

        private T data;
        private Node next;

        public Node() {
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public static void main(String[] args) {
        LRUBasedSingleLinkedList list = new LRUBasedSingleLinkedList(2);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.printAll();
    }


}
