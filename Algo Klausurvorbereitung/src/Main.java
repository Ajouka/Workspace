import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {
    public static class Test {
        public static String open = "([{";
        public static String close = ")]}";

        public static boolean check(String s) {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {

                int pos = open.indexOf(s.charAt(i));
                if (pos != -1) stack.push(pos);
                pos = close.indexOf(s.charAt(i));
                if (pos != -1 && stack.pop() != pos) return false;

            }
            return true;


        }


    }

    public static ArrayList<Integer> textSearch(String text, String pattern) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            boolean match = false;
            for (int j = 0; j < pattern.length(); j++) {
                if (pattern.charAt(j) == text.charAt(i + j)) {
                    match = true;
                } else break;
            }
            if (match) res.add(i);
        }


        return res;
    }


    public static void main(String[] args) {
        System.out.println(Test.check("([Tarek])"));

        System.out.println(textSearch("TarekTarekTarekTarek", "Tarek"));


        System.out.println("Hello world!");
    }
}