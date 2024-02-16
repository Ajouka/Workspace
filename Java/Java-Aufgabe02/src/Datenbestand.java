import java.util.Random;

public class Datenbestand {

    private byte[] data = new byte[100];


    public Datenbestand() {
        Random rand = new Random();
        rand.nextBytes(data);

    }

    public Datenbestand(byte[] a) {
        this.data = a;
    }

    public byte[] getData() {
        return this.data;

    }

    public byte[] byteUpdate() {
        byte[] res = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            Byte a = new Byte(data[i]);

            if (a.isMatched()) {

                res[i] =
                        (byte) ((a.getFirstHalfZeros() << 4)
                                | (4 - a.getFirstHalfZeros()));
            } else res[i] = data[i];
        }

        return res;
    }
}
