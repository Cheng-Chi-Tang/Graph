package Graph.ShortestPaths;

import java.util.ArrayList;

public class GraphShortestPath {


    /**
     * The number of vertices in this graph
     */
    private final int NUMBER_OF_VERTEX;

    /**
     * Matrix that represents this graph and each element represents the the weight between each vertex
     */
    private ArrayList<Edge> adjList = new ArrayList<>();

    private ArrayList<ShortestPathVertex> vertexArrayList = new ArrayList<>();


    /**
     * The maximum weight in this graph
     */
    private static final int MAX_DISTANCE = 10000;

    private static final ShortestPathVertex NIL = null;

    /**
     * @param size the number of vertices in this graph
     */
    public GraphShortestPath(int size) {
        NUMBER_OF_VERTEX = size;
    }

    public void doBellmanFordAlgorithm(GraphShortestPath graph, int source) {
        initializeSingleSource(graph, source);
        for (int i = 1; i < graph.NUMBER_OF_VERTEX; i++) {

        }
    }

    public void initializeSingleSource(GraphShortestPath graph, int sourceIndex) {
        ArrayList<ShortestPathVertex> vertexList = graph.getVertexArrayList();
        for (ShortestPathVertex vertex : vertexList) {
            vertex.setPredecessor(NIL);
            vertex.setDistance(MAX_DISTANCE);
        }
        vertexList.get(sourceIndex).setDistance(0);
    }

    public void doRelaxation(Graph.ShortestPaths.Edge edge) {

        boolean doesListContain = false;
        Graph.ShortestPaths.Edge rightEdge = new Graph.ShortestPaths.Edge(0, 0,0);
        for (Graph.ShortestPaths.Edge loop : adjList) {
            if (loop.getFirstVertexIndex() == edge.getFirstVertexIndex() &&
                    loop.getSecondVertexIndex() == edge.getSecondVertexIndex()){
                doesListContain = true;
                rightEdge = loop;
                break;
            }
        }

        if( !doesListContain ) {
            System.out.println("This edge doesn't exist.");
            return;
        }
        else{
            System.out.println("This edge is in List.");
        }

        int originalDistance = rightEdge.getVertex1().getDistance();
        int anotherDistance = rightEdge.getVertex2().getDistance() + rightEdge.getWeight();

        if (originalDistance > anotherDistance) {
            rightEdge.getVertex1().setDistance(anotherDistance);
            rightEdge.getVertex1().setPredecessor(edge.getVertex2());
        }
    }

    /**
     * Adds a new edge into this graph
     *
     * @param vertex1 first vertex
     * @param vertex2 second vertex
     * @param weight  the weight between these two vertices
     */
    public void addEdgeToAdjList(int vertex1, int vertex2, int weight) {
//        adjList.get(vertex1).set(vertex2, weight);
        adjList.add(new Edge(vertex1, vertex2, weight));
    }

//    /**
//     * Edge data structure
//     */
//    private class Edge {
//
//        private int vertex1Index, vertex2Index;
//        private int weight;
//        private ShortestPathVertex vertex1, vertex2;
//
//        Edge(int vertex1, int vertex2, int weight) {
//            this.vertex1Index = vertex1;
//            this.vertex2Index = vertex2;
//            this.vertex1 = new ShortestPathVertex(vertex1Index);
//            this.vertex2 = new ShortestPathVertex(vertex2Index);
//            this.weight = weight;
//        }
//
//    }

    public ArrayList<Edge> getAdjList() {
        return adjList;
    }

    public ArrayList<ShortestPathVertex> getVertexArrayList() {
        return vertexArrayList;
    }


}
