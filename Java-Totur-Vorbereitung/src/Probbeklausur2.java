import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Probbeklausur2 {

    public static class Dominostein {
        private int zahl1;
        private int zahl2;


        public Dominostein(int a, int b) {
            if (a < 0 || a > 6 || b < 0 || b > 6)
                throw new NumberFormatException("zahlen nicht in [0;6] form");


            this.zahl1 = a;
            this.zahl2 = b;

        }

        @Override
        public String toString() {
            return "[" + zahl1 + "," + zahl2 + ']';
        }

        public void drehUm() {
            int temp = this.zahl1;
            this.zahl1 = zahl2;
            this.zahl2 = temp;
        }

        public int[] getValues() {
            return new int[]{this.zahl1, this.zahl2};
        }
    }

    public static class Dominokette {
        private LinkedList<Dominostein> kette = new LinkedList<>();

        public Dominokette(Dominostein d) {
            this.kette.add(d);


        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Dominostein d : this.kette) {
                sb.append(d);

            }

            return sb.toString();
        }

        public void fuegeRecht(Dominostein d) {
            int[] dv = d.getValues();
            int[] iv = kette.getLast().getValues();
            if (dv[0] == iv[1]) {
                this.kette.add(d);
            }
            else if (dv[1] == iv[1]) {
                d.drehUm();
                this.kette.add(d);

            } else throw new NumberFormatException("Seite Passt nicht ");


        }


    }

    public static boolean pruefeMatrix(int[][] matrix) {
        int test = 0;
        for (int i = 0; i < matrix.length; i++) {
            test += matrix[0][i];
        }
        for (int i = 1; i < matrix.length; i++) {
            int zeile = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                zeile += matrix[i][j];
            }
            if (zeile != test) return false;

        }
        for (int j = 0; j < matrix[0].length; j++) {
            int spalte = 0;
            for (int i = 0; i < matrix.length; i++) {
                spalte += matrix[i][j];
            }
            if (spalte != test) return false;

        }
        return true;

    }

    public static String verschoenere(String s) {
        return s.replaceAll(" +", " ");
    }

    public static double[] liesDaten(String filename) throws FileNotFoundException {
        File f = new File(filename);
        Scanner c = new Scanner(f);
        String line = "";
        do {
            line = c.nextLine();
        }
        while (line.charAt(0) == '#');
        String[] splt = line.split(":");
        int count = Integer.parseInt(splt[1].trim());
        double[] res = new double[count];
        for (int i = 0; i < count; i++) {
            do {
                line = c.nextLine();
            }
            while (line.charAt(0) == '#');
            res[i] = Double.parseDouble(line);
        }
        c.close();
        return res;
    }


    public static boolean stimmenUeberein(String s1, String s2) {
        int twinCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) continue;
            else if (i < s1.length() - 1 && s1.charAt(i) == s2.charAt(i + 1) && s1.charAt(i + 1) == s2.charAt(i) && twinCount == 0) {
                twinCount++;
                i++;
            } else return false;
        }

        return true;
    }


    public static void main(String[] args) {

        Dominokette kette=new Dominokette(new Dominostein(4,2));
       kette.fuegeRecht(new Dominostein(2,5));
        kette.fuegeRecht(new Dominostein(5,0));
        kette.fuegeRecht(new Dominostein(0,6));
        kette.fuegeRecht(new Dominostein(6,3));
        kette.fuegeRecht(new Dominostein(3,3));

        kette.fuegeRecht(new Dominostein(5,3));
        System.out.println(kette);
        kette.fuegeRecht(new Dominostein(2,2));
    }

}
