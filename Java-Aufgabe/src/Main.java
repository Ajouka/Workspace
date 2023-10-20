import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        point y= new point(1.2,3.5);


        ArrayList<point> x1=new ArrayList<>();
        x1.add(new point(1,2));
        x1.add(new point(2,3));
        x1.add(new point(5,2));
        x1.add(new point(4,-1));

        n_eck x=new n_eck(x1);

        System.out.println(x.schnittpunkte(new Gerade(new point(3,0),new point(3,3))));
    }
}