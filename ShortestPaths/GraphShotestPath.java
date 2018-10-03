package Graph.ShortestPaths;

import java.util.ArrayList;

public class GraphShotestPath {


    /**
     * The number of vertices in this graph
     */
    private final int NUMBER_OF_VERTEX;

    /**
     * Matrix that represents this graph and each element represents the the weight between each vertex
     */
    private ArrayList<ArrayList<Integer>> adjMatrix = new ArrayList<>();

    private ArrayList<ShortestPathVertex> vertexArrayList = new ArrayList<>();


    /**
     * The maximum weight in this graph
     */
    private static final int MAX_DISTANCE = 10000;

    /**
     * @param size the number of vertices in this graph
     */
    public GraphShotestPath(int size, int source) {
        NUMBER_OF_VERTEX = size;

        // initialize this graph and each vertex
        for (int i = 0; i < NUMBER_OF_VERTEX; i++) {
            ArrayList<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < NUMBER_OF_VERTEX; j++) {
                rowList.add(0);
            }
            adjMatrix.add(rowList);
            vertexArrayList.add(new ShortestPathVertex(i, -1, MAX_DISTANCE));
        }
        vertexArrayList.get(source).setDistance(0);
    }

    private void doRelexation(ShortestPathVertex vertex1, ShortestPathVertex vertex2){

        int originalDistance = vertex1.getDistance();
        int anotherDistance = vertex2.getDistance() + adjMatrix.get(vertex1.getIndex()).get(vertex2.getIndex());

        if( originalDistance > anotherDistance){
            vertex1.setDistance(anotherDistance);
            vertex1.setPredecessor(vertex2.getIndex());
        }

    }


}
