package Graph.ShortestPaths;

public class GraphShortestPathTest {

    public static void main(String[] args){

        GraphShortestPath graph = new GraphShortestPath(6);

        graph.addEdgeToAdjList(1, 2, 3);
        graph.addEdgeToAdjList(2, 3, 1);
        graph.addEdgeToAdjList(1, 3, 2);
        graph.doRelaxation(new Edge(2,1,5));
    }
}
