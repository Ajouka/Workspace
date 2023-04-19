/** Ein binaerer Suchbaum mit ganzen Zahlen als Datensatz:
 * Vorlage fuer die A1 von algo-pr05.
 * Als Operationen stehen `contains' und `insert' zur Verfuegung
 */
public class BinarySearchTree {

    /** Die Knotenklasse als statische innere Klasse. */
    public static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public String toString() {
            return this.value + " ";
        }

        public int getValue() {
            return this.value;
        }

        public TreeNode getLeft() {
            return this.left;
        }

        public TreeNode getRight() {
            return this.right;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setLeft(TreeNode node) {
            this.left = node;
        }

        public void setRight(TreeNode node) {
            this.right= node;
        }
    }

    /** Baumwurzel */
    protected TreeNode root;

    /**
     * Herausfinden, ob ein gewisser Datensatz schon im binaeren Suchbaum enthalten ist.
     *
     * @param   data  zu suchender Datensatz
     * @return        true: Datensatz ist vorhanden; false: Datensatz ist nicht vorhanden.
     */
    public boolean contains(int data) {
        TreeNode temp = root;
        while(temp != null) {
            if (temp.getValue() == data) {
                return true;
            }
            if (temp.getValue() > data) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
        return false;
    }

    /**
     * Einen neuen Datensatz in den binaeren Suchbaum einfuegen.
     *
     * @param   data  einzufuegender Datensatz
     * @return        true: Datensatz wurde eingefuegt; false: Datensatz war schon vorhanden.
     */
    public boolean insert(int data) {
        if (root == null) {
            root = new TreeNode(data);
            return true;
        }

        TreeNode temp = root;
        while(temp.getValue() != data) {
            if (temp.getValue() > data) {
                if(temp.getLeft() == null) {
                    temp.setLeft(new TreeNode(data));
                    return true;
                }
                temp = temp.getLeft();
            } else {
                if (temp.getRight() == null) {
                    temp.setRight(new TreeNode(data));
                    return true;
                }
                temp = temp.getRight();
            }
        }
        return false;
    }
    public int getElementCount() {
        return getElementCount(root);
    }

    private int getElementCount(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getElementCount(node.left);
        int right = getElementCount(node.right);
        return 1 + left + right;
    }
    public String toString() {
        return inOrderTraversal(root);
    }

    private String inOrderTraversal(TreeNode node) {
        if (node == null) {
            return "";
        }
        String left = inOrderTraversal(node.left);
        String right = inOrderTraversal(node.right);
        return left + node.value + " " + right;
    }
    public int getSum() {
        return getSum(root);
    }

    private int getSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getSum(node.left);
        int right = getSum(node.right);
        return node.value + left + right;
    }
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        return Math.max(left, right) + 1;
    }
    public int getLeafCount() {
        return getLeafCount(root);
    }

    private int getLeafCount(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        int left = getLeafCount(node.left);
        int right = getLeafCount(node.right);
        return left + right;
    }
    public boolean hasNodesWithOneChild() {
        return hasNodesWithOneChild(root);
    }

    private boolean hasNodesWithOneChild(TreeNode node) {
        if (node == null) {
            return false;
        }
        if ((node.left != null && node.right == null) || (node.left == null && node.right != null)) {
            return true;
        }
        boolean left = hasNodesWithOneChild(node.left);
        boolean right = hasNodesWithOneChild(node.right);
        return left || right;
    }
    private Integer prevValue;

    public boolean isValid() {
        prevValue = null;
        return isValid(root);
    }

    private boolean isValid(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (!isValid(node.left)) {
            return false;
        }
        if (prevValue != null && node.value <= prevValue) {
            return false;
        }
        prevValue = node.value;
        return isValid(node.right);
    }


    public static void main(String[] args) {


        BinarySearchTree tree = new BinarySearchTree();
        for (int i = 0; i < 20; i++) {
            int x = (int) (Math.random() * 50);
            System.out.println(x);
            tree.insert(x);
        }
        for (int i = 0; i < 50; i++) {
            System.out.println(i + ": " + tree.contains(i));
        }
    }
}

