import java.util.LinkedList;
import java.util.Queue;

public class MyBreadthFirstSearch<T> extends MySearch<T>{

    public MyBreadthFirstSearch(MyGraph<T> graph, T source) {
        super(source);
        bfs(graph, source);
    }

    private void bfs(MyGraph<T> graph, T current) {
        marked.add(current);
        Queue<T> queue = new LinkedList<>();
        queue.add(current);
        while (!queue.isEmpty()) {
            T v = queue.remove();
            for (T vertex : graph.adjacencyList(v)) {
                if (!marked.contains(vertex)) {
                    marked.add(vertex);
                    edgeTo.put(vertex, v);
                    queue.add(vertex);
                }
            }
        }
    }
}

