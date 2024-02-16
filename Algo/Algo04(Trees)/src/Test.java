public class Test {
    public static void main(String[] args) {
        var e = new BinTree();
        e.insert(20);
        e.insert(10);
        e.insert(5);
        e.insert(15);
        e.insert(30);
        e.insert(25);
        e.insert(35);
        e.insert(1);




        e.inorder();
e.remove(1);
e.remove(20);

        System.out.println("--------");
        e.inorder();
        //System.out.println(e.getParentNode(5).data);
        System.out.println(e.root.data);
    }
}