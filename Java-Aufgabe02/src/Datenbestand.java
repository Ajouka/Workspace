import java.util.Random;

public class Datenbestand {

    private byte[] data=new byte[100];


    public Datenbestand(){
        Random rand = new Random();
        rand.nextBytes(data);

    }
    public Datenbestand(byte[]a){
        this.data=a;
    }

    public byte[] getData(){
        return this.data;

    }

    public byte[] ergaenzen(){
        byte[] res=new byte[data.length];
        for(int i=0;i<data.length;i++){
         Byte a=new Byte(data[i]);
         //int firstHalfZeros = Byte.countZeros(a.firstHalf);
         if(a.isMatched()){
             res[i]=(byte) ((a.getFirstHalfZeros() << 4) | (4 - a.getFirstHalfZeros())) ;
         }
         else res[i]=data[i];
        }

        return res;
    }
}
//Bitverschiebung (<<): firstHalfZeros << 4 verschiebt die Bits der Variable firstHalfZeros um 4 Stellen nach links.
// In Binärdarstellung bedeutet dies, dass vier Nullen an das rechte Ende der Zahl angehängt werden.
// Dies hat den Effekt, dass der Wert der Zahl mit 16 multipliziert wird (da 2 hoch 4 gleich 16 ist).
//
//Bitweise ODER-Operation (|): Die ODER-Operation wird auf die Ergebnisse der Bitverschiebung und 4 - firstHalfZeros angewendet.
// Das bedeutet, dass für jedes Bit, wenn in der Bitverschiebung oder in 4 - firstHalfZeros eine ‘1’ vorhanden ist,
// das entsprechende Bit im Ergebnis auf ‘1’ gesetzt wird. Wenn in beiden eine ‘0’ vorhanden ist, wird das entsprechende Bit im Ergebnis auf ‘0’ gesetzt.