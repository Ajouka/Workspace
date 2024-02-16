import java.util.*;

public class probeklausur5 {

    public static String factors(int x) {
        HashMap<Integer, Integer> res = new HashMap<>();
        int n = x;
        boolean bigfound = false;
        int big = 0;
        for (int i = n / 2; i > 1; i--) {
            if (!isPrime(i)) continue;
            if (n % i != 0) continue;
            if (n % i == 0) {
                if (!bigfound) {
                    big = i;
                    bigfound = true;
                }
                n /= i;
                if (!res.containsKey(i)) {
                    res.put(i, 1);
                } else res.put(i, res.get(i) + 1);
                i++;
            }

        }

        String res1 = "";
        for (int i = 2; i <= big; i++) {
            if (!isPrime(i)) continue;
            if (res.containsKey(i)) {
                if (res.get(i) == 1) res1 += "(" + i + ")";
                    //res1.append("(").append(i).append("**").append(res.get(i)).append(")");
                else res1 += "(" + i + "**" + res.get(i) + ")";
            }

        }


        return res1;
    }


    public static boolean isPrime(int x) {
        for (int i = 2; i <= x / 2; i++) {

            if (x % i == 0) return false;
            else continue;
        }

        return true;
    }

    public static String orderWeight(String strng) {
        String[] x = strng.split(" ");

        int[][] res = new int[x.length][2];

        for (int i = 0; i < x.length; i++) {
            int sum = 0;
            for (int j = 0; j < x[i].length(); j++) {
                sum += Integer.parseInt("" + x[i].charAt(j));
            }
            res[i][0] = sum;
            res[i][1] = Integer.parseInt(x[i]);

        }
        Comparator<int[]> cmp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        };
        Arrays.sort(res, cmp);
        String res1 = "";
        for (int i = 0; i < res.length; i++) {
            if (i == res.length - 1) res1 += String.valueOf(res[i][1]);
            else {
                res1 += res[i][1] + " ";
            }

        }
        return res1;
    }

    public static String pigIt(String str) {
        String[] x = str.split(" ");

        String res = "";
        for (int i = 0; i < x.length; i++) {
            if (x[i].length() > 1) {
                for (int j = 1; j < x[i].length(); j++) {
                    if (j == x[i].length() - 1) {

                        res += "" + x[i].charAt(j) + x[i].charAt(0) + "ay";
                        continue;
                    }
                    res += x[i].charAt(j);


                }


            }
            if (i != x.length - 1) res += " ";
        }


        return res;
    }

    public static Map<Character, Integer> count(String str) {

        if (Objects.equals(str, "")) return null;
        Map<Character, Integer> res = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            if (!res.containsKey(str.charAt(i))) {
                res.put(str.charAt(i), 1);

            } else {
                res.put(str.charAt(i), res.get(str.charAt(i))+1);


            }


        }
        return res;
    }



    public static void main(String[] args) {
        System.out.println(count("aba"));

    }
}
