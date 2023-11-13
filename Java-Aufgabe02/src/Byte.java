public class Byte {
public int firstHalf;
public int secondHalf;


public Byte(byte b){
    this.firstHalf=(b >> 4) & 0x0F;
    this.secondHalf=b & 0x0F;


}
public int countZeros(int x){
    return Integer.bitCount(~x&0x0F);


}
public boolean erkennen(){
    return countZeros(firstHalf) == countZeros(secondHalf);

}

}
