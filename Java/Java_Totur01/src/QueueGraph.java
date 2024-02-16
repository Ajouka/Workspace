import java.util.ArrayDeque;


import java.util.HashMap;

public class QueueGraph extends ArrayDeque<Integer> {
    private HashMap<Integer, Boolean> visited = new HashMap<>();

    public Integer removeVisited() {
        Integer node = this.remove();
        setVisited(node);
        return node;
    }

    public void addVisited(Integer node) {
        this.add(node);
        setVisited(node);
    }

    public boolean visited(Integer node) {
        return visited.getOrDefault(node, false);
    }

    public void setVisited(Integer node) {
        visited.put(node, true);
    }

    public void reset() {
        visited.clear();
    }

}

