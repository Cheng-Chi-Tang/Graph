package Graph.Graph_MST;

import Graph_MST.GraphMST;

import java.util.ArrayList;

public class GraphMSTTest {

    public static void main(String[] args){

        Graph_MST.GraphMST g6 = new GraphMST(7);

        g6.addEdgeToMatrix(0, 1, 5);g6.addEdgeToMatrix(0, 5, 3);
        g6.addEdgeToMatrix(1, 0, 5);g6.addEdgeToMatrix(1, 2, 10);g6.addEdgeToMatrix(1, 4, 1);g6.addEdgeToMatrix(1, 6, 4);
        g6.addEdgeToMatrix(2, 1, 10);g6.addEdgeToMatrix(2, 3, 5);g6.addEdgeToMatrix(2, 6, 8);
        g6.addEdgeToMatrix(3, 2, 5);g6.addEdgeToMatrix(3, 4, 7);g6.addEdgeToMatrix(3, 6, 9);
        g6.addEdgeToMatrix(4, 1, 1);g6.addEdgeToMatrix(4, 3, 7);g6.addEdgeToMatrix(4, 5, 6);g6.addEdgeToMatrix(4, 6, 2);
        g6.addEdgeToMatrix(5, 0, 3);g6.addEdgeToMatrix(5, 4, 6);
        g6.addEdgeToMatrix(6, 1, 4);g6.addEdgeToMatrix(6, 2, 8);g6.addEdgeToMatrix(6, 3, 9);g6.addEdgeToMatrix(6, 4, 2);


        g6.doKruskalMST();
        /*ArrayList<ArrayList<Integer>> matrix = g6.getAdjMatrix();

        for(int i = 0 ; i < matrix.size(); i ++ ){

            System.out.print(i + ":");
            for(int j = 0; j < matrix.size(); j++){

                System.out.print(" " + matrix.get(i).get(j));

            }

            System.out.println();
        }*/

    }
}
