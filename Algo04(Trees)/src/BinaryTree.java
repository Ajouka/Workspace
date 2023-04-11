public class BinaryTree {
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


    public void show(int data) {
        Node current = root;
        while (current != null) {
            if (current.data == data) {
                System.out.println(current.data + ":" + " left: " + current.left + " right:" + current.right);
            } else if (current.data > data) {
                current = current.left;
            } else current = current.right;
        }
        System.out.println(data + " isnt found ");

    }

    public boolean search(int data) {
        Node current = root;
        while (current != null) {
            if (current.data == data) {
                return true;
            } else if (current.data > data) {
                current = current.left;
            } else current = current.right;
        }
        return false;
    }

    public boolean search2(int element) {
        return search2Rec(element, root);
    }

    private boolean search2Rec(int element, Node root) {
        if (root == null) return false;
        else if (root.data == element) return true;
        return element > root.data ? search2Rec(element, root.right) : search2Rec(element, root.left);
    }

    public void insertrec(int element) {
        root = insert2Rec(element, root);

    }

    private Node insert2Rec(int element, Node root) {

        if (root == null) {
            return new Node(element);

        } else if (element < root.data) {
            return insert2Rec(element, root.left);
        } else if (element > root.data) {
            return insert2Rec(element, root.right);
        }
        return this.root;
    }

    public void insert(int element) {
        if (search(element)) throw new ArithmeticException();
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
        if (search(x)) {


        } else throw new ArithmeticException();

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
