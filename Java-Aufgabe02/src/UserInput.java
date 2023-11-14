import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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

    public static void start() throws IOException {
        String[]options={"Bytes random generieren","Filepfad eingeben","abbrechen"};

        int input = (JOptionPane.showOptionDialog(null,"bitte ihren Option wählen","Bytes Ergänzer",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,"abbrechen"));
        if (input==0) {
            Datenbestand x = new Datenbestand();
            byte[] res = x.ergaenzen();

            File f= new File("out.dat");
            PrintWriter pw=new PrintWriter(f);
            for(int i=0;i<x.data.length;i++){
                pw.println(String.format("%8s", Integer.toBinaryString(x.data[i] & 0xFF)).replace(' ', '0')+ "  " + String.format("%8s", Integer.toBinaryString(res[i] & 0xFF)).replace(' ', '0'));

            }
            pw.close();

        } else if (input==1) {
            String input1 = JOptionPane.showInputDialog("bitte geben sie die FilePath");
            Datenbestand x = new Datenbestand(fileToByteArray(input1));
            byte[] res = x.ergaenzen();



           File f= new File("C:\\Workspace\\Workspace\\Java-Aufgabe02\\src\\out.dat");
           PrintWriter pw=new PrintWriter(f);
           for(int i=0;i<x.data.length;i++){
            pw.println(String.format("%8s", Integer.toBinaryString(x.data[i] & 0xFF)).replace(' ', '0')+ "  " + String.format("%8s", Integer.toBinaryString(res[i] & 0xFF)).replace(' ', '0'));

           }
           pw.close();



        }

    }


}
