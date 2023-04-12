public class BinTree {
    public Node root;


    public static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int element) {
            this.data = element;
        }
    }

    public BinTree(){
        root=null;
    }

    private Node getNode(int data) {
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


    private Node getParentNode(int x) {
        
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

        if (node.data > x) { // wenn die
            node.left = remove(node.left, x);
        } else if (node.data < x) {
            node.right = remove(node.right, x);
        } else { // node.data == x
            if (node.left == null && node.right == null) { // die zu löschende Knote hat kein Kind knote
                node = null;
            } else if (node.left != null && node.right != null) { // hat zwei kinderknoten
                node.data = getMinValue(node.right);
                node.right = remove(node.right, node.data);
            } else { // hat nur ein
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
    public static void main(String[] args) {
        BinTree tree = new BinTree();
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(50);
        int[] testcases = { 30, 35, 50 };
        for (int testcase : testcases) {
            Node node = tree.getNode(testcase);
            if (node == null) {
                System.out.println("Knoten " + testcase + " nicht gefunden.");
            } else {
                System.out.println("Knoten " + testcase + " gefunden: " + node.data);
            }
        }
        tree.remove(30);
        System.out.println("Knoten geloescht: 30");

        System.out.println("Elternknoten von 50: " + tree.getParentNode(50).data);// 20
    }


}
