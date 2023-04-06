public class TestMain {

    public static void main(String[]args){
LinkedList x=new LinkedList();
x.insertFirst(3);
x.insertFirst(2);
x.insertFirst(1);
x.insertAt(0,10);
x.insertAt(1,11);
x.insertAt(3,20);
x.insertAt(6,30);

        System.out.println(x.listToArray());
        System.out.println(x.search(30));
        System.out.println(x.getCount());

    }
}
