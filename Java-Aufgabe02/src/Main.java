import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Main {


    public static void main(String[]args){

        byte[] data = new byte[100];
        // Füllen Sie das Array data mit Ihren Daten
        Random rand = new Random();


        rand.nextBytes(data);
        byte x=data[0];
        int firstHalf=(x>>4)&0x0F;
        System.out.println(Arrays.toString(data));
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.bitCount(firstHalf&0x0F));




    }






}