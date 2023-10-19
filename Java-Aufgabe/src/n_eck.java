import java.util.ArrayList;

public class  n_eck {

    private ArrayList<point> points=new ArrayList<point>();


    public n_eck(point x){
        points.add(x);



    }

    @Override
    public String toString() {
        return "n_eck{" +
                "points=" + points +
                '}';
    }
}
