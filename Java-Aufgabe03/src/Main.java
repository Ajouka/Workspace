import java.util.ArrayList;
import java.util.Arrays;



public class Main {



    public static void main(String[] args) {
StringBuilder data =new StringBuilder();
        System.out.println(data);
        String s="11110111100000111100001111111111111";

        ArrayList<Integer> al=new ArrayList<>();
        al=Fax.encode(s);
        System.out.println(al);
        System.out.println(Fax.entcoden(al));

    }
}