import java.util.*;

public class Main {

    interface Old{
        class Matse  {
            private String name;
            private int nummer;

            public Matse(String name, int nummer) {
                this.name = name;
                this.nummer = nummer;
            }

            @Override
            public String toString() {
                return "Matse{" +
                        "name='" + name + '\'' +
                        ", nummer=" + nummer +
                        '}';
            }

            public String getName() {
                return name;
            }


        }



    }


    public static class Matse implements Comparable<Matse> {
        private String name;
        private int nummer;

        public Matse(String name, int nummer) {
            this.name = name;
            this.nummer = nummer;
        }

        @Override
        public String toString() {
            return "Matse{" +
                    "name='" + name + '\'' +
                    ", nummer=" + nummer +
                    '}';
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Matse x) {
            return Integer.compare(this.nummer,x.nummer);
        }
    }

    static class Matsecomperatorname implements Comparator<Matse> {


        @Override
        public int compare(Matse o1, Matse o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    public static void matselisteSortierungNachName() {
        List<Matse> matseList = List.of(new Matse("Tarek", 319),
                new Matse("Daniel", 3), new Matse("Tohmas", 100));
        matseList = new LinkedList<>(matseList);
        Comparator<Matse> cmp = new Comparator<Matse>() {
            @Override
            public int compare(Matse o1, Matse o2) {
                return o1.name.compareTo(o2.name);
            }
        };

        Comparator<Matse> cmp2 = (a, b) -> a.name.compareTo(b.name);
        Comparator<Matse> cmp3 = (a, b) -> Integer.compare(a.nummer, b.nummer);
        System.out.println(matseList);
        Collections.sort(matseList);
        System.out.println(matseList);
        Collections.sort(matseList, cmp3);
        System.out.println(matseList);

        Collections.sort(matseList, cmp);
        System.out.println(matseList);


    }


    public static void main(String[] args) {
        matselisteSortierungNachName();


        /*Object[] matsefeld = new Object[]{
                new Matse("Tarek", 319), new Matse("Daniel", 450), new Matse("Tohmas", 100),
        };
        List<Integer> x = List.of(1, 5, 7, 8, 4);
        x = new LinkedList<>(x);

        List<Matse> matseList = List.of(new Matse("Tarek", 319),
                new Matse("Daniel", 450), new Matse("Tohmas", 100));
        matseList=new LinkedList<>(matseList);

        Collections.sort(matseList);
        System.out.println(matseList);

        Collections.sort(x);
        System.out.println(x);

        System.out.println(Arrays.toString(matsefeld));
        Arrays.sort(matsefeld);
        System.out.println(Arrays.toString(matsefeld));*/

    }
}