import java.util.Random;

public class Datensatz {

    private byte[] data = new byte[100];


    public Datensatz() {
        Random rand = new Random();
        rand.nextBytes(data);

    }

    public Datensatz(byte[] a) {
        this.data = a;
    }

    public byte[] getData() {
        return this.data;

    }

    public StringBuilder getDataString(){
        StringBuilder x = new StringBuilder();

        for(byte d:data){
            x.append(Integer.toBinaryString(d));
        }


        return x;
    }

}
