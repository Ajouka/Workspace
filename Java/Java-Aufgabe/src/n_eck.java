import java.util.ArrayList;

public class  n_eck {

    private ArrayList<point> points=new ArrayList<point>();


    public n_eck(point x){
        points.add(x);



    }
    public n_eck(ArrayList<point> punkte) {
        this.points = punkte;
    }

    public String toString() {
        String s = "n-Eck mit den Eckpunkten ";
        for (point p : points) {
            s += p.toString() + ", ";
        }
        s = s.substring(0, s.length() - 2); // Entferne das letzte Komma und Leerzeichen
        return s;
    }

    public ArrayList<point> schnittpunkte(Gerade gerade) {
        // Erstelle eine Liste für die Schnittpunkte
        ArrayList<point> schnittpunkte = new ArrayList<point>();
        for (int i = 0; i < points.size(); i++) {
            // Erstelle eine Gerade aus jedem benachbarten Paar von Punkten des n-Ecks
            point p1 = points.get(i);
            point p2 = points.get((i + 1) % points.size());
            Gerade seite = new Gerade(p1, p2);
            // Berechne den Schnittpunkt mit der gegebenen Geraden
            point sp = seite.schnittpunkt(gerade);
            if (sp != null) {
                // Überprüfe, ob der Schnittpunkt auf der Seite des n-Ecks liegt
                if (Math.min(p1.getX(), p2.getX()) <= sp.getX() && sp.getX() <= Math.max(p1.getX(), p2.getX()) &&
                        Math.min(p1.getY(), p2.getY()) <= sp.getY() && sp.getY() <= Math.max(p1.getY(), p2.getY())) {
                    schnittpunkte.add(sp);
                }
            }
        }
        return schnittpunkte;
    }

}
