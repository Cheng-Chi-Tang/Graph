package Graph.ShortestPaths;

import java.util.ArrayList;

public class GraphShotestPath {


    /**
     * The number of vertices in this graph
     */
    private final int NUMBER_OF_VERTEX;

    /**
     * Matrix that represents this graph
     */
    private ArrayList<ArrayList<Integer>> adjMatrix = new ArrayList<>();


    /**
     * The maximum weight in this graph
     */
    private static final int MAX_WEIGHT = 10000;

    /**
     * @param size the number of vertices in this graph
     */
    public GraphShotestPath(int size) {
        NUMBER_OF_VERTEX = size;

        for (int i = 0; i < NUMBER_OF_VERTEX; i++) {
            ArrayList<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < NUMBER_OF_VERTEX; j++) {
                rowList.add(0);
            }

            adjMatrix.add(rowList);
        }
    }
}
