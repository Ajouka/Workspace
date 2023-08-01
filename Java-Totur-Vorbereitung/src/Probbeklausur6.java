import java.util.ArrayList;
import java.util.Arrays;

public class Probbeklausur6 {


    public static boolean scramble(String str1, String str2) {
        if (str2.length() > str1.length()) return false;

        ArrayList<Character> arr = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            arr.add(str1.charAt(i));

        }
        for (int i = 0; i < str2.length(); i++) {
            if (!arr.contains(str2.charAt(i))) return false;

            else arr.remove(arr.indexOf(str2.charAt(i)));
            ;

        }


        return true;


    }



    public static String high1(String s) {
        //a(97)-->z(122)
        boolean maxCheck=false;
        int max = 0;
        int actual = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (actual > max || !maxCheck) {
                    max = actual;
                    maxCheck=true;
                }
                actual = 0;

            }



            else actual += ((int) s.charAt(i)) - 96;
            if(i==s.length()-1&&(!maxCheck ||actual>max)) max=actual;


        }

        return String.valueOf(max);
    }
    public static String high(String s) {
        String[]x=s.split(" ");
        int max=0;
        String sMax=x[0];

        boolean maxCheck=false;

        for (String value : x) {

            int actual = 0;
            for (int j = 0; j < value.length(); j++) {
                actual += ((int) value.charAt(j))-96;

            }
            if (actual > max || !maxCheck) {
                max = actual;
                sMax=value;
                maxCheck = true;


            }

        }

        return sMax;
    }

    public static int[] parse(String data) {
        int oCounter=0;
        for(int i=0;i<data.length();i++){
            if(data.charAt(i)=='o')oCounter++;

        }
        int[]res=new int[oCounter];
        int res1=0;
        int index=0;
        for (int i=0;i<data.length();i++){


            if(data.charAt(i)=='i')res1++;
            if(data.charAt(i)=='d')res1--;
            if(data.charAt(i)=='s')res1=res1*res1;
            if(data.charAt(i)=='o'){
                res[index]=res1;
                index++;
            }


        }
        return res;
    }


    public static void main(String[] args) {

        System.out.println(Arrays.toString(parse("iiisdoso")));

    }
}
