package Graph.ShortestPaths;

public class GraphShortestPathTest {

    public static void main(String[] args){

        ShortestPathGraph graph = new ShortestPathGraph(5);

        graph.addEdgeToAdjList(1, 2, 8);
        graph.addEdgeToAdjList(1, 3, 5);
        graph.addEdgeToAdjList(1, 4, -4);

        graph.addEdgeToAdjList(0, 1, 6);
        graph.addEdgeToAdjList(0, 2, 7);


        graph.addEdgeToAdjList(2, 3, -3);
        graph.addEdgeToAdjList(2, 4, 9);

        graph.addEdgeToAdjList(3, 1, -2);

        graph.addEdgeToAdjList(4, 3, 7);
        graph.addEdgeToAdjList(4, 0, 2);


        graph.doBellmanFordAlgorithm(0);


    }
}
