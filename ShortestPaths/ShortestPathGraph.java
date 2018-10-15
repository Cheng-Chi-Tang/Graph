package Graph.ShortestPaths;

import org.omg.CORBA.Object;

import java.util.ArrayList;

public class ShortestPathGraph {


    /**
     * The number of vertices in this graph
     */
    private final int NUMBER_OF_VERTEX;

    /**
     * List that represents edges in this graph
     */
    private ArrayList<Edge> adjList = new ArrayList<>();

    /**
     * List that represents vertices in this graph
     */
    private ArrayList<ShortestPathVertex> vertexArrayList = new ArrayList<>();


    /**
     * The maximum weight in this graph
     */
    private static final int MAX_DISTANCE = 10000;

    /**
     * The root vertex in this graph
     */
    private static final ShortestPathVertex NIL = new ShortestPathVertex(-1, null, 0);

    /**
     * @param size the number of vertices in this graph
     */
    public ShortestPathGraph(int size) {
        NUMBER_OF_VERTEX = size;
        for (int i = 0; i < size; i++) {
            vertexArrayList.add(new ShortestPathVertex(i));
        }
    }

    public boolean doBellmanFordAlgorithm(int sourceIndex) {
        initializeSingleSource(sourceIndex);
        for (int i = 1; i < NUMBER_OF_VERTEX; i++) {
            for (Edge loop : adjList) {
                doRelaxation(loop.getFirstVertexIndex(), loop.getSecondVertexIndex());
            }
        }

        for (Edge loop : adjList) {
            int originalDistance = vertexArrayList.get(loop.getSecondVertexIndex()).getDistance();
            int anotherDistance = vertexArrayList.get(loop.getFirstVertexIndex()).getDistance() + loop.getWeight();

            if (anotherDistance < originalDistance) {
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

    public void doRelaxation(int firstVertexIndex, int secondVertexIndex) {

        boolean doesListContainInput = false;
        Graph.ShortestPaths.Edge specifiedEdge = new Graph.ShortestPaths.Edge(0, 0, 0);
        Graph.ShortestPaths.Edge inputEdge = new Graph.ShortestPaths.Edge(firstVertexIndex, secondVertexIndex);
        for (Graph.ShortestPaths.Edge loop : adjList) {
            if (loop.equals(inputEdge)) {
                doesListContainInput = true;
                specifiedEdge = loop;
                break;
            }
        }

        if (!doesListContainInput) {
            System.out.println("This edge doesn't exist.");
            return;
        }

        int originalDistance = vertexArrayList.get(secondVertexIndex).getDistance();
        int anotherDistance = vertexArrayList.get(firstVertexIndex).getDistance() + specifiedEdge.getWeight();

        if (anotherDistance < originalDistance ) {
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

    private void log(String arg) {
        System.out.println(arg);
    }


}
