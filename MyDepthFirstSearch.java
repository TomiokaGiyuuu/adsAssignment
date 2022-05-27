

public class MyDepthFirstSearch<T> extends MySearch<T> {
    public MyDepthFirstSearch(MyGraph<T> graph, T source) {
        super(source);
        dfs(graph, source);
    }

    private void dfs(MyGraph<T> graph, T current) {
        marked.add(current);
        count++;
        for (T v : graph.adjacencyList(current)) {
            if (!marked.contains(v)) {
                edgeTo.put(v, current);
                dfs(graph, v);
            }
        }
    }

}

