import java.util.*;

public class Vertex<V> {
    private V data;
    private Map<V, Double> adjacentVertices;

    public Vertex(V data) {
        this.data = data;
        adjacentVertices = new HashMap<>();
    }
    public Vertex() {
        adjacentVertices = new HashMap<>();
    }

    public void addAdjacentVertices(V destination, double weight){
        adjacentVertices.put(destination, weight);
    }


    public void add(V destination) {
        adjacentVertices.put(destination, null);
    }

    public int size() {
        return adjacentVertices.size();
    }


    public boolean contains(V connectedVertex) {
        return adjacentVertices.containsKey(connectedVertex);
    }

    public Double getValue(V connectedVertex){
        return adjacentVertices.get(connectedVertex);
    }

    public Iterable<V> adjacencyList() {
        List<V> vertices = new LinkedList<>();
        for (V e : adjacentVertices.keySet()) {
            vertices.add(e);
        }
        return vertices;
    }

    public V getData(){
        return data;
    }

    public void setData(V data){
        this.data = data;
    }

    public V containsData(Vertex<V> vertex){
        return vertex.getData();
    }

}
