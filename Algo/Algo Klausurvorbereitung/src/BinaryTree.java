import java.util.Random;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    Node root;

    public BinaryTree(int x) {
        root = new Node(x);
    }

    public int insertRandom(int x) {
        Random rand = new Random();
        Node current = root;
        int level = 0;
        while (true) {
            if (rand.nextBoolean()) {
                if (current.left == null) {
                    current.left = new Node(x);
                    return level;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    current.right = new Node(x);
                    return level;
                } else {
                    current = current.right;
                }
            }
            level++;
        }
    }

    public int getMaxLevel() {
        return getMaxLevel(root, 0);
    }

    private int getMaxLevel(Node node, int level) {
        if (node == null) {
            return -1;
        }
        int left = getMaxLevel(node.left, level + 1);
        int right = getMaxLevel(node.right, level + 1);
        return Math.max(level, Math.max(left, right));
    }


    public static void main(String[]args){

        BinaryTree x=new BinaryTree(3);
        x.insertRandom(6);
        x.insertRandom(12);
        x.insertRandom(13);
        x.insertRandom(30);
        x.insertRandom(1);

        System.out.println(x.getMaxLevel());




    }

}
