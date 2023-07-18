import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Probbeklausur2 {
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
        System.out.println(verschoenere("Tarek Ajouka     13years old"));
        System.out.println(stimmenUeberein("funktion", "funktiom"));


    }

}
