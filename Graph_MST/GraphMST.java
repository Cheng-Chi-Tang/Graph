package Graph.Graph_MST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GraphMST {
    private int numberOfVertex;
    private ArrayList<ArrayList<Integer>> adjMatrix = new ArrayList<>();
    private static final int MAX_WEIGHT = 10000;
    private static final int UNVISITED = 0;
    private static final int VISITED = 1;

    GraphMST(int size) {
        numberOfVertex = size;

        for (int i = 0; i < numberOfVertex; i++) {
            ArrayList<Integer> rowList = new ArrayList<>();
            for(int j = 0 ; j < numberOfVertex ; j++){
                rowList.add(0);
            }

//            System.out.print("rowList.size: " + rowList.size());
            adjMatrix.add(rowList);
        }
    }

    private int getRootFromCollapsing(ArrayList<Integer> rootList, int vertex) {

        int rootVertex = vertex;

        // find the final root
        while( rootList.get(rootVertex) >= 0){
            rootVertex = rootList.get(rootVertex);
        }

        // do collapsing
        while ( vertex != rootVertex) {
            int currentRoot = rootList.get(vertex);
            rootList.set(vertex, rootVertex);
            vertex = currentRoot;
        }

        return rootVertex;
    }

    private void setUnion(ArrayList<Integer> rootList, int vertex1, int vertex2){
        int root1 = getRootFromCollapsing(rootList, vertex1);
        int root2 = getRootFromCollapsing(rootList, vertex2);

        if(rootList.get(root1) <= rootList.get(root2)){
            rootList.set(root1, rootList.get(root1) + rootList.get(root2) );
            rootList.set(root2, root1);
        }
        else{
            rootList.set(root2, rootList.get(root1) + rootList.get(root2) );
            rootList.set(root1, root2);
        }
    }

    private void sortEdgeList(ArrayList<Edge> edgeArrayList){

        for(int column = 0; column < numberOfVertex -1; column++){
            for(int row = column + 1 ; row < numberOfVertex; row++){
                if(adjMatrix.get(column).get(row) != 0){
                    edgeArrayList.add(new Edge(column, row, adjMatrix.get(column).get(row)));
                }
            }
        }

        Collections.sort(edgeArrayList, new Comparator<Edge>() {
            @Override
            public int compare(Edge edge1, Edge edge2) {
                if((edge1.getWeight() >=  edge2.getWeight())) {
                    return 1;
                }
                else{
                    return -1;
                }
            }
        });
    }

    public void doKruskalMST(){
        ArrayList<Edge> MSTEdgeList = new ArrayList<>();
        int edgesetCount = 0;

        ArrayList<Integer> subsetList = new ArrayList<>();
        for(int i = 0; i < numberOfVertex; i++){
            subsetList.add(-1);
        }

        ArrayList<Edge> increaseWeightList = new ArrayList<>();
        sortEdgeList(increaseWeightList);

        /*for(int i = 0; i < increaseWeightList.size(); i ++){
            System.out.printf("Vertex 1 , Vertex 2 , weight = %d, %d, %d " ,
                    increaseWeightList.get(i).vertex1,increaseWeightList.get(i).vertex2, increaseWeightList.get(i).weight );
            System.out.println();
        }*/

//        System.out.print(" v1Root -  v2Root");
        for(int i = 0; i < increaseWeightList.size()  ; i ++){
//            System.out.print( getRootFromCollapsing(subsetList, increaseWeightList.get(i).vertex1) +" - "+
//                    getRootFromCollapsing(subsetList, increaseWeightList.get(i).vertex2) + "\n");
            if(getRootFromCollapsing(subsetList, increaseWeightList.get(i).vertex1)
                    != getRootFromCollapsing(subsetList, increaseWeightList.get(i).vertex2)){

                MSTEdgeList.add(increaseWeightList.get(i));
                setUnion(subsetList, increaseWeightList.get(i).vertex1,increaseWeightList.get(i).vertex2);
            }
        }

        System.out.print(" v1 -  v2:  weight");
        for(int i = 0; i < numberOfVertex - 1; i++){
            System.out.printf("\n%3d - %3d: %4d",
                    MSTEdgeList.get(i).vertex1, MSTEdgeList.get(i).vertex2, MSTEdgeList.get(i).weight);
        }

    }

    public void doPrimMST(){

    }

//    private int get

    public void addEdgeToMatrix(int vertex1, int vertex2, int weight){
        ArrayList<Edge> rowList = new ArrayList<>();
//        System.out.print("Size of adjMatrix: "+ adjMatrix.size());
//        System.out.print("Size of adjMatrix.get(0): "+ adjMatrix.get(0).size());
        adjMatrix.get(vertex1).set(vertex2, weight);
    }

    public ArrayList<ArrayList<Integer>> getAdjMatrix(){
        return adjMatrix;
    }

    private class Edge {

        private int vertex1, vertex2, weight;

        public Edge() {
        }

        public Edge(int vertex1, int vertex2, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }

        public int getVertex1(){
            return vertex1;
        }

        public int getVertex2(){
            return vertex2;
        }

        public int getWeight(){
            return weight;
        }

    }

}
