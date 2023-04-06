import java.util.ArrayList;

public class LinkedList implements Ilist {
    private Node head;
    private int count;

    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public ArrayList<Integer> listToArray() {
        var e=new ArrayList<Integer>();



        for(Node current=head;current!=null;current=current.next){
            e.add(current.data);
        }
        return e;
    }

    public void insertLast(int element) {

        if (head == null) {
            insertFirst(element);

        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(element);
        }
        count++;
    }

    public void insertFirst(int element) {
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        count++;
    }


    @Override
    public void insertAt(int index, int element) {
        if (index < 0 || index > count - 1) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            if(index==0)insertFirst(element);
            else {

                Node current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                Node newNode = new Node(element);
                newNode.next = current.next;
                current.next = newNode;
            }
            count++;




        }

    }

    @Override
    public void removeAt(int index) {
        if (index < 0 || index > count - 1) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            if(index==0){
                head=head.next;

            }
            else {
                Node current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                current.next = current.next.next;
                count--;
            }
        }
    }

    @Override
    public int getAt(int index) {
        if (index < 0 || index > count - 1){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node currrent=head;
        if(index==0)return head.data;
        else {
            for (int i = 0; i < index; i++) {
            currrent=currrent.next;
            }
            return currrent.data;
        }
    }

    @Override
    public int search(int element) {
        Node current=head;
        for(int i=0;i<count-1;i++){
            if(current.data==element){
                return i;
            }
            else current=current.next;
        }

        return -1;
    }

    @Override
    public void clear() {
        for(int i=0;i<count;i++){
            removeAt(i);
        }


    }

    @Override
    public int getCount() {
        return count;
    }
}