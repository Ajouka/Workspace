public class converter2 implements StringConverter{
    static int counter=0;
    @Override
    public String converter(String s) {
        counter++;
        return counter+": "+s;
    }
}
