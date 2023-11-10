import java.util.Random;

public class test {

    public static void main(String[] args) {
        byte x=125;
        // Füllen Sie das Array data mit Ihren Daten





            int firstHalf = (x >> 4) & 0x0F;
            int secondHalf = x & 0x0F;

            int firstHalfZeros = Integer.bitCount(~firstHalf & 0x0F);
            int secondHalfZeros = Integer.bitCount(~secondHalf & 0x0F);

            if (firstHalfZeros == secondHalfZeros) {
                x = (byte) ((4 - firstHalfZeros)|(firstHalfZeros << 4));
            }

        System.out.println(Integer.parseInt("01111101",2));

        System.out.println(String.format("%8s", Integer.toBinaryString(x )).replace(' ', '0'));

        }







    }


