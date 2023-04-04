import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static int binarySearch(ArrayList<Integer> list, int element) {


        int start = 0;
        int end = list.size() - 1;


        while (start <= end) {


            int mid = (start + end) / 2;


            if (element == list.get(mid)) {

                return mid;
            } else if (element < list.get(mid)) {

                end = mid - 1;
            } else {

                start = mid + 1;
            }
        }


        return -1;
    }

    public static void main(String[]args){

        var list=new ArrayList<Integer>();

        long start = System.nanoTime();
        for(int i=0;i<1000000;i++){
            list.add(i);
        }
        long end = System.nanoTime();

        long dauer = end - start;


        System.out.println("Dauer: " + (double)dauer/1000000000 + " sekunden");
long start1=System.nanoTime();
        list.indexOf(1000);
long end1=System.nanoTime();
long dauer1= end1-start1;
System.out.println("Dauer:"+(double)dauer1/1000000000+" sekunden");


        Random x=new Random();
long start2=System.nanoTime();
for(int i=0;i<1000;i++){
    int rand= x.nextInt(list.size());
    int z=list.indexOf(rand);

}
long end2=System.nanoTime();
long dauer2=end2-start2;
        System.out.println("Dauer:"+(double)dauer2/1000000000+" sekunden");
        System.out.println(list.size());


        long start3=System.nanoTime();
        /*for(int i=0;i<1000;i++){
            int rand=x.nextInt(list.size());
            int pos = java.util.Collections.binarySearch(list, rand);
        }*/
        int pos=java.util.Collections.binarySearch(list,500);
        long end3=System.nanoTime();
        long dauer3=end3-start3;
        System.out.println((double)dauer3/1000000000+" sekunden");

        long start4=System.nanoTime();
        binarySearch(list,500);
        long end4=System.nanoTime();
        long dauer4=end4-start4;
        System.out.println((double)dauer4/1000000000+" sekunden" );


    }
}
