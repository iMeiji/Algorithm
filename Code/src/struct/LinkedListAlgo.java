package struct;

public class LinkedListAlgo {

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    // 单链表反转
    public static Node reverse(Node list) {
        Node head = null;

        Node previous = null;
        Node current = list;

        while (current != null) {
            Node next = current.next;
            if (next == null) { // 如果下一个结点为空，头结点为当前结点，反转结束
                head = current;
            }
            current.next = previous; // 当前结点的 next 指针指向上一个结点
            previous = current; // 上一个结点向后移动
            current = next; // 当前结点向后移动
        }

        return head;
    }

    /**
     * 检测环形链表
     * 定义两个指针,同时从链头开始出发,快指针一次走两步,慢指针一次走一步
     * 如果快指针追上满指针,那么链表就是环形链表
     */
    public static boolean checkCircle(Node list) {
        if (list == null) {
            return false;
        }

        Node fast = list.next;
        Node slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    // 有序链表合并
    public static Node mergeSortedLists(Node la, Node lb) {

        if (la == null) {
            return lb;
        }
        if (lb == null) {
            return la;
        }

        Node p = la;
        Node q = lb;
        Node head;

        // 确定头部
        if (p.data < q.data) {
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }

        Node r = head;

        while (p != null && q != null) {
            if (p.data < q.data) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }

        // 剩余部分
        if (p != null) {
            r.next = p;
        } else {
            r.next = q;
        }

        return head;
    }

    // 删除链表倒数第 K 个结点
    public static Node deleteLastKth(Node list, int k) {
        Node fast = list;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        if (fast == null) {
            return list;
        }

        Node slow = list;
        Node prev = null;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev == null) {
            list = list.next;
        } else {
            prev.next = prev.next.next;
        }
        return list;
    }

    // 求中间结点
    public static Node findMiddleNode(Node list) {
        if (list == null) {
            return null;
        }

        Node fast = list;
        Node slow = list;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

}
