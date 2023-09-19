package DataStructure;

import java.util.LinkedList;

// 按照层次遍历创建二叉树
public class BiTree {
    Node root;
    private class Node {
        int num;
        Node LChild;
        Node RChild;
        LinkedList<Node> queue = new LinkedList<>();
        public Node (int num) {
            this(num, null, null);
        }
        public Node (int num, Node LChild, Node RChild) {
            this.num = num;
            this.LChild = LChild;
            this.RChild = RChild;
        }

        private void insert(Node node) {
            Node firstNode = queue.getFirst();
            if (firstNode.LChild == null) {
                firstNode.LChild = node;
            } else if (firstNode.RChild == null) {
                firstNode.RChild = node;
                queue.pop();
            }
        }

        public void put(Node node) {
            queue.add(node);
        }
    }
    public void insert(int num) {
        Node node = new Node(num);
        if (root == null) {
            root = node;
            root.put(node);
            return;
        }
        root.put(node);
        root.insert(node);
    }

    public void orderPrint(Node curr) {
        if (curr == null)
            return;
        System.out.print(curr.num + "\t");
        orderPrint(curr.LChild);
        orderPrint(curr.RChild);
    }

    public static void main(String[] args) throws Exception {
        BiTree tree = new BiTree();
        int[] nums = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < nums.length; i++) {
            tree.insert(nums[i]);
        }

        tree.orderPrint(tree.root);
    }
}

