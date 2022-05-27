import java.util.*;

public class MyWeightedGraph<T> {
    private final boolean undirected;
    private Map<T, Vertex<T>> map;

    public void addVertex(T vertex) {
        map.put(vertex, new Vertex<T>(vertex));
    }

    public MyWeightedGraph() {
        this(true);
    }

    public MyWeightedGraph(boolean undirected) {
        this.undirected = undirected;
        map = new HashMap<>();
    }


    public void addEdge(T source, T dest, double weight) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest)
                || source.equals(dest))
            return; // reject parallels & self-loops

        map.get(source).addAdjacentVertices(dest, weight);

        if (undirected)
            map.get(dest).addAdjacentVertices(dest, weight);
    }

    public Double getWeight(T source, T dest){
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest)
                || source.equals(dest))
            return 0.0;
        return map.get(source).getValue(dest);
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }

        if (undirected)
            count /= 2;

        return count;
    }


    public boolean hasVertex(T v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(T source, T dest) {
        return hasVertex(source) && map.get(source).contains(dest);
    }


    public Iterable<T> adjacencyList(T v) {
        if (!hasVertex(v)) return null;
        return map.get(v).adjacencyList();
    }

//    public Iterable<Vertex<T>> getEdges(T v) {
//        if (!hasVertex(v)) return null;
//        return map.get(v).adjacencyList();
//    }
}
