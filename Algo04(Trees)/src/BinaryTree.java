public class BinaryTree {
    public Node root;
    private int count;

    public static class Node {
        public int value;
        public Node lift;
        public Node right;

        public Node(int element) {
            this.value = element;
        }
    }


    public void show(int data) {
        Node current = root;
        while (current != null) {
            if (current.value == data) {
                System.out.println(current.value + ":" + " left: " + current.lift + " right:" + current.right);
            } else if (current.value > data) {
                current = current.lift;
            } else current = current.right;
        }
        System.out.println(data + " isnt found ");

    }

    public boolean search(int data) {
        Node current = root;
        while (current != null) {
            if (current.value == data) {
                return true;
            } else if (current.value > data) {
                current = current.lift;
            } else current = current.right;
        }
        return false;
    }

    public boolean search2(int element) {
        return search2Rec(element, root);
    }

    private boolean search2Rec(int element, Node root) {
        if (root == null) return false;
        else if (root.value == element) return true;
        return element > root.value ? search2Rec(element, root.right) : search2Rec(element, root.lift);
    }

    public void insertrec(int element) {
        root = insert2Rec(element, root);

    }

    private Node insert2Rec(int element, Node root) {

        if (root == null) {
            return new Node(element);

        } else if (element < root.value) {
            return insert2Rec(element, root.lift);
        } else if (element > root.value) {
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
            while (current.value != element) {
                if (current.value > element) {
                    if (current.lift == null) {
                        current.lift = new Node(element);
                        return;
                    }
                    current = current.lift;
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
            inorderRec(root.lift);
            System.out.println(" " + root.value);
            inorderRec(root.right);
        }
    }


}
