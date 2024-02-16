import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class UserInput {
    public static void main(String[] args) {

        ArrayList<point> allPoints = userinput_points_nEck();
        n_eck n_Eck = new n_eck(allPoints);
        ArrayList<point> twoPoints = userinput_points_twoPoints();
        Gerade line = new Gerade(twoPoints.get(0), twoPoints.get(1));
        ArrayList<point> schnittpunkte = n_Eck.schnittpunkte(line);
        if (schnittpunkte.size() > 0) {
            System.out.println("Das n-Eck hat mit der Geraden folgende Schnittpunkte:");
            for (point element : schnittpunkte) {
                System.out.println(element);
            }
        } else {
            System.out.println("Das n-Eck hat mit der Geraden keine Schnittpunkte!");
        }
    }

    public static ArrayList<point> userinput_points_nEck() {
        String[] input_n = new String[1];
        while (input_n.length % 2 != 0 || (input_n.length < 4)) {
            String s = JOptionPane
                    .showInputDialog("Bitte geben Sie min. 2 Punkte, in der Form x,y,x,y für das n-Eck an!");
            input_n = s.split(",");
        }
        ArrayList<point> allPoints = new ArrayList<>();
        for (int i = 0; i < input_n.length - 1; i += 2) {
            allPoints.add(new point(Double.parseDouble(input_n[i]), Double.parseDouble(input_n[i + 1])));
        }
        return allPoints;
    }

    public static ArrayList<point> userinput_points_twoPoints() {
        String[] input_p = new String[4];
        while (input_p.length != 4
                || (Objects.equals(input_p[0], input_p[2]) && Objects.equals(input_p[1], input_p[3]))) {
            String s = JOptionPane.showInputDialog(
                    "Bitte geben Sie zwei verschiedene Punkte in der Form x,y,x,y an! Anschließend werden die Schnittpunkte des n-Ecks mit der Strecke durch diese beiden Punkte ausgegeben!");
            input_p = s.split(",");
        }
        ArrayList<point> twoPoints = new ArrayList<>();
        for (int i = 0; i < input_p.length - 1; i += 2) {
            twoPoints.add(new point(Double.parseDouble(input_p[i]), Double.parseDouble(input_p[i + 1])));
        }
        return twoPoints;
    }






}