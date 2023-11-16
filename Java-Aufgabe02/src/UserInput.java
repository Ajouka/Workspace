import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.List;

public class UserInput {

    public static byte[] fileToByteArray(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(filePath));
        byte[] res = new byte[100];
        for (int i = 0; i < lines.size(); i++) {
            res[i] = (byte) Integer.parseInt(lines.get(i), 2);


        }
        return res;
    }


    public static void fileWriter(String fileName, Datenbestand x, byte[] res) throws FileNotFoundException {


        File f = new File("C:\\Workspace\\Workspace\\Java-Aufgabe02\\src\\" + fileName + ".dat");
        PrintWriter pw = new PrintWriter(f);
        for (int i = 0; i < x.getData().length; i++) {
            pw.println(String.format("%8s", Integer.toBinaryString(x.getData()[i] & 0xFF)).replace(' ', '0') + "  " + String.format("%8s", Integer.toBinaryString(res[i] & 0xFF)).replace(' ', '0'));

        }
        pw.close();


    }

    public static void start() throws IOException {
        String[] options = {"Bytes random generieren", "Filepfad eingeben", "abbrechen"};

        int input = (JOptionPane.showOptionDialog(null, "bitte ihren Option wählen", "Bytes Ergänzer", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, "abbrechen"));
        if (input == 0) {
            Datenbestand x = new Datenbestand();
            byte[] res = x.ergaenzen();


            String input1 = JOptionPane.showInputDialog("bitte Name der Output file eingeben");
            if (input1 == null) return;
            fileWriter(input1, x, res);

        } else if (input == 1) {
            String input1 = JOptionPane.showInputDialog("bitte geben sie die FilePath");
            Datenbestand x = new Datenbestand(fileToByteArray(input1));
            byte[] res = x.ergaenzen();

            String input2 = JOptionPane.showInputDialog("bitte Name der Output file eingeben");
            if (input2 == null) return;
            fileWriter(input2, x, res);


        }

    }


}
