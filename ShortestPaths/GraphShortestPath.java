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

    private static final ShortestPathVertex NIL = new ShortestPathVertex(-1,null,0);

    /**
     * @param size the number of vertices in this graph
     */
    public GraphShortestPath(int size) {
        NUMBER_OF_VERTEX = size;
        for (int i = 0; i < size; i++) {
            vertexArrayList.add(new ShortestPathVertex(i));
        }
    }

    public boolean doBellmanFordAlgorithm(int sourceIndex) {
        initializeSingleSource(sourceIndex);
        for (int i = 1; i < NUMBER_OF_VERTEX; i++) {
            for (Edge loop : adjList) {
                doRelaxation(loop.getFirstVertexIndex(), loop.getSecondVertexIndex(), 0);
            }
        }

        for (Edge loop : adjList) {

            int originalDistance = vertexArrayList.get(loop.getSecondVertexIndex()).getDistance();
            int anotherDistance = vertexArrayList.get(loop.getFirstVertexIndex()).getDistance() + loop.getWeight();

            if (originalDistance > anotherDistance) {
                System.out.println("False");
                return false;
            }
        }
        printTheShortestPath();
        return true;
    }

    public void initializeSingleSource(int sourceIndex) {
        for (ShortestPathVertex vertex : vertexArrayList) {
            vertex.setPredecessor(NIL);
            vertex.setDistance(MAX_DISTANCE);
        }
        vertexArrayList.get(sourceIndex).setDistance(0);
    }

    public void doRelaxation(int firstVertexIndex, int secondVertexIndex, int weight) {

        boolean doesListContain = false;
        Graph.ShortestPaths.Edge rightEdge = new Graph.ShortestPaths.Edge(0, 0, 0);
        for (Graph.ShortestPaths.Edge loop : adjList) {
            if (loop.getFirstVertexIndex() == firstVertexIndex &&
                    loop.getSecondVertexIndex() == secondVertexIndex) {
                doesListContain = true;
                rightEdge = loop;
                break;
            }
        }

        if (!doesListContain) {
            System.out.println("This edge doesn't exist.");
            return;
        } else {
//             log("This edge is " + rightEdge);
        }

        int originalDistance = vertexArrayList.get(secondVertexIndex).getDistance();
//        log("originalDistance: " + originalDistance);
        int anotherDistance = vertexArrayList.get(firstVertexIndex).getDistance() + rightEdge.getWeight();
//        log("anotherDistance: " + anotherDistance);

        if (originalDistance > anotherDistance) {
            vertexArrayList.get(secondVertexIndex).setDistance(anotherDistance);
            vertexArrayList.get(secondVertexIndex).setPredecessor(vertexArrayList.get(firstVertexIndex));
        }
    }

    public int getEdgeWeight(int firstVertexIndex, int secondVertexIndex) {

        int targetWeight = 0;
        for (Graph.ShortestPaths.Edge loop : adjList) {
            if (loop.getFirstVertexIndex() == firstVertexIndex &&
                    loop.getSecondVertexIndex() == secondVertexIndex) {
                targetWeight = loop.getWeight();
                break;
            }
        }

        if (targetWeight == 0) {
            System.out.println("This edge doesn't exist.");
        }
        return targetWeight;
    }

    public void addEdgeToAdjList(int firstVertexIndex, int secondVertexIndex, int weight) {
//        adjList.get(vertex1).set(vertex2, weight);
        adjList.add(new Edge(firstVertexIndex, secondVertexIndex, weight));
    }

    public ArrayList<Edge> getAdjList() {
        return adjList;
    }

    public ArrayList<ShortestPathVertex> getVertexArrayList() {
        return vertexArrayList;
    }

    public int getVertexNumber() {
        return NUMBER_OF_VERTEX;
    }

    public void printTheShortestPath() {
        for (ShortestPathVertex vertex : vertexArrayList) {
            System.out.println("Vertex: " + vertex.getIndex() + " <-- Predecessor: " + vertex.getPredecessor().getIndex());
        }
    }

    public void printEdgeList() {
        for (Edge edge : adjList)
            System.out.println(edge);
    }

    public void printDistances() {
        for (ShortestPathVertex vertex : vertexArrayList) {
            System.out.println("Vertex: " + vertex.getIndex() + ", Distance: " + vertex.getDistance());
        }
    }

    private void log(String arg){
        System.out.println(arg);
    }


}
