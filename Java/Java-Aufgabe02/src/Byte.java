public class Byte {
    private final int firstHalf;
    private final int secondHalf;

    private final int firstHalfZeros;

    private final int secondHalfZeros;


    public Byte(byte b){
        this.firstHalf=(b >> 4) & 0x0F;
        this.secondHalf=b & 0x0F;
        this.firstHalfZeros=Integer.bitCount(~firstHalf&0x0F);
        this.secondHalfZeros=Integer.bitCount(~secondHalf&0x0F);

    }
    public int getFirstHalfZeros(){
        return this.firstHalfZeros;

    }
    public boolean isMatched(){
        return firstHalfZeros == secondHalfZeros;

    }

    public int getFirstHalf() {
        return firstHalf;
    }

    public int getSecondHalf() {
        return secondHalf;
    }



}
