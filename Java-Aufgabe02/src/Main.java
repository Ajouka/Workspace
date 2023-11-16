import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        Datenbestand a =new Datenbestand();

        byte x=70;

        System.out.println(Integer.toBinaryString(x));
        System.out.println(String.format("%8s",Integer.toBinaryString(x&0xFF).replace(' ','0')));

        //UserInput.start();


    }
}
