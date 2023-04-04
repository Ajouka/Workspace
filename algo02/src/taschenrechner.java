
import java.util.Scanner;


public  class taschenrechner {





        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            UPNCalculator calc = new UPNCalculator();
            String z = "";
            while (true) {
                z = in.nextLine();
                if (z.equals("quit")) {
                    break;
                }
                if (z.equals("clear")) {
                    calc.mapVars.clear();
                    continue;
                }
                System.out.println("task '" + z + "' => " + calc.analyze(z));
            }
        }
    }



