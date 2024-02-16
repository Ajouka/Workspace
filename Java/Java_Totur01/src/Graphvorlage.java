import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public interface Graphvorlage {  // nur eine Huelle bzw. ein Namensraum!


    /**
     * Hier werden die grundlegenden Datenstrukturen und Operationen fuer
     * einen Graphen ohne Gewichte definiert.
     * Ein solcher Graph beruht dabei auf Adjazenzlisten (s. Vorlesung).<br>
     */
    public class Graph {

        public boolean isDirected() {
            for (int i = 1; i <= getVertexCount(); i++) {
                List<Integer> adjacents = getAdjacent(i);
                for (int j : adjacents) {
                    if (!getAdjacent(j).contains(i)) return true;
                }
            }
            return false;
        }
        public List<Integer> bfs(int start) {
            List<Integer> result = new ArrayList<>();
            QueueGraph queue = new QueueGraph();
            queue.addVisited(start);
            while (!queue.isEmpty()) {
                int node = queue.removeVisited();
                result.add(node);
                for (int neighbor : getAdjacent(node)) {
                    if (!queue.visited(neighbor)) {
                        queue.addVisited(neighbor);
                    }
                }
            }
            return result;
        }



        /** Speicherung per Adjazenzlisten, Indizes 1..n (n: Knotenanzahl) */
        private ArrayList<Integer>[] adj;
        /** Anzahl der Kanten */
        private int edgeCount;

        /**
         * Erzeugt leeren Graphen mit der angegebenen Anzahl an Knoten
         *
         * @param  v  die Anzahl der Knoten
         */
        public Graph(int v) {
            createGenericArray(v + 1);                  // Index 0 unbenutzt!
            for (int i = 0; i < adj.length; i++) {      // fuer lauter leere
                adj[i] = new ArrayList<Integer>();        // Adjazenzlisten sorgen
            }
            this.edgeCount = 0;                 // => Es gibt noch keine Kanten.
        }

        /**
         * Erzeugt einen Graphen mit v Knoten und e zufaelligen Kanten
         *
         * @param  v  die Anzahl der Knoten
         * @param  e  die Anzahl der zufaelligen Kanten
         */
        public Graph(int v, int e) {
            this(v);
            Random zufall = new Random(9);  // mit Seed => immer dieselben Zufallszahlen
            for (int i = 0; i < e; i++) {   // e Kanten
                int k1 = 1;
                int k2 = 1;
                do {                             // 2 Knoten zufaellig waehlen:
                    k1 = zufall.nextInt(v) + 1;    //   k1 aus [1;v]
                    k2 = zufall.nextInt(v) + 1;    //   k2 aus [1;v]
                } while (adj[k1].contains(k2));  // bis Kante von k1 nach k2 neu ist
                adj[k1].add(k2);                 // Kante von k1 nach k2 anlegen
            }
            this.edgeCount = e;
        }

        /**
         * Erzeugt einen Graphen aus der angegebenen Kantenliste
         *
         * @param  list  die Kantenliste
         */
        public Graph(int[] list) {
            this(list[0]);                        // => Graph mit list[0] Knoten
            for (int i = 0; i < list[1]; i++) {   // list[1] Kanten definieren
                adj[list[2 + i * 2]].add(list[3 + i * 2]);
            }
            this.edgeCount = list[1];
        }

        /**
         * Legt n Nullzeiger fuer die Adjazenzlisten im entsprechenden Attribut
         * dieser Klasse an.
         * Das soll dazu dienen, eine derartige Operation auf eine einzige
         * Stelle im Programm zu konzentrieren, um die Warnungen, die Java
         * bei der Erzeugung eines generischen Arrays immer produziert,
         * gezielt abstellen zu koennen.
         *
         * @param  n  Anzahl der Adjazenzlisten
         */
        @SuppressWarnings({"unchecked","rawtypes"})
        private void createGenericArray(int n) {
            this.adj = new ArrayList[n];                       // => 2 Warnungen
        }

        /**
         * Gibt die Anzahl der Knoten zurueck
         *
         * @return  die Anzahl der Knoten
         */
        public int getVertexCount() {
            return this.adj.length - 1;                     // Platz 0 unbelegt!
        }

        /**
         * Gibt die Anzahl der Kanten zurueck
         *
         * @return  die Anzahl der Kanten
         */
        public int getEdgeCount() {
            return edgeCount;
        }

        /**
         * Fuegt eine Kante hinzu.
         *
         * @param  from  Anfangsknoten der Kante
         * @param  to    Endknoten     der Kante
         */
        public void addEdge(int from, int to) {
            adj[from].add(to);
            ++edgeCount;
        }

        /**
         * Gibt eine Liste mit allen direkten Nachfolgern des angegebenen Knotens
         * zurueck.
         *
         * @param   v  der Knoten
         * @return     die Liste der direkten Nachfolger des Knotens
         */
        public List<Integer> getAdjacent(int v) {
            return new ArrayList<Integer>(adj[v]);              // nur als Kopie
        }

        /**
         * Melden, wieviele Kanten vom genannten Knoten ausgehen.
         *
         * @param   v  gegebener Knoten
         * @return     Anzahl der von v ausgehenden Kanten
         */
        public int ausgangsgrad(int v) {
            return this.adj[v].size();  // Anzahl der Elemente der Adjazenzliste
        }                             // des Knotens mit dem Index v

        /**
         * Der Graph als String: direkte Wiedergabe der internen Darstellung.
         *
         * @return  Stringdarstellung des Graphen
         */
        public String toString() {
            String ret = "[";
            for (int i = 1; i < adj.length; i++) {           // eine Liste aller
                ret = ret + adj[i];                            // Adjazenzlisten
            }
            ret = ret + "]";
            return ret;
        }
    }


    /**
     * Klasse mit einer vorgefertigten Testfunktion zur Klasse {@link Graph}.<br>
     */
    public class GraphTest {

        /** Kantenliste fuer den ersten Testgraphen */
        private static int[] vlist = {
                6, 10,       // 6 Knoten, 10 Kanten
                1, 5, 1, 4,  // alle Knotenpaare fuer Kanten mit 1 als Anfangsknoten
                2, 3, 2, 6,  // ...
                3, 4, 3, 5,  // ...
                4, 5, 4, 6,  // ...
                5, 6,        // ...
                6, 4         // alle Knotenpaare fuer Kanten mit 6 als Anfangsknoten
        };
        // Den Graphen kann man sich so vorstellen:
        //
        //        +---------3<----2
        //        |         |     |
        //        |   1     |     |
        //        |   |\    |     |
        //        |   | \   |     |
        //        |   |  \  |     |
        //        |   |   \ |     |
        //        |   v    vv     v
        //        +-->5<----4<--->6<-+
        //            |              |
        //            +--------------+

        /**
         * Pseudokantenliste fuer den zweiten Testgraphen.
         * Seine Kanten muessen noch zufaellig bestimmt werden.
         */
        private static int[] vlist2 = { 5, 20 };    // v=5 Knoten, e=20 Zufallskanten

        /** eine Liste aller hier vorhandenen Kantenlisten */
        private static List<int[]> kantenlisten = List.of(vlist, vlist2);

        /**
         * Die Grundausstattung der Klasse {@link Graph} testen
         * und die Liste der benutzten Kantenlisten liefern.
         * Diese Liste kann so auch in anderen Testklassen benutzt werden.
         *
         * @return  Liste der Kantenlisten der getesteten Graphen
         */
        public static List<int[]> testGraph() {
            Graph g = new Graph(0);
            System.out.println();
            System.out.println("Test der Grundausstattung der `" + g.getClass() + "':");
            for (int[] vlist: GraphTest.kantenlisten) {
                if (vlist.length < vlist[1]) {   // Pseudokantenliste (noch ohne Kanten)?
                    int v = vlist[0];              // Knotenanzahl
                    int e = vlist[1];              // Kantenanzahl
                    g = new Graph(v, e);           // => Graph mit v Knoten
                }                                //    und e Zufallskanten
                else                             // echte Kantenliste?
                    g = new Graph(vlist);          // => Graph aus Kantenliste
                System.out.println("g = " + g);
            }
            return GraphTest.kantenlisten;
        }

        /**
         * Die Klasse {@link Graph} moeglichst komplett testen.
         *
         * @param  args  was dem Programmaufruf uebergeben wurde
         */
        public static void main(String[] args) {
            testGraph();
        }
    }


    /** das `main' der Huellklasse (dient nur zum Anstossen des eigentlichen `main' */
    public static void main(String[] args) {
        GraphTest.main(args);             // das eigentliche `main' aufrufen
    }
}                                               // Ende der Huelklklasse

