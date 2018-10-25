package Graph.ShortestPaths;

import java.util.ArrayList;
import java.util.Collections;

public class ShortestPathGraph {


    /**
     * The number of vertices in this graph
     */
    private final int NUMBER_OF_VERTEX;

    /**
     * List that represents edges in this graph
     */
    private ArrayList<Edge> edgeList = new ArrayList<>();

    private ArrayList<ArrayList<ShortestPathVertex>> adjacencyList = new ArrayList<>();

    /**
     * List that represents vertices in this graph
     */
    private ArrayList<ShortestPathVertex> vertexList = new ArrayList<>();


    /**
     * The maximum weight in this graph
     */
    private static final int MAX_DISTANCE = 10000;

    /**
     * The root vertex in this graph
     */
    private static final ShortestPathVertex NIL = new ShortestPathVertex(-1, null, 0);


    private static final int WHITE = 0;
    private static final int GRAY = 1;
    private static final int BLACK = 2;

    private int timestamp = 0;

    /**
     * @param size the number of vertices in this graph
     */
    public ShortestPathGraph(int size) {
        NUMBER_OF_VERTEX = size;
        for (int i = 0; i < size; i++) {
            vertexList.add(new ShortestPathVertex(i));
            adjacencyList.add(new ArrayList<>());
        }
    }

    public boolean doBellmanFordAlgorithm(int sourceIndex) {
        initializeSingleSource(sourceIndex);
        for (int i = 1; i < NUMBER_OF_VERTEX; i++) {
            for (Edge loop : edgeList) {
                doRelaxation(loop.getFirstVertexIndex(), loop.getSecondVertexIndex());
            }
        }

        for (Edge loop : edgeList) {
            int originalDistance = vertexList.get(loop.getSecondVertexIndex()).getDistance();
            int anotherDistance = vertexList.get(loop.getFirstVertexIndex()).getDistance() + loop.getWeight();

            if (anotherDistance < originalDistance) {
                System.out.println("False");
                return false;
            }
        }
        printTheShortestPath();
        return true;
    }

    public void doDAGShortestPaths() {

    }

    public ArrayList getTopologicallySortedList() {
        ArrayList<ShortestPathVertex> topologicallySortedList = new ArrayList<>();

//        for(ShortestPathVertex vertex : vertexList) {
//            topologicallySortedList.add(new ShortestPathVertex());
//        }


        return topologicallySortedList;
    }

    public void doDepthFirstSearch() {
        // initialize
        for (ShortestPathVertex vertex : vertexList) {
            vertex.setPredecessor(NIL);
            vertex.setColor(WHITE);
        }
        timestamp = 0;

        for (ShortestPathVertex vertex : vertexList) {
            if (vertex.getColor() == WHITE) {
                doDepthFirstSearchVisit(vertex.getIndex());
            }
        }
    }

    public void doDepthFirstSearchVisit(int startVertexIndex) {
        ShortestPathVertex startVertex = vertexList.get(startVertexIndex);
        startVertex.setDiscoverTime(++timestamp);
        startVertex.setColor(GRAY);

        for (ShortestPathVertex vertex : adjacencyList.get(startVertexIndex)) {
            if(vertex.getColor() == WHITE){
                vertex.setPredecessor(startVertex);
                doDepthFirstSearchVisit(vertex.getIndex());
            }
        }
        startVertex.setColor(BLACK);
        startVertex.setFinishTIme(++timestamp);
    }


    public void initializeSingleSource(int sourceIndex) {
        for (ShortestPathVertex vertex : vertexList) {
            vertex.setPredecessor(NIL);
            vertex.setDistance(MAX_DISTANCE);
        }
        vertexList.get(sourceIndex).setDistance(0);
    }

    public void doRelaxation(int firstVertexIndex, int secondVertexIndex) {

        boolean doesListContainInput = false;
        Graph.ShortestPaths.Edge specifiedEdge = new Graph.ShortestPaths.Edge(0, 0, 0);
        Graph.ShortestPaths.Edge inputEdge = new Graph.ShortestPaths.Edge(firstVertexIndex, secondVertexIndex);
        for (Graph.ShortestPaths.Edge loop : edgeList) {
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

        int originalDistance = vertexList.get(secondVertexIndex).getDistance();
        int anotherDistance = vertexList.get(firstVertexIndex).getDistance() + specifiedEdge.getWeight();

        if (anotherDistance < originalDistance) {
            vertexList.get(secondVertexIndex).setDistance(anotherDistance);
            vertexList.get(secondVertexIndex).setPredecessor(vertexList.get(firstVertexIndex));
        }
    }

    public int getEdgeWeight(int firstVertexIndex, int secondVertexIndex) {

        int targetWeight = 0;
        for (Graph.ShortestPaths.Edge loop : edgeList) {
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

    public void addToEdgeList(int firstVertexIndex, int secondVertexIndex, int weight) {
        edgeList.add(new Edge(firstVertexIndex, secondVertexIndex, weight));
        adjacencyList.get(firstVertexIndex).add(vertexList.get(secondVertexIndex));
    }

    public void addToAdjancencyList(int firstVertexIndex, int secondVertexIndex) {
        adjacencyList.get(firstVertexIndex).add(vertexList.get(secondVertexIndex));
    }

    public ArrayList<Edge> getEdgeList() {
        return edgeList;
    }

    public ArrayList<ShortestPathVertex> getVertexList() {
        return vertexList;
    }

    public int getVertexNumber() {
        return NUMBER_OF_VERTEX;
    }

    public void printTheShortestPath() {
        for (ShortestPathVertex vertex : vertexList) {
            System.out.println("Vertex: " + vertex.getIndex() + " <-- Predecessor: " + vertex.getPredecessor().getIndex());
        }
    }

    public void printEdgeList() {
        for (Edge edge : edgeList)
            System.out.println(edge);
    }

    public void printDistances() {
        for (ShortestPathVertex vertex : vertexList) {
            System.out.println("Vertex: " + vertex.getIndex() + ", Distance: " + vertex.getDistance());
        }
    }

    private void log(String arg) {
        System.out.println(arg);
    }


}
