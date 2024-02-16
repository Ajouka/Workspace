import java.util.ArrayList;
import java.util.List;

public class Einkommensteuer {
    private List<Steuersatz> steuermodell = new ArrayList<>();

    private void addRange(Steuersatz steuersatz) {
        if (steuersatz.obereGrenze < 0 || steuersatz.steuersatz < 0) {

            throw new TaxException("negative parameter im Steuersatz");
        } else steuermodell.add(steuersatz);

    }

    private void validate() {
        double unteregrenze = 0;
        for (int i = 0; i < steuermodell.size(); i++) {
            if (steuermodell.get(i).obereGrenze < unteregrenze) {
                throw new TaxException("die obere grenzen stimmen nicht ");
            }
            if (i==steuermodell.size()-1 && steuermodell.get(i).obereGrenze!=Double.MAX_VALUE){
                throw new RuntimeException("");
                //throw new TaxException("the last range hat nicht den Double.Max value ");
            }

        }



    }

    public Einkommensteuer(List<Steuersatz> bereichListe) {

    }

    public class TaxException extends RuntimeException {

        public TaxException(String fehlertext) {
            super(fehlertext);
        }

    }

    public class Steuersatz {
        private double obereGrenze;
        private double steuersatz;

        public double getObereGrenze() {
            return obereGrenze;
        }

        public double getSteuersatz() {
            return steuersatz;
        }

        public Steuersatz(double obereGrenze, double steuersatz) {
            this.obereGrenze = obereGrenze;
            this.steuersatz = steuersatz;

        }

        public Steuersatz(Steuersatz s) {

            this.obereGrenze = s.obereGrenze;
            this.steuersatz = s.steuersatz;
        }

    }


}