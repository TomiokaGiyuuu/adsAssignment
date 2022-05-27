import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Start{

    public static void main(String[] args) {
        MyWeightedGraph<String> graph = new MyWeightedGraph<>();

        graph.addVertex("Astana");
        graph.addVertex("Kyzylorda");
        graph.addVertex("Almaty");
        graph.addVertex("Shymkent");
        graph.addVertex("Kokshetau");
        graph.addEdge("Kyzylorda", "Astana", 5);
        graph.addEdge("Kyzylorda", "Almaty", 5);
        graph.addEdge("Kyzylorda", "Shymkent", 5);
        graph.addEdge("Kyzylorda", "Kokshetau", 5);
        System.out.println(graph.adjacencyList("Kyzylorda"));

        MyDijkstraSearch<String> ds = new MyDijkstraSearch<>(graph, "Kyzylorda");

        System.out.println(ds.hasPathTo("Astana"));
        System.out.println("___________________________________________________________");

        MyGraph<String> myGraph = new MyGraph<>();

        myGraph.addVertex("Real Madrid");
        myGraph.addVertex("FCB");
        myGraph.addVertex("Juventus");
        myGraph.addEdge("Real Madrid", "Juventus");
        System.out.println(myGraph.hasEdge("Real Madrid", "FCB"));
        System.out.println(myGraph.hasEdge("Real Madrid", "Juventus"));

        MyBreadthFirstSearch<String> mBFS = new MyBreadthFirstSearch<>(myGraph, "Real Madrid");

        for (String s : mBFS.marked) {
            System.out.println(s);
        }

        System.out.println("___________________________________________________________");

        myGraph.addVertex("PSG");
        myGraph.addEdge("FCB", "PSG");
        MyDepthFirstSearch<String> mDFS = new MyDepthFirstSearch<>(myGraph, "FCB");

        for(String s : mDFS.marked){
            System.out.println(s);
        }

//        MyWeightedGraph<String> shitGraph = new MyWeightedGraph<>();
//        shitGraph.addVertex("Ads");
//        shitGraph.addVertex("very");
//        System.out.println(shitGraph.getVerticesCount());
//        shitGraph.addVertex("shit");
//        System.out.println(shitGraph.getVerticesCount());
//        shitGraph.addEdge("Ads", "very", 5);
//        System.out.println(shitGraph.getEdgesCount());
//        System.out.println(shitGraph.adjacencyList("Ads"));
    }
}
