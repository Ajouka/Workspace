import java.util.LinkedList;

public class Test {

    public static <T> void main(String[]args){

MyDeque x=new MyDeque();

x.addFirst("a");

x.addlast("z");
x.addFirst(4);

        System.out.println(x.toArrayList());
        //System.out.println(x.displayList());
        System.out.println(x.toReverseArrayList());
    }
}
