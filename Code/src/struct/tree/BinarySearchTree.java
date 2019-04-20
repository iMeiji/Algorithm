package struct.tree;

import java.util.Stack;

public class BinarySearchTree {

    private Node tree;


    /**
     * 先取根节点，如果它等于我们要查找的数据，那就返回。
     * 如果要查找的数据比根节点的值小，那就在左子树中递归查找；
     * 如果要查找的数据比根节点的值大，那就在右子树中递归查找
     */
    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (p.data < data) {
                p = p.right;
            } else if (p.data > data) {
                p = p.left;
            } else {
                return p;
            }
        }
        return null;
    }

    /**
     * 如果要插入的数据比节点的数据大，并且节点的右子树为空，就将新数据直接插到右子节点的位置；
     * 如果不为空，就再递归遍历右子树，查找插入位置。
     * 同理，如果要插入的数据比节点数值小，并且节点的左子树为空，就将新数据插入到左子节点的位置；
     * 如果不为空，就再递归遍历左子树，查找插入位置
     */
    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if (p.data < data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {// p.data > data
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    /**
     * 第一种情况是，如果要删除的节点没有子节点，我们只需要直接将父节点中，指向要删除节点的指针置为 null。
     * <p>
     * 第二种情况是，如果要删除的节点只有一个子节点（只有左子节点或者右子节点），我们只需要更新父节点中，指向要删除节点的指针，让它指向要删除节点的子节点就可以了。
     * <p>
     * 第三种情况是，如果要删除的节点有两个子节点，这就比较复杂了。
     * 我们需要找到这个节点的右子树中的最小节点，把它替换到要删除的节点上。然后再删除掉这个最小节点。
     */
    public void delete(int data) {
        Node p = tree;// p 指向要删除的节点，初始化指向根节点
        Node pp = null;// pp 记录的是 p 节点的父节点

        while (p != null && p.data != data) {
            pp = p;
            if (p.data < data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        if (p == null) {// 没有找到
            return;
        }

        // 要删除的节点含有左右子节点，需要从右子树中找到最小节点
        if (p.left != null && p.right != null) {
            Node minP = p.right; // minP 指向要删除的节点
            Node minPP = p;// minPP 记录的是 minP 的父节点
            while (minP.left != null) {// 找最小节点
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;// 将 minP 的数据替换到 p 中
            p = minP;// 下面就变成了删除 minP 了
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        Node child = null;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        }


        if (pp == null) {// 删除的是根节点
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

    /**
     * 查找最小节点
     */
    public Node findMin() {
        if (tree == null) {
            return null;
        }

        Node p = tree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    /**
     * 查找最大节点
     */
    public Node findMax() {
        if (tree == null) {
            return null;
        }

        Node p = tree;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    /**
     * 前序遍历
     */
    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 前序遍历迭代版
     */
    public void preOrderII() {
        if (tree == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node p = tree;
        while (p != null || !stack.isEmpty()) {

            while (p != null) {
                System.out.println(p);
                stack.push(p);
                p = p.left;
            }

            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.right;
            }
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root);
        inOrder(root.right);
    }


    /**
     * 中序遍历迭代版
     */
    public void inOrderII() {
        if (tree == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node p = tree;
        while (p != null || !stack.isEmpty()) {

            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            if (!stack.isEmpty()) {
                p = stack.pop();
                System.out.println(p);
                p = p.right;
            }
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root);
    }


    /**
     * 后序遍历迭代版
     */
    public void postOrderII() {
        if (tree == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node p = tree;
        Node lastVisit = tree;
        while (p != null || !stack.isEmpty()) {

            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            p = stack.peek();

            if (p.right == null || p.right == lastVisit) {
                System.out.println(p);
                stack.pop();
                lastVisit = p;
                p = null;
            } else {
                p = p.right;
            }
        }
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data + "";
        }
    }
}
