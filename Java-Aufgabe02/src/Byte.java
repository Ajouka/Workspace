public class Byte {
    public int firstHalf;
    public int secondHalf;

    public int firstHalfZeros;

    public int secondHalfZeros;


    public Byte(byte b){
        this.firstHalf=(b >> 4) & 0x0F;
        this.secondHalf=b & 0x0F;
        this.firstHalfZeros=Integer.bitCount(~firstHalf&0x0F);
        this.secondHalfZeros=Integer.bitCount(~secondHalf&0x0F);

    }

    public boolean isMatched(){
        return firstHalfZeros == secondHalfZeros;

    }

}
