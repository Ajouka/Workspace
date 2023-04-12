public class BinTree {
    public Node root;
    private int count;

    public static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int element) {
            this.data = element;
        }
    }

    public Node getNode(int data) {
        Node current = root;
        while (current != null) {
            if (current.data == data) {
                return current;
            } else if (current.data > data) {
                current = current.left;
            } else current = current.right;
        }
        return null;
    }


    public Node getParentNode(int x) {
        Node current = root;
        Node parent = null;
        while (current != null) {
            if (current.data == x) {
                return parent;
            } else if (current.data > x) {
                parent = current;
                current = current.left;
            } else {
                parent = current;
                current = current.right;
            }
        }
        return null;
    }


    public void insert(int element) {
        if (getNode(element) != null) throw new ArithmeticException("the value " + element + "is already inserted");
        else {
            if (root == null) {
                root = new Node(element);
                return;
            }
            Node current = root;
            while (current.data != element) {
                if (current.data > element) {
                    if (current.left == null) {
                        current.left = new Node(element);
                        return;
                    }
                    current = current.left;
                } else {

                    if (current.right == null) {
                        current.right = new Node(element);
                        return;
                    }
                    current = current.right;

                }
            }
        }
    }

    public void remove(int x) {
        root = remove(root, x);
    }

    private Node remove(Node node, int x) {
        if (node == null) {
            throw new ArithmeticException("Value not found in tree");
        }

        if (node.data > x) {
            node.left = remove(node.left, x);
        } else if (node.data < x) {
            node.right = remove(node.right, x);
        } else { // node.data == x
            if (node.left == null && node.right == null) { // no children
                node = null;
            } else if (node.left != null && node.right != null) { // two children
                node.data = getMinValue(node.right);
                node.right = remove(node.right, node.data);
            } else { // one child
                node = (node.left != null) ? node.left : node.right;
            }
        }
        return node;
    }

    private int getMinValue(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    public void clear() {
        root = null;
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(" " + root.data);
            inorderRec(root.right);
        }
    }


}
