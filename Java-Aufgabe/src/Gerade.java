// Eine Klasse, die eine Gerade in der Form y = mx + b repräsentiert
public class Gerade {

    private double m;

    private double b;


    public Gerade(point p1, point p2){

        m = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
        b = p1.getY() - m * p1.getX();



    }

    public double getB() {
        return b;
    }
    public double getM() {
        return m;
    }


    public point schnittpunkt(Gerade other) {
        // Parallele Geraden haben keinen Schnittpunkt
        if (m == other.getM()) {
            return null;
        } else {
            // Berechne den Schnittpunkt mit einer anderen Geraden
            double x = (other.getB() - b) / (m - other.getM());
            double y = m * x + b;
            return new point(x, y);
        }
    }

}
