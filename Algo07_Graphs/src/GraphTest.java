import java.util.List;

/**
 * Klasse mit einer vorgefertigten Testfunktion zur Klasse {@link Graph}.<br>
 * Vorgabe zur Loesung zu algo-pr06 im SS 2023.
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
     * Diese Liste kann dann auch in {@link MyGraphTest} benutzt werden.
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

