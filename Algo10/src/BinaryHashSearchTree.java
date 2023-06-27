import java.util.HashMap;

public class BinaryHashSearchTree<T extends Comparable<T>> {
    private HashMap<Integer, T> hash = new HashMap<>();

    public void add(T element) {
        if (element == null) return;
        int index = 1;
        while (hash.containsKey(index)) {
            T current = hash.get(index);
            int cmp = element.compareTo(current);
            if (cmp == 0) return;
            index = (cmp < 0) ? 2 * index : 2 * index + 1;
        }
        hash.put(index, element);
    }

    public boolean contains(T element) {
        if (element == null) return false;
        int index = 1;
        while (hash.containsKey(index)) {
            T current = hash.get(index);
            int cmp = element.compareTo(current);
            if (cmp == 0) return true;
            index = (cmp < 0) ? 2 * index : 2 * index + 1;
        }
        return false;
    }
}
