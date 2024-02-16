import java.util.*;

public class Main {
    public static double zeilensummennorm(double[][] a) {
        double max = 0;
        for (int i = 0; i < a.length; i++) {
            double summe = 0;
            for (int j = 0; j < a[i].length; j++) {
                summe += Math.abs(a[i][j]);
            }
            if (summe > max) max = summe;
        }

        return max;
    }

    public static List<Integer> merge(List<Integer> a, List<Integer> b) {
        // Erstelle eine leere Liste für das Ergebnis
        List<Integer> result = new ArrayList<>();
        // Erstelle zwei Indizes für die beiden Listen
        int i = 0; // Index für Liste a
        int j = 0; // Index für Liste b
        // Solange beide Indizes kleiner als die Länge der jeweiligen Liste sind
        while (i < a.size() && j < b.size()) {
            // Vergleiche die Elemente an den Indizes
            if (a.get(i) < b.get(j)) {
                // Füge das kleinere Element zur Ergebnisliste hinzu
                result.add(a.get(i));

                // Erhöhe den Index für Liste a um eins
                i++;
            } else {
                // Füge das kleinere oder gleiche Element zur Ergebnisliste hinzu
                result.add(b.get(j));
                // Erhöhe den Index für Liste b um eins
                j++;
            }
        }
        // Wenn noch Elemente in Liste a übrig sind, füge sie zur Ergebnisliste hinzu
        while (i < a.size()) {
            result.add(a.get(i));
            i++;
        }
        // Wenn noch Elemente in Liste b übrig sind, füge sie zur Ergebnisliste hinzu
        while (j < b.size()) {
            result.add(b.get(j));
            j++;
        }
        // Gib die Ergebnisliste zurück
        return result;
    }


    public static int countChar(String s, char c) {
        if (s == null || s.length() == 0) return 0;
        int count = (s.charAt(0) == c) ? 1 : 0;
        return count + countChar(s.substring(1), c);
    }

    public static int countMatchingChars(String s, String t) {

        if (s == null || t == null || s.length() == 0 || t.length() == 0) return 0;
        int count = (s.charAt(0) == t.charAt(0)) ? 1 : 0;
        return count + countMatchingChars(s.substring(1), t.substring(1));
    }

    public static String generateString(int n, char c) {
        if (n == 0) {
            return "";
        } else {
            return c + generateString(n - 1, (char) (c + 1));
        }
    }

    public static void rueckwaertsAusgeben(List<?> l) {
        if (l.size() > 0) {
            System.out.print(l.get(l.size() - 1) + " ");
            rueckwaertsAusgeben(l.subList(0, l.size() - 1));
        }
    }

    public static int xHochY(int x, int y) {
        if (y == 0) return 1;
        else {
            return x * xHochY(x, y - 1);
        }

    }

    public static boolean spends(int s) {
        return s > 0;
    }

    public static String machKompakt(String s) {
        String s1 = s.toLowerCase();
        StringBuilder neu = new StringBuilder();
        outer:
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < neu.length(); j++) {
                if (s1.charAt(i) == neu.charAt(j)) {
                    continue outer;
                }
            }
            neu.append(s1.charAt(i));

        }

        return neu.toString();
    }

    public static String machKompakt1(String s) {
        String s1 = s.toLowerCase();
        String neu = "";
        for (int i = 0; i < s1.length(); i++) {
            if (!neu.contains("" + s1.charAt(i))) {
                neu = neu + s1.charAt(i);
            }

        }

        return neu;
    }

    public static String machKompakt2(String s) {
        LinkedHashSet<Character> result = new LinkedHashSet<>();
        String s1 = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            result.add(s1.charAt(i));

        }


        return result.toString();
    }

    public static boolean testePasswort(String s) {
        ArrayList<String> result = new ArrayList<>();
        if (s.length() < 3) return false;
        for (int i = 0; i < s.length() - 2; i++) {
            result.add(s.substring(i, i + 3));


        }

        for (int i = 0; i < result.size() - 1; i++) {

            inner:
            for (int j = 0; j < result.size() - 1; j++) {
                if (i == j) continue inner;
                if (result.get(i).equals(result.get(j))) {
                    return false;
                }
            }
        }
        return true;



    }
    public static HashMap<Integer,ArrayList<Integer>> getFrequencies(int[] arr){
        var result=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<arr.length;i++){

        }



        return result;
    }

    public static HashMap<Integer, ArrayList<Integer>> getFrequencies1(int[] arr) {

        HashMap<Integer, ArrayList<Integer>> erg = new HashMap<>();  // leere Zielhashtabelle

        // erstmal in einer Hilfshashtabelle notieren, wie oft jede Zahl vorkommt:
        HashMap<Integer, Integer> wieOft = new HashMap<>();  // leere Hilfshashtabelle
        for (int zahl: arr) {                      // fuer jede Zahl im gegebenen Array
            Integer haeufigkeit = wieOft.get(zahl);  // Haeufigkeit der Zahl der Hashtabelle entnehmen
            if (haeufigkeit == null)                 // ahl noch nicht notiert?
                haeufigkeit = 0;                       // => Sie kommt bis jetzt 0mal vor.
            ++haeufigkeit;                           // notierte Haeufigkeit hochsetzen
            wieOft.put(zahl, haeufigkeit);           // und in der Hastabelle speichern
        }

        // diesen Haeufigkeiten nun die Listen der Zahlen zuordnen, die so oft vorkommen:
        for (int zahl: arr) {                      // fuer jede Zahl im gegebenen Array
            int haeufigkeit = wieOft.get(zahl);      // Haeufigkeit der Zahl aus Hilfshashtabelle holen
            var liste = erg.get(haeufigkeit);        // Zahlenliste dazu aus Zielhashtabelle holen
            if (liste == null) {                     // noch keine Liste vorhanden?
                liste = new ArrayList<Integer>();      // => leere Liste anlegen
                erg.put(haeufigkeit, liste);           // => Liste in Hashtabelle eintragen
            }
            if (! liste.contains(zahl))              // Zahl noch nicht in Liste drin?
                liste.add(zahl);                       // => Zahl zur Liste hinzufuegen
        }

        return erg;
    }
public static void sort(LinkedList<Integer> s){

    for (int i = 0; i < s.size(); i++) {
        for (int j = i + 1; j < s.size(); j++) {
            if (s.get(i) > s.get(j)) {
                int temp = s.get(i);
                s.set(i, s.get(j));
                s.set(j, temp);
            }
        }
    }




}

    public static void main(String[] args) {
        var x=new LinkedList<Integer>();
        x.add(8);
        x.add(3);
        x.add(2);
        x.add(10);
        x.add(14);
        x.add(6);
        x.add(19);
        x.add(12);
        x.add(5);
        x.add(13);
        sort(x);
        System.out.println(x);


        String s="Passswort1234";
        System.out.println(testePasswort(s));
        var result=new ArrayList<String>();
        for(int i=0;i<s.length()-2;i++){
            result.add(s.substring(i, i + 3));
        }
        System.out.println(result);

        //double[][]numbers={{5,-1,3,2},{-2,8,9,4},{1,1,-5,3}};
        //System.out.println(zeilensummennorm(numbers));

//        List<Integer> a = new ArrayList<Integer>();
//        a.add(2);
//        a.add(4);
//        a.add(8);
//        List<Integer> b = new ArrayList<Integer>();
//        b.add(1);
//        b.add(3);
//        b.add(9);
//        System.out.println(merge(a, b));
//
//        String s = "Regenpfeifer";
//        String s1 = "manamana";
//        System.out.println(machKompakt(s));
//        System.out.println(machKompakt1(s1));
//        System.out.println(machKompakt2(s));

       /*List<Character> l = new LinkedList<>();
       l.add('a');
       l.add('b');
       l.add('c');
       l.add('d');


        System.out.println(l);
        rueckwaertsAusgeben(l);
        System.out.println(l.subList(0,l.size()-1));
        System.out.println(spends(-3));*/


    }
}