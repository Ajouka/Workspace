public class Test {
    public static void main(String[] args) {
        var e = new BinaryTree();
        e.insert(20);
        e.insert(10);
        e.insert(5);
        e.insert(15);
        e.insert(30);
        e.insert(25);
        e.insert(35);




        System.out.println(e.search2(5));
        System.out.println(e.search(5));
        e.inorder();
        System.out.println(e.root.value);
    }
}