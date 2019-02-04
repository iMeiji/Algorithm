package struct.linkedlist;

/**
 * 单链表插入、删除、访问操作
 */
public class SingleLinkedList {

    private Node head = null;

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static void main(String[] args) {
        SingleLinkedList link = new SingleLinkedList();

        int[] data = {1, 2, 3, 2};
        int data_2[] = {4, 5, 6};


        for (int i = 0; i < data.length; i++) {
            link.insertTail(data[i]);
        }
        for (int i = 0; i < data_2.length; i++) {
            link.insertAfter(link.findByValue(1), data_2[i]);
        }
        link.printAll();
    }

    public Node findByValue(int value) {
        Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }
        return p;
    }

    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            pos++;
        }
        return p;
    }

    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertTail(int value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
        } else {
            Node q = head;
            while (q.next != null) {
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
        }
    }

    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null) {
            return;
        }
        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        if (p == null) {
            return;
        }
        if (p == head) {
            insertToHead(newNode);
            return;
        }

        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        newNode.next = q;
        q.next = newNode;
    }

    public void deleteByNode(Node p) {
        if (p == null || head == null) {
            return;
        }

        if (p == head) {
            head = head.next;
            return;
        }

        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        q.next = q.next.next;
    }

    public void deleteByValue(int value) {
        if (head == null) {
            return;
        }

        Node p = head;
        Node q = null;

        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }

        if (p == null) {
            return;
        }

        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    // 带结点的链表翻转
    public Node inverseLinkList_head(Node p) {
        //　Head　为新建的一个头结点
        Node Head = new Node(9999, null);
        // p　为原来整个链表的头结点,现在Head指向　整个链表
        Head.next = p;
        /*
        带头结点的链表翻转等价于
        从第二个元素开始重新头插法建立链表
        */
        Node pre = p.next;
        p.next = null;
        Node next = null;

        while (pre != null) {
            next = pre.next;
            pre.next = Head.next;
            Head.next = pre;

            pre = next;
        }

        // 返回左半部分的中点之前的那个节点
        // 从此处开始同步像两边比较
        return Head;
    }

    // 无头结点的链表翻转
    public Node inverseLinkList(Node p) {
        Node pre = null;
        Node next = null;
        Node r = head;

        while (r != p) {
            next = r.next;
            r.next = pre;
            pre = r;
            r = next;
        }

        r.next = pre;
        // 返回左半部分的中点之前的那个节点
        // 从此处开始同步像两边比较
        return r;
    }

    public static class Node {
        public int data;
        public Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

    }
}
