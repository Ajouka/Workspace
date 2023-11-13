import java.util.LinkedList;
import java.util.Random;

public class Datenbestand {

    public byte[] data=new byte[100];


    public Datenbestand(){
        Random rand = new Random();
        rand.nextBytes(data);

    }
    public Datenbestand(byte[]a){
        this.data=a;
    }

    public byte[] ergaenzen(){
        byte[] res=new byte[data.length];
        for(int i=0;i<data.length;i++){
         Byte a=new Byte(data[i]);
         int firstHalfZeros = a.countZeros(a.firstHalf);
         if(a.erkennen()){
             res[i]=(byte) ((firstHalfZeros << 4) | (4 - firstHalfZeros)) ;
         }
         else res[i]=data[i];
        }

        return res;
    }
}
