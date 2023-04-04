public class Test1 {
    public static void main(String[]args){

        MyDeque x=new MyDeque();

        x.addFirst(3);
        x.addlast(4);
        x.addFirst(2);
        System.out.println(x.displayList());
    }
}
