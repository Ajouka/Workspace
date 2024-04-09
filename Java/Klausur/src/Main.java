import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {


    public static boolean[] uberprufe(String s) {
        boolean[] result = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            int actuell = Character.getNumericValue(s.charAt(i));
            boolean checkLift = false;
            boolean checkRight = false;

            for (int j = 0; j < i; j++) {
                if (Character.getNumericValue(s.charAt(j)) > actuell) {
                    checkLift = true;
                    break;
                } else continue;
            }
            if (checkLift) {
                for (int y = i; y < s.length(); y++) {
                    if (Character.getNumericValue(s.charAt(y)) > actuell) {
                        checkRight = true;
                        break;

                    } else continue;
                }
                if (checkRight) {
                    result[i] = true;
                } else result[i] = false;

            }
        }

        return result;
    }

    public static void main(String[] args) {
        /*converter1 cn = new converter1();
        //System.out.println(cn.converter("hi i am done"));
        converter2 cn2 = new converter2();
        //System.out.println(cn2.converter("Tare ajouka 13"));
        //System.out.println(cn2.converter("Tare ajouka 13"));
        converter3 cn3 = new converter3('_');
        //System.out.println(cn3.converter("Tarek Ajouka 30"));


        multi cnM = new multi();

        cnM.addConverter(cn);
        cnM.addConverter(cn2);
        cnM.addConverter(cn3);


        System.out.println(cnM.converter("Tarek Ajouka 30"));
        System.out.println(cnM.converter("Tarek Ajouka 30"));*/

        System.out.println(Arrays.toString(uberprufe("1389874")));
    }
}