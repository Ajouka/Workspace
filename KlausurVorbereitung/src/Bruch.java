public class Bruch {
    private double nenner;
    private double zaehler;

     static int counter=0;

    public Bruch(double zaehler, double nenner) {
        this.nenner = nenner;
        this.zaehler = zaehler;
        counter++;
    }

    public double getNenner() {
        return nenner;
    }

    public double getZaehler() {
        return zaehler;
    }

    public void setNenner(double nenner) {
        this.nenner = nenner;
        counter++;
    }


    public void setZaehler(double zaehler) {
        this.zaehler = zaehler;
        counter++;
    }



    public String toString() {


        return this.zaehler+"/"+this.nenner;
    }

    public void add(Bruch s){
        this.zaehler+=s.getZaehler();
        this.nenner+=s.getNenner();
        counter++;
    }
}
