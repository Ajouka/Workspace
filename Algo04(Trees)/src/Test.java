public class Test {
    public static void main(String[] args) {
        var e = new BinaryTree();
e.insert2(3);
e.insert2(5);
e.insert(9);
        System.out.println(e.search2(9));
        e.inorder();
 }
}