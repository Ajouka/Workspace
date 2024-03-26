public class converter3 implements StringConverter{

    private char a;


    public converter3(char a){
        this.a=a;
    }
    @Override
    public String converter(String s) {
        return s.replace(' ',a);
    }
}
