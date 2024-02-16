
import java.util.*;


public class Main {


    public static void main(String[] args) {
        Datensatz s = new Datensatz();
        String x = s.getDataString().toString();
        System.out.println(x);
        ArrayList<Integer> list=Fax.encode(s.getDataString().toString());
        System.out.println(list);
        System.out.println(Fax.decode(list));
        System.out.println(Integer.parseInt("11111111",2));
    }
}