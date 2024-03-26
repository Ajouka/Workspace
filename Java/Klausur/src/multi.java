import java.util.LinkedList;

public class multi implements StringConverter {
    LinkedList<StringConverter> sc = new LinkedList<StringConverter>();


    public void addConverter(StringConverter s){
        this.sc.add(s);


    }


    public String converter(String s) {


        for (StringConverter a : sc) {

            s = a.converter(s);
        }
        return s;
    }
}
