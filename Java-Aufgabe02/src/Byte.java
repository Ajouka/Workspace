public class Byte {
    private int firstHalf;
    private int secondHalf;

    private int firstHalfZeros;

    private int secondHalfZeros;


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

}
