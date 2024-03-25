import java.util.ArrayList;

public class Main {

    public static ArrayList<Integer> getValues(int num) {
        return getValues(num, 2);
    }

    private static ArrayList<Integer> getValues(int num, int fac) {
        if (num == 1) {
            return new ArrayList<Integer>();
        } else if (num % fac == 0) {
            ArrayList<Integer> ret = getValues(num / fac, fac);
            ret.add(fac);
            return ret;
        } else {
            return getValues(num, fac + 1);
        }
    }

    public static int sucheAB(String[] text){
        int counter=0;

        for(int j=0;j<text.length;j++){
            String s=text[j];
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='a'&&i<s.length()-1&&s.charAt(i+1)=='b')counter++;
                if(s.charAt(i)=='a'&& i==s.length()-1 && j<text.length-1){
                    counter++;
                }
            }

        }


        return counter;
    }

    public static void main(String[] args) {

        Bruch x = new Bruch(2,4);
        System.out.println(x.toString());
        System.out.println(x.counter);
        x.setZaehler(3);
        System.out.println(x.counter);
        var y=new Bruch(3,2);
        x.add(y);

    }
}