import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {
    class Mietwagen implements Comparable<Mietwagen> {
        public String bezeichnung;
        public int alter;
        public int km;
        public int ps;

        public Mietwagen(String bezeichnung, int alter, int km, int ps) {
            this.bezeichnung = bezeichnung;
            this.alter = alter;
            this.km = km;
            this.ps = ps;
        }

        @Override
        public int compareTo(Mietwagen x) {
            return Integer.compare(this.alter,x.alter);
        }
    }

    class Autovermietung {
        private List<Mietwagen> mietwagenList = new ArrayList<>();

        // Sortierung nach Alter mithilfe von `Collections.sort' und des
        // von Ihnen implementierten `Comparable'-Interfaces
        public void sortiereNachAlter() {
            Collections.sort(mietwagenList);


        }

        // Sortierung nach Leistung (PS) mithilfe einer anonymen inneren
        // Unterklasse und `Collections.sort'
        public void sortiereNachPS() {
            Comparator<Mietwagen> cmp=new Comparator<Mietwagen>() {
                @Override
                public int compare(Mietwagen o1, Mietwagen o2) {
                    return Integer.compare(o1.ps,o2.ps);
                }
            };
            Collections.sort(mietwagenList,cmp);


        }

        // Sortierung nach Kilometerstand (KM) mithilfe eines
        // Lambda-Ausdrucks und `Collections.sort'
        public void sortiereNachKM() {
            Comparator<Mietwagen> cmp2=(a,b) -> Integer.compare(a.km,b.km);
            Collections.sort(mietwagenList,cmp2);
        }


    }


}
