/*
hier ist die Interface aus Afugabe 01 mit die methoden implementation
 */
public interface Ilist {
    void insertAt(int index,int element);
    void removeAt(int index);
    int getAt(int index);
    int search(int element);
    void clear();
    int getCount();
}
