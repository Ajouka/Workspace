import java.util.List;
import java.util.Arrays;

/**
 * Test der Klasse {@link MyGraph}
 */
public class MyGraphTest {

    /**
     * Die 5 zusaetzlich zu implementierenden Methoden von {@link MyGraph} testen.
     * Dabei werden die Testgraphen aus den gegebenen Kantenlisten erzeugt,
     * die auch nur scheinbare Kantenlisten sein koennen, s. {@link GraphTest}.
     * Direkt getestet werden hier nur die ersten beiden Methoden, die
     * restlichen per {@link testMyGraphRest}.
     *
     * @param  kantenlisten  Liste von Kantenlisten der zu testenden Graphen
     */
    private static void testMyGraph(List<int[]> kantenlisten) {

        MyGraph g = new MyGraph(1, 1);  // erstmal irgendwie erzeugen
        System.out.println();
        System.out.println("Test der fuer `" + g.getClass() + "' zu implementierenden Methoden:");

        int nummer = 1;
        for (int[] vlist: kantenlisten) {
            System.out.println();
            System.out.println("Test des " + nummer + ". Graphen g:");
            if (vlist.length < vlist[1]) {   // Pseudokantenliste (noch ohne Kanten)?
                int v = vlist[0];              // Knotenanzahl
                int e = vlist[1];              // Kantenanzahl
                g = new MyGraph(v, e);         // => Graph mit v Knoten
            }                                //    und e Zufallskanten
            else                             // echte Kantenliste?
                g = new MyGraph(vlist);        // => Graph aus Kantenliste
            System.out.println("g-Kantenliste = " + g.getEdgeList());
            System.out.println("g-Knotenliste = " + g.getVertexList());
            testMyGraphRest(g);
            ++nummer;
        }
    }

    /**
     * Hier werden auch noch die restlichen Methoden der zu implementierenden
     * Klasse getestet.
     * Genauer sind das:
     * <ul>
     *   <li>getAdjacencyMatrix</li>
     *   <li>bfs</li>
     *   <li>getUnreachableVertices</li>
     * </ul>
     * @param  g  zu testender Graph
     */
    private static void testMyGraphRest(MyGraph g) {
        int[][] adjazenzmatrix = g.getAdjacencyMatrix();
        System.out.println("g-Adjazenzmatrix = " + Arrays.deepToString(adjazenzmatrix));
        int start = 1;
        System.out.println("Startknoten fuer Breitensuche = " + start);
        var liste = g.bfs(start);
        System.out.println("Graph g: Liste der durchlaufenen Knoten = " + liste);
    /* DO 20. 4. 2023, jd: ab SS 2023 nicht mehr verlangt:
    System.out.println("Startknoten fuer Tiefensuche = " + start);
    liste = g.dfs(start);
    System.out.println("Graph g: Liste der durchlaufenen Knoten = " + liste);
    */

        // Wenn man bei Knoten 1 im 1. Testgraphen g startet, sind
        // offensichtlich nur die Knoten 4, 5 und 6 erreichbar, was
        // Breiten- und Tiefensuche bestaetigen. Also sind von 1 aus
        // betrachtet die Knoten 2 und 3 unerreichbar. Das laesst sich
        // auch gut am Bild des Graphen erkennen, da von 2 und 3 nur
        // Kanten ausgehen und nicht umgekehrt.
        System.out.println("Startknoten = " + start);
        liste = g.getUnreachableVertices(start);
        System.out.println("Graph g: Liste der unerreichbaren Knoten = " + liste);
    }

    /**
     * Die Klasse {@link MyGraph} moeglichst komplett testen.
     *
     * @param  args  was dem Programmaufruf uebergeben wurde
     */
    public static void main(String[] args) {
        List<int[]> kantenlisten = GraphTest.testGraph();  // nur `Graph'
        testMyGraph(kantenlisten);                         // auch `MyGraph'
    }
}

