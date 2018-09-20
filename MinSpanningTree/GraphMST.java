package Graph.MinSpanningTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Implementation of Minimum Spanning Tree in Graph
 *
 * @author Cheng-Chi Tang
 * @since 2018/05/30
 * */

public class GraphMST {
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
     * @param size The number of vertices in this graph
     */
    GraphMST(int size) {
        NUMBER_OF_VERTEX = size;

        for (int i = 0; i < NUMBER_OF_VERTEX; i++) {
            ArrayList<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < NUMBER_OF_VERTEX; j++) {
                rowList.add(0);
            }

            adjMatrix.add(rowList);
        }
    }

    /**
     * Returns the root of a specific vertex from a root list
     *
     * @param rootList current root list
     * @param vertex a vertex whose root will be found
     * @return root of parameter vertex
     */
    private int getRootFromCollapsing(ArrayList<Integer> rootList, int vertex) {

        int rootVertex = vertex;

        // find the final root
        while (rootList.get(rootVertex) >= 0) {
            rootVertex = rootList.get(rootVertex);
        }

        // do collapsing
        while (vertex != rootVertex) {
            int currentRoot = rootList.get(vertex);
            rootList.set(vertex, rootVertex);
            vertex = currentRoot;
        }

        return rootVertex;
    }

    /**
     * Unite the sets of two vertices
     *
     * @param rootList current root list
     * @param vertex1 first vertex
     * @param vertex2 second vertex
     */
    private void setUnion(ArrayList<Integer> rootList, int vertex1, int vertex2) {
        int root1 = getRootFromCollapsing(rootList, vertex1);
        int root2 = getRootFromCollapsing(rootList, vertex2);

        if (rootList.get(root1) <= rootList.get(root2)) {
            rootList.set(root1, rootList.get(root1) + rootList.get(root2));
            rootList.set(root2, root1);
        } else {
            rootList.set(root2, rootList.get(root1) + rootList.get(root2));
            rootList.set(root1, root2);
        }
    }


    /**
     * Returns the edge list which is sorted
     *
     * @return the edge list which is sorted
     */
    private ArrayList<Edge> getSortedEdgeList() {

        ArrayList<Edge> edgeArrayList = new ArrayList<>();

        for (int column = 0; column < NUMBER_OF_VERTEX - 1; column++) {
            for (int row = column + 1; row < NUMBER_OF_VERTEX; row++) {
                if (adjMatrix.get(column).get(row) != 0) {
                    edgeArrayList.add(new Edge(column, row, adjMatrix.get(column).get(row)));
                }
            }
        }

        Collections.sort(edgeArrayList, new Comparator<Edge>() {
            @Override
            public int compare(Edge edge1, Edge edge2) {
                if ((edge1.weight >= edge2.weight)) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        return edgeArrayList;
    }

    /**
     * Do the Kruskal algorithm for minimum spanning tree and print the result
     */
    public void doKruskalMST() {
        ArrayList<Edge> MSTEdgeList = new ArrayList<>();
        ArrayList<Integer> subsetList = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_VERTEX; i++) {
            subsetList.add(-1);
        }

        ArrayList<Edge> increaseWeightList = getSortedEdgeList();

        for (int i = 0; i < increaseWeightList.size(); i++) {
            if (getRootFromCollapsing(subsetList, increaseWeightList.get(i).vertex1)
                    != getRootFromCollapsing(subsetList, increaseWeightList.get(i).vertex2)) {

                MSTEdgeList.add(increaseWeightList.get(i));
                setUnion(subsetList, increaseWeightList.get(i).vertex1, increaseWeightList.get(i).vertex2);
            }
        }

        // print out the results
        System.out.print(" v1 -  v2:  weight");
        for (int i = 0; i < NUMBER_OF_VERTEX - 1; i++) {
            System.out.printf("\n%3d - %3d: %4d",
                    MSTEdgeList.get(i).vertex1, MSTEdgeList.get(i).vertex2, MSTEdgeList.get(i).weight);
        }

    }

    /**
     * Do the Prim Algorithm for minimum spanning tree and print the result
     *
     * @param startVertex the start vertex for Prim Algorithm
     */
    public void doPrimMST(int startVertex) {
        ArrayList<Integer> costList = new ArrayList<>();
        ArrayList<Integer> predecessorList = new ArrayList<>();
        ArrayList<Boolean> isVisitedList = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_VERTEX; i++) {
            costList.add(MAX_WEIGHT);
            predecessorList.add(-1);
            isVisitedList.add(false);
        }

        costList.set(startVertex, 0);
        for (int counter = 0; counter < NUMBER_OF_VERTEX; counter++) {
            int minCostVertex = getMinCostVertex(costList, isVisitedList);
            isVisitedList.set(minCostVertex, true);

            // update predecessorList and costList
            for (int vertex = 0; vertex < NUMBER_OF_VERTEX; vertex++) {
                int edgeCost = adjMatrix.get(minCostVertex).get(vertex);
                if (!isVisitedList.get(vertex)
                        && isVerticesConnected(minCostVertex, vertex)
                        && edgeCost < costList.get(vertex)) {

                    predecessorList.set(vertex, minCostVertex);
                    costList.set(vertex, edgeCost);
                }
            }
        }

        // print out the results
        System.out.print("v1 -  v2  -  weight");
        for (int vertex = 0; vertex < NUMBER_OF_VERTEX; vertex++){
            int predecessor = predecessorList.get(vertex);
            if(predecessor >= 0) {
                System.out.print("\n" + vertex + "  -  " + predecessor + "  -   " + adjMatrix.get(vertex).get(predecessor));
            }
        }
    }

    /**
     * Returns the next vertex which has minimum cost and has not been visited
     *
     * @param costList the current list of cost of arriving the vertex
     * @param isVisitedList the current list of label to show if the vertex has been visited or not
     * @return the next vertex which has minimum cost
     */
    private int getMinCostVertex(ArrayList<Integer> costList, ArrayList<Boolean> isVisitedList) {

        int minCost = MAX_WEIGHT;
        int minCostVertex = 0;
        for (int vertex = 0; vertex < NUMBER_OF_VERTEX; vertex++) {
            if (!isVisitedList.get(vertex) && costList.get(vertex) < minCost) {
                minCost = costList.get(vertex);
                minCostVertex = vertex;
            }
        }

        return minCostVertex;
    }

    /**
     * Returns <tt>true</tt> is these two vertices is connected
     *
     * @param vertex1 first vertex
     * @param vertex2 second vertex
     * @return <tt>true</tt> if these two vertices is connected
     */
    private boolean isVerticesConnected(int vertex1, int vertex2) {
        return (adjMatrix.get(vertex1).get(vertex2) != 0);
    }

    /**
     * Adds a new edge into this graph
     *
     * @param vertex1 first vertex
     * @param vertex2 second vertex
     * @param weight the weight between these two vertices
     */
    public void addEdgeToMatrix(int vertex1, int vertex2, int weight) {
        ArrayList<Edge> rowList = new ArrayList<>();
        adjMatrix.get(vertex1).set(vertex2, weight);
    }

    /**
     * Returns the current adjacent matrix which represents this graph
     *
     * @return the current adjacent matrix which represents this graph
     */
    public ArrayList<ArrayList<Integer>> getAdjMatrix() {
        return adjMatrix;
    }

    /**
     * Edge data structure
     */
    private class Edge {

        private int vertex1, vertex2, weight;

        public Edge() {
        }

        Edge(int vertex1, int vertex2, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }

    }

}
