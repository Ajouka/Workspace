import java.util.Scanner;

public class Geheim {
    private String nachricht;


    public Geheim(String s) {
        this.nachricht = s;
    }

    public String getNachricht() {
        return nachricht;
    }

    public void setNachricht(String nachricht) {
        this.nachricht = nachricht;
    }

    public char encrypt(char c, int r) {
        if ((int) c + r <= 122) return (char) ((int) c + r);
        else return (char) (((int) c + r) % 123 + 97);
    }

    public void input() {
        Scanner myObj = new Scanner(System.in);

        System.out.println("enter Input to encrypt");
        String input = myObj.nextLine();
        System.out.println("enter the encrypting number(r)");
        int r = Integer.parseInt(myObj.nextLine());


        this.nachricht = "";
        for (int i = 0; i < input.length(); i++) {
            nachricht += encrypt(input.charAt(i), r);

        }
    }
    public void output(){
        System.out.println(getNachricht());;
    }
}
