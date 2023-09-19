package DataStructure;

public class BiSortTree {
    private Node root;

    public BiSortTree() {
        root = new Node(null, null, -1);
    }

    public Node findInsert(Node curr, int item) {
        Node find = null;
        if (curr.item > item) {
            if (curr.lChild == null)
                return curr;
            else
                find = findInsert(curr.lChild, item);
        } else if (curr.item < item) {
            if (curr.rChild == null)
                return curr;
            else
                find = findInsert(curr.rChild, item);
        }
        return find;
    }

    public void insert(int item) {
        Node node = new Node(null, null, item);
        if (root.item == -1) {
            root.item = node.item;
        } else {
            Node insert = findInsert(root, item);
            if (insert.lChild == null && insert.item > item)
                insert.lChild = node;
            else insert.rChild = node;
        }
    }

    public void popRoot() {
        if (root.lChild == null) {
            root = root.rChild;
        }
        if (root.rChild == null) {
            root = root.lChild;
        }
    }

    public void pop(int item) {
        Node node = findNode(root, item);
        Node parent = findParent(root, item);
        if (root.item == item)
            popRoot();
        else {
            if (node.rChild == null) {
                if (node.lChild == null)
                    if (parent.lChild != null && parent.lChild.item == node.item) {
                        parent.lChild = null;
                    } else
                        parent.rChild = null;
                else {
                    if (parent.lChild != null && parent.lChild.item == node.item) {
                        parent.lChild = node.lChild;
                    } else
                        parent.rChild = node.lChild;
                }
            }
            if (node.lChild == null) {
                if (node.rChild != null) {
                    if (parent.lChild != null && parent.lChild.item == node.item) {
                        parent.lChild = node.rChild;
                    } else
                        parent.rChild = node.rChild;
                }
            }
        }
        if (node.lChild != null && node.rChild != null) {
            Node minTag = node.lChild;
            Node moveFlag = node;
            while (minTag.rChild != null) {
                moveFlag = minTag;
                minTag = minTag.rChild;
            }
            node.item = minTag.item;
            ;
            if (moveFlag != node) {
                moveFlag.rChild = minTag.lChild;
            } else
                moveFlag.lChild = minTag.lChild;
        }
    }

    private Node findParent(Node curr, int item) {
        Node find = null;
        if (curr.lChild != null)
            if (curr.lChild.item == item)
                return curr;
            else {
                find = findParent(curr.lChild, item);
                if (find != null)
                    return find;
            }
        if (curr.rChild != null)
            if (curr.rChild.item == item)
                return curr;
            else {
                find = findParent(curr.rChild, item);
                if (find != null)
                    return find;
            }
        return find;
    }

    private Node findNode(Node curr, int item) {
        Node find = null;
        if (curr.item == item)
            return curr;
        if (curr.lChild != null) {
            find = findNode(curr.lChild, item);
            if (find != null)
                return find;
        }
        if (curr.rChild != null) {
            find = findNode(curr.rChild, item);
            if (find != null)
                return find;
        }
        return find;
    }

    public void orderPrint(Node node) {
        if (node.lChild != null)
            orderPrint(node.lChild);
        System.out.println(node.item);
        if (node.rChild != null)
            orderPrint(node.rChild);
    }

    private static class Node {
        public Node lChild;
        public Node rChild;
        public int item;

        public Node(Node lChild, Node rChild, int item) {
            this.lChild = lChild;
            this.rChild = rChild;
            this.item = item;
        }
    }

    public static void main(String[] args) {
        BiSortTree tree = new BiSortTree();
        tree.insert(1);
        tree.insert(3);
        tree.insert(2);
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.insert(7);
        tree.pop(1);
        tree.orderPrint(tree.root);
    }
}
