package Graph.ShortestPaths;

public class GraphShortestPathTest {

    public static void main(String[] args) {

        ShortestPathGraph graph = new ShortestPathGraph(5);


        graph.addToEdgeList(1, 2, 8);
        graph.addToEdgeList(1, 3, 5);
        graph.addToEdgeList(1, 4, -4);

        graph.addToEdgeList(0, 1, 6);
        graph.addToEdgeList(0, 2, 7);


        graph.addToEdgeList(2, 3, -3);
        graph.addToEdgeList(2, 4, 9);

        graph.addToEdgeList(3, 1, -2);

        graph.addToEdgeList(4, 3, 7);
        graph.addToEdgeList(4, 0, 2);


//        boolean doesNegativeCycleNotExist = graph.doBellmanFordAlgorithm(0);
//        System.out.println("doesnotNegativeCycleExist: " + doesNegativeCycleNotExist);

        /*graph.doDepthFirstSearch();
        for (ShortestPathVertex vertex : graph.getVertexList()) {
            System.out.println("vertex: " + vertex.getIndex());
            System.out.println("discoverTime: " + vertex.getDiscoverTime());
            System.out.println("finishTime: " + vertex.getFinishTIme());
            System.out.println();
        }*/


    }
}
