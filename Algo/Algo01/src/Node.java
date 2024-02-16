public class Node<T> {
    public T x;
    public Node<T> next;
    public Node<T> prev;

    public Node(T x){
        this.x=x;
    }
}
