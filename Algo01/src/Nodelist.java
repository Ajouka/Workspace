public class Nodelist<T> {

    private Node<T> first;

    private Node<T> last;


    public void addlast(T name) {
        Node<T> newNode = new Node<T>(name);
        if (first == null) {
            this.first = this.last = newNode;
            first.prev = null;
        } else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
            last.next = null;
        }


    }
    public void addFirst(T name) {
        Node<T> newNode = new Node<T>(name);
        if (first == null) {
            this.first = this.last = newNode;
            first.prev = null;
        } else {
            first.prev = newNode;
            newNode.next = first;
            first = newNode;
            first.prev = null;
        }


    }


    public String displayList() {
        if (first == null) {
            return "dll is empty";

        } else {
            StringBuilder sb=new StringBuilder("[");
            for(Node<T> current=first;current!=null;current=current.next){
                if(current==last) sb.append(current.x);
                else sb.append(current.x).append(",");
            }
            sb.append("]");
            return sb.toString();

        }
    }
    public int sizeOf(){
        int counter=0;
        for(Node<T> x=first;x!=null;x=x.next){
            counter++;
        }
        return counter;
    }
    public void deleteFirst(){
        first=first.next;
        first.prev=null;

    }
    public void deleteLast(){
        last=last.prev;
        last.next=null;
    }
    public void add(int index,T elemnt){
        Node<T> newNode=new Node<T>(elemnt);
        if(index==0){
            addFirst(elemnt);
        }
        else if(index==sizeOf()-1){
            addlast(elemnt);
        }
        else if (index<(sizeOf()-1) && index>0 ){
            Node<T> current=first;
            for(int i=0;i<index;i++){
                current=current.next;
            }
            newNode.next=current;
            current.prev.next=newNode;
            newNode.prev=current.prev;
            current.prev=newNode;

            /*newNode.next=current.next;
            current.next=newNode;
            newNode.prev=current;*/

        }
    }
}
