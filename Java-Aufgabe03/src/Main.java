
import java.util.*;


public class Main {


    public static void main(String[] args) {
        Datensatz s = new Datensatz();
        String x ="000"+ s.getDataString().toString();
        System.out.println(x);
        ArrayList<Integer> list=Fax.encode(x);
        System.out.println(list);
        System.out.println(Fax.entcoden(list));

    }
}