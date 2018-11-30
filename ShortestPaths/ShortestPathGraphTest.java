package Graph.ShortestPaths;

import java.util.ArrayList;

public class ShortestPathGraphTest {

    public static void main(String[] args) {


        /**
         * Test for doDijkstraAlgorithm
         */

        // region doDijkstraAlgorithm test

        // Does not work in Dijkstra
        /*ShortestPathGraph graph = new ShortestPathGraph(3);
        graph.addToEdgeList(0, 1, 5);
        graph.addToEdgeList(0, 2, 2);
        graph.addToEdgeList(1, 2, -10);*/

        // Works in Dijkstra
        /*ShortestPathGraph graph = new ShortestPathGraph(5);

        graph.addToEdgeList(0, 1, 10);
        graph.addToEdgeList(0, 4, 5);

        graph.addToEdgeList(1, 4, 2);
        graph.addToEdgeList(1, 2, 1);

        graph.addToEdgeList(2, 3, 4);

        graph.addToEdgeList(3, 2, 6);
        graph.addToEdgeList(3, 0, 7);

        graph.addToEdgeList(4, 1, 3);
        graph.addToEdgeList(4, 2, 9);
        graph.addToEdgeList(4, 3, 2);

        graph.doDijkstraAlgorithm(0);
        graph.printTheShortestPath();*/

        // endregion doDijkstraAlgorithm test

        // region doDepthFirstSearch test

        /**
         * Test for doDepthFirstSearch
         */

        /*graph.doDepthFirstSearch();
        for (ShortestPathVertex vertex : graph.getVertexList()) {
            System.out.println("vertex: " + vertex.getIndex());
            System.out.println("discoverTime: " + vertex.getDiscoverTime());
            System.out.println("finishTime: " + vertex.getFinishTIme());
            System.out.println();
        }*/

        // endregion doDepthFirstSearch test

        // region getTopologicallySortedList test

        /**
         * Test for getTopologicallySortedList
         */

        /*ArrayList<ShortestPathVertex> list = graph.getTopologicallySortedList();
        int i = 0;
        for(ShortestPathVertex vertex:list){
            System.out.println("list[" + i + "]: vertexIndex: " + vertex.getIndex() +", FinishTime: " + vertex.getFinishTIme() );
            i++;
        }*/

        // endregion getTopologicallySortedList test

        // region doDAGShortestPaths test

        /**
         * Test for doDAGShortestPaths
         */
/*
        ShortestPathGraph graph = new ShortestPathGraph(6);
        graph.addToEdgeList(0, 1, 5);
        graph.addToEdgeList(0, 2, 3);

        graph.addToEdgeList(1, 2, 2);
        graph.addToEdgeList(1, 3, 6);

        graph.addToEdgeList(2, 3, 7);
        graph.addToEdgeList(2, 4, 4);
        graph.addToEdgeList(2, 5, 2);

        graph.addToEdgeList(3, 4, -1);
        graph.addToEdgeList(3, 5, 1);

        graph.addToEdgeList(4, 5, -2);

        graph.doDAGShortestPaths(0);
        ArrayList<ShortestPathVertex> vertexList = graph.getVertexList();

        for(ShortestPathVertex vertex : vertexList){
            log("vertex: " + vertex.getIndex());
            log("distance: " + vertex.getDistance());
            log("predecessor: " + vertex.getPredecessor().getIndex());
            log("");
        }
*/

        // endregion doDAGShortestPaths test

    }


    private static void log(String args){
        System.out.println(args);
    }
}
