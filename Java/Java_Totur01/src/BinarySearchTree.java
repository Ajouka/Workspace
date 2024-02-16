import java.util.LinkedList;
import java.util.Queue;

/**
 * Ein binaerer Suchbaum mit ganzen Zahlen als Datensatz:
 * Vorlage zur Loesung von Aufgaben zu binaeren Suchbaeumen.
 * Als Operationen stehen `contains' und `insert' zur Verfuegung,
 * weiterhin `clear' und das rekursive `baumInOrder'.
 */
public class BinarySearchTree {

    /**
     * Die Knotenklasse als statische innere Klasse.
     */
    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        // damit man nicht `knoten.getValue()' bei der Ausgabe mit `println' schreiben muss:
        public String toString() {
            return this.value + "";
        }

        public int getValue() {
            return this.value;
        }

        public Node getLeft() {
            return this.left;
        }

        public Node getRight() {
            return this.right;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setLeft(Node node) {
            this.left = node;
        }

        public void setRight(Node node) {
            this.right = node;
        }
    }

    /**
     * Baumwurzel
     */
    protected Node root;                // wegen der Vererbung `protected'

    /**
     * Herausfinden, ob ein gewisser Datensatz schon im binaeren Suchbaum enthalten ist.
     *
     * @param   data  zu suchender Datensatz
     * @return true: Datensatz ist vorhanden; false: Datensatz ist nicht vorhanden.
     */


    /**
     * Besuchtmarken sind in diesem Fall nicht nötig, da die Breitensuche alle Knoten eines
     * Binärbaums in der Reihenfolge ihrer Tiefe besucht. Jeder Knoten wird nur einmal besucht und
     * es gibt keine Möglichkeit, einen Knoten mehrmals zu besuchen.
     */
    public int knotensummeBfs() {
        if (root == null) return 0;
        int sum = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            sum += node.value;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return sum;
    }


    public boolean contains(int data) {
        Node temp = root;
        while (temp != null) {
            if (temp.getValue() == data) {
                return true;
            }
            if (temp.getValue() > data) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
        return false;
    }

    /**
     * Einen neuen Datensatz in den binaeren Suchbaum einfuegen.
     *
     * @param data einzufuegender Datensatz
     * @return true: Datensatz wurde eingefuegt; false: Datensatz war schon vorhanden.
     */
    public boolean insert(int data) {
        if (root == null) {
            root = new Node(data);
            return true;
        }

        Node temp = root;
        while (temp.getValue() != data) {
            if (temp.getValue() > data) {
                if (temp.getLeft() == null) {
                    temp.setLeft(new Node(data));
                    return true;
                }
                temp = temp.getLeft();
            } else {
                if (temp.getRight() == null) {
                    temp.setRight(new Node(data));
                    return true;
                }
                temp = temp.getRight();
            }
        }
        return false;
    }

    /**
     * den Baum leeren
     */
    public void clear() {
        this.root = null;
    }

    /**
     * den Baum inorder ausgeben, also bei einem Suchbaum in sortierter Reihenfolge
     */
    public void baumInOrder() {
        System.out.println("Baumausgabe inorder:");
        baumInOrder(this.root);             // Rekursion anstossen
    }

    // rekursive Hilfsmethode mit Inorder-Durchlauf
    private void baumInOrder(Node b) {
        if (b != null) {                    // Baum nicht leer?
            baumInOrder(b.getLeft());         // => linken Teilbaum ausgeben
            System.out.println(b);            // => Baumknoten selbst ausgeben
            baumInOrder(b.getRight());        // => rechten Teilbaum ausgeben
        }
    }

    /**
     * Den uebergebenen binaeren Suchbaum mit den danach gegebenen beliebig
     * vielen ganzen Zahlen fuellen, die auch als Array vorliegen duerfen.
     * <p>
     * Gegenueber einem Konstruktor besteht hier der Vorteil, dass man
     * auch einen abgeleiteten Suchbaum bevoelkern kann, der aber dann
     * vorher leer angelegt worden sein muss.
     *
     * @param baum  zu bevoelkernder Baum
     * @param werte variable Anzahl ganzzahliger Werte bzw. Array davon
     */
    public static void baumBauen(BinarySearchTree baum, int... werte) {
        for (int wert : werte) {
            baum.insert(wert);
        }
    }

    public double average() {
        if (root == null) {
            return 0;
        }

        return (double) sumNodes(root) / countNodes(root);
    }

    private int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    private int sumNodes(Node node) {
        if (node == null) {
            return 0;
        }
        return node.value + sumNodes(node.left) + sumNodes(node.right);
    }


    /**
     * Diese Klasse testen und zeigen, wie `baumBauen' zu benutzen ist.
     *
     * @param args Parameter des Programmaufrufs
     */
    public static void main(String[] args) {
        BinarySearchTree baum = new BinarySearchTree();

        // Das ist die normale Art, `baumBauen' aufzurufen:
        baumBauen(baum, 4, 5, 6, 3);
        // => Der Suchbaum sieht so aus:
        //           4
        //          / \
        //         /   \
        //        3     5
        //               \
        //                6

        // Aber es geht auch anders, wozu wir zunaechst den Baum loeschen:
        baum.clear();
        int[] bauminhalte = {6, 3, 8, 7};    // Zahlen fuer die Baumknoten
        baumBauen(baum, bauminhalte);          // Suchbaum damit aufbauen
        for (int wert : bauminhalte) {          // diesen nun ueberpruefen
            System.out.println(wert + ": " +
                    baum.contains(wert));
        }

        // Baum sortiert ausgeben:
        baum.baumInOrder();
        System.out.println(baum.average());

    }
}

