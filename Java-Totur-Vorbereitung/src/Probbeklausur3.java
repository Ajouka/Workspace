import java.util.*;

public class Probbeklausur3 {
    public static String sol(String str) {
        String res = "";
        for (int i = 1; i <= str.length(); i++) {
            res += str.charAt(str.length() - i);


        }


        return res;
    }

    public static int groessterSingulaererWert(int[] arr) {
        int singleMax = 0;
        boolean found = false;
        outer:
        for (int i = 0; i < arr.length; i++) {

            if (!found || arr[i] > singleMax) {
                inner:
                for (int j = 0; j < arr.length; j++) {


                    if (j != i && arr[i] == arr[j]) continue outer;

                }
            }
            found = true;
            singleMax = arr[i];

        }


        return singleMax;
    }

    public static int zaehleIterationen(double cx, double cy) {
        double x = 0;
        double y = 0;
        int it = 0;
        while (x * x + y * y <= 4 && it < 200) {

            x = x * x - y * y + cx;
            y = 2 * x * y + cy;

            it++;

        }
        return it;
    }


    public static boolean istPrimzahl(int p) {
        if (p <= 0) throw new IllegalArgumentException("nur werte grosser als 0 erlaubt du arschloch!");
        else if (p == 1) return false;
        else return istPrimzahl(p, p - 1);

    }

    private static boolean istPrimzahl(int p, int factor) {
        if (factor == 1) return true;
        else if (p % factor == 0) return false;
        else return istPrimzahl(p, factor - 1);

    }

    public static boolean testKlammer(String kl) {
        int ebene = 0;
        for (int i = 0; i < kl.length(); i++) {
            if (kl.charAt(i) == '(') ebene++;
            else if (kl.charAt(i) == ')') {
                ebene--;
                if (ebene < 0) return false;
            }


        }
        return ebene == 0;

    }

    public static int ersteDoppelte(Random r) {
        HashSet<Integer> hash = new HashSet<>();
        boolean keindoppelte = true;
        while (keindoppelte) {
            int tmp = r.nextInt();
            if (hash.contains(tmp))
                keindoppelte = false;
            else hash.add(tmp);


        }

        return hash.size();
    }

    public static class Menge {
        private ArrayList<Integer> menge;

        public Menge() {
            this.menge = new ArrayList<>();

        }

        public void add(int n) {
            if (!contains(n)) menge.add(n);

        }

        public int size() {
            return this.menge.size();
        }

        public boolean contains(int x) {
            return menge.contains(x);

        }

        public void add(Menge m) {

            for (int i : m.menge) {
                add(i);
            }

        }

        public Menge getIntersection(Menge m) {
            Menge res = new Menge();
            for (int i : m.menge) {
                if (contains(i)) res.add(i);

            }
            return res;


        }

        public String toString() {

            return this.menge.toString();
        }


    }

    public static class DoubleSet {
        private ArrayList<Integer> menge;

        public DoubleSet() {
            this.menge = new ArrayList<>();

        }

        public void add(int a) {

            if (getCount(a) >= 2) throw new ArithmeticException("Die " + a + " ist mehr als 2 vorhanden");
            else this.menge.add(a);

        }

        public int getCount(int z) {
            int counter = 0;
            for (int i : menge) {
                if (i == z) counter++;

            }
            return counter;
        }

        public String toString() {

            return this.menge.toString();
        }

    }


    public interface Iterationsvorschrift {
        public double next(double x);
    }

    public static class Folge {
        private double x0;
        private Iterationsvorschrift v;
        private double xn;

        public Folge(double xo, Iterationsvorschrift v) {
            this.x0 = this.xn = xo;
            this.v = v;


        }

        public double getNextElemnt() {
            this.xn = this.v.next(xn);
            return this.xn;

        }

        public void reset() {
            this.xn = x0;

        }

    }

    public static class TestVorschrift implements Iterationsvorschrift {


        @Override
        public double next(double x) {
            return x * x;
        }
    }

    public interface DiffIntFunc {
        public DiffIntFunc integrate();

        public DiffIntFunc differentiate();

    }

    public static class SinCosFunc implements DiffIntFunc {
        //f(x) = a · sin(b · x) + c · cos(d · x); b, d != 0.
        private double a;
        private double b;
        private double c;
        private double d;

        public SinCosFunc(double a, double b, double c, double d) {
            if (b == 0 || d == 0) throw new IllegalArgumentException("b und d dürfen nicht = 0 sein ");
            else {
                this.a = a;
                this.b = b;
                this.c = c;
                this.d = d;
            }
        }

        @Override
        public DiffIntFunc integrate() {
            //f(x) dx = −a/b· cos(b · x) + c/d· sin(d · x)

            return new SinCosFunc(c / d, d, -a / b, b);
        }

        @Override
        public DiffIntFunc differentiate() {
            //dxf(x) = ab · cos(b · x) − cd · sin(d · x)

            return new SinCosFunc(-c * d, d, a * b, b);
        }

        public String toString() {

            return this.a + ".sin(" + this.b + ".x)" + this.c + ".cos(" + this.d + ".x)";


        }
    }

    public static boolean check(String sentence) {

        for (int i = 97; i <= 122; i++) {
            String x = "" + (char) i;
            //String x1 = "" + (char) i + 32;
            if (!sentence.contains(x)&&!sentence.contains(x.toUpperCase())) {
                return false;
            }


        }


        return true;
    }

    public static void main(String[] args) {
        String str="abcdefghijklmnopqrstuwvxyz";
        System.out.println(check(str));


        System.out.println(sol("World!"));
        /*SinCosFunc x=new SinCosFunc(1,2,3,4);
        DiffIntFunc d=x.differentiate();
        DiffIntFunc i=x.integrate();
        System.out.println(x.toString());
        System.out.println(d.toString());
        System.out.println(i.toString());
        System.out.println(i.differentiate().toString());*/

        /*TestVorschrift v = new TestVorschrift();
        Folge x = new Folge(2, v);
        System.out.println(x.getNextElemnt());
        System.out.println(x.getNextElemnt());
        System.out.println(x.getNextElemnt());
        x.reset();
        System.out.println(x.getNextElemnt());
*/


       /* DoubleSet m = new DoubleSet();
        m.add(2);
        m.add(2);
        m.add(3);
        m.add(4);


        System.out.println("erste Menge:" + m);
        m.add(3);
        m.add(3);
        System.out.println(m);*/


        //Random r = new Random();
        //System.out.println(ersteDoppelte(r));

        //System.out.println(testKlammer("(()())"));

        //int[] arr = new int[]{9, 9, 1, 2, 4, 3, 5, 5, 5, 3, 43, 43, 6, 6, 3};

        //System.out.println(groessterSingulaererWert(arr));
        //System.out.println(istPrimzahl(111));
        //System.out.println(111 / 3);
    }
}
