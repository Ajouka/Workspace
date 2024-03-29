import java.util.ArrayList;

public class MyDeque<T> {
    public class Node {
        public T value;
        public Node next;
        public Node prev;

        public Node(T value) {
            this.value = value;
        }

    }

    private Node head;

    private Node tail;


    public void addlast(T name) {
        Node newNode = new Node(name);
        if (head == null) {
            this.head = this.tail = newNode;
            head.prev = null;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            tail.next = null;
        }


    }

    public void addFirst(T value) {
        Node newNode = new Node(value);
        if (head == null) {
            this.head = this.tail = newNode;
            head.prev = null;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            head.prev = null;
        }


    }


    public T deleteFirst() {
        T delItem = head.value;
        if (head.next == null) {
            this.head = this.tail = null;

        } else {
            head = head.next;
            head.prev = null;
        }

        return delItem;
    }

    public T deleteLast() {
        T delItem = tail.value;
        if (tail.prev == null) {
            this.head = this.tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        return delItem;
    }

    public ArrayList<T> toArrayList() {
        var e = new ArrayList<T>();
        for (Node current = head; current != null; current = current.next) {
            e.add(current.value);
        }
        return e;

    }

    public ArrayList<T> toReverseArrayList() {
        var e = new ArrayList<T>();
        for (Node current = tail; current != null; current = current.prev) {
            e.add(current.value);
        }
        return e;
    }

    public void add(int index, T elemnt) {
        Node newNode = new Node(elemnt);
        if (index == 0) {
            addFirst(elemnt);
        } else if (index == sizeOf() - 1) {
            addlast(elemnt);
        } else if (index < (sizeOf() - 1) && index > 0) {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.next = current;
            current.prev.next = newNode;
            newNode.prev = current.prev;
            current.prev = newNode;


        }
    }


    public String displayList() {
        if (head == null) {
            return "dll is empty";

        } else {
            StringBuilder sb = new StringBuilder("[");
            for (Node current = head; current != null; current = current.next) {
                if (current == tail) sb.append(current.value);
                else sb.append(current.value).append(", ");
            }
            sb.append("]");
            return sb.toString();

        }
    }

    public int sizeOf() {
        int counter = 0;
        for (Node x = head; x != null; x = x.next) {
            counter++;
        }
        return counter;
    }
}
