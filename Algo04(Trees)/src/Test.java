public class Test {
    public static void main(String[] args) {
        var e = new BinaryTree();
e.insert2(3);
e.insert2(5);
e.insert2(9);
e.insert2(1);
        System.out.println(e.search2(9));
        e.inorder();
        System.out.println(e.root.lift.value);
 }
}