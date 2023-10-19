import java.lang.reflect.Array;

public class point {
    private double x,y;

    public point(double x, double y) {
        this.x=x;
        this.y=y;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    @Override
    public String toString() {
        return "{" + x +
                "," + y +
                "}";
    }
}
