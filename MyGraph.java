import java.util.*;


public class MyGraph<T> {
    private boolean bidirectional;
    private Map<T, Vertex<T>> map;
    T type;

    public MyGraph() {
        this(false);
    }

    public MyGraph(boolean bidirectional) {
        this.bidirectional = bidirectional;
        map = new HashMap<>();
    }

    public void addVertex(T vertex) {
        map.put(vertex, new Vertex<T>(vertex));
    }

    public void addEdge(T source, T dest) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest)
                || source.equals(dest))
            return; // reject parallels & self-loops

        map.get(source).add(dest);

        if (bidirectional)
            map.get(dest).add(source);
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }

        if (!bidirectional)
            count /= 2;

        return count;
    }


    public boolean hasVertex(T v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(T source, T dest) {
        if (!hasVertex(source)) return false;
        return map.get(source).contains(dest);
    }

    public Iterable<T> adjacencyList(T v) {
        if (!hasVertex(v)) return null;
        return map.get(v).adjacencyList();
    }
}

