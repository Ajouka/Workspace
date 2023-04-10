import java.util.ArrayList;
/*
hier die Linkedlist klasse die, die Interface Ilist implementiert

 */

public class LinkedList implements Ilist {
    private Node head;
    private int count;

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
/*
die TestKlasse, die alle Methoden die Klasse getestet
 */

    public static void testList() {
        LinkedList x = new LinkedList();



        x.insertAt(0,10);
        x.insertAt(1, 11);
        x.insertAt(2,50);
        x.insertAt(3, 20);
        x.insertAt(4,60);
        x.insertAt(5,3);
        x.insertAt(6, 30);
        x.insertAt(0,10);
        x.insertAt(0,100);

        x.removeAt(3);
        System.out.println(x.listToArray());
        System.out.println(x.getAt(0));

        System.out.println(x.search(30));
        System.out.println(x.getCount());
    }



/*
hier wird der Integerzahl zuerst in die Liste hinzufügt könnte ich auch in die insertAt schreiben
 */

    public void insertFirst(int element) {
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        count++;
    }

/*
hie wird eine Integerzahl an bestimmte index in die List hinzufügt
ich wüsste auch nicht ob der gleiche Zahl mehrmals in die List vorhanden sein kann
steht gar nix in die Aufgabestellung 
 */
    @Override
    public void insertAt(int index, int element) {
        if (index < 0 || index > count) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            if (index == 0) insertFirst(element);
            else {

                Node current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                Node newNode = new Node(element);
                newNode.next = current.next;
                current.next = newNode;
                count++;
            }


        }

    }
/*
hier wird eine Integerzahl an bestimmte index gelöscht
 */
    @Override
    public void removeAt(int index) {
        if (index < 0 || index > count) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            if (index == 0) {
                head = head.next;

            } else {
                Node current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                current.next = current.next.next;
                count--;
            }
        }
    }
/*
hier wird eine Zahl an einer bestimmten Position auszulesen
 */
    @Override
    public int getAt(int index) {
        if (index < 0 || index > count - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node currrent = head;
        if (index == 0) return head.data;
        else {
            for (int i = 0; i < index; i++) {
                currrent = currrent.next;
            }
            return currrent.data;
        }
    }
/*
hier wird einen Wert gesucht, ob es in die List schon vorhanden ist oder nicht und wenn
 ja, wird die position den Wert zurückgegeben
 */
    @Override
    public int search(int element) {
        Node current = head;
        for (int i = 0; i < count; i++) {
            if (current.data == element) {
                return i;
            } else current = current.next;
        }

        return -1;
    }
    /*
    hier wird alle Werte die Liste gelöscht hab einfach die removeAt methode benutzt
     */

    @Override
    public void clear() {
        for (int i = 0; i < count; i++) {
            removeAt(i);
        }
    }
    /*
    hier wird die Anzahl der enthaltenen Elemente zurückzugeben
     */

    @Override
    public int getCount() {
        return count;
    }
    public ArrayList<Integer> listToArray() {
        var e = new ArrayList<Integer>();


        for (Node current = head; current != null; current = current.next) {
            e.add(current.data);
        }
        return e;
    }


}
