import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class UserInput {

    public static byte[] fileToByteArray(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(filePath));
        byte[] res = new byte[100];
        for (int i = 0; i < lines.size(); i++) {
            res[i] = (byte) Integer.parseInt(lines.get(i), 2);


        }
        return res;
    }

    public static void main(String[] args) throws IOException {

        String input = (JOptionPane.showInputDialog("wöllen sie die bytes random generieren? y/n"));
        if (Objects.equals(input, "y")) {
            Datenbestand x = new Datenbestand();
            byte[] res = x.ergaenzen();

            for (int i = 0; i < x.data.length; i++) {
                System.out.println(String.format("%8s", Integer.toBinaryString(x.data[i] & 0xFF)).replace(' ', '0') + "  " + String.format("%8s", Integer.toBinaryString(res[i] & 0xFF)).replace(' ', '0'));
            }

        } else if (Objects.equals(input, "n")) {
            String input1 = JOptionPane.showInputDialog("bitte geben sie die FilePath");
             Datenbestand x=new Datenbestand(fileToByteArray(input1));
             byte[] res=x.ergaenzen();

            for (int i = 0; i < x.data.length; i++) {
                System.out.println(String.format("%8s", Integer.toBinaryString(x.data[i] & 0xFF)).replace(' ', '0') + "  " + String.format("%8s", Integer.toBinaryString(res[i] & 0xFF)).replace(' ', '0'));
            }
        }

    }


}
