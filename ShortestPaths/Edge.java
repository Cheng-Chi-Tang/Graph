package Graph.ShortestPaths;

public class Edge {


    private int firstVertexIndex, secondVertexIndex;
    private int weight;
    private ShortestPathVertex vertex1, vertex2;

    Edge(int vertex1Index, int vertex2Index, int weight) {
        this.firstVertexIndex = vertex1Index;
        this.secondVertexIndex = vertex2Index;
        this.vertex1 = new ShortestPathVertex(firstVertexIndex);
        this.vertex2 = new ShortestPathVertex(secondVertexIndex);
        this.weight = weight;
    }

    public ShortestPathVertex getVertex1(){
        return vertex1;
    }

    public ShortestPathVertex getVertex2(){
        return vertex2;
    }

    public int getFirstVertexIndex(){
        return firstVertexIndex;
    }

    public int getSecondVertexIndex(){
        return secondVertexIndex;
    }

    public int getWeight(){
        return weight;
    }

    @Override
    public String toString(){
        return "Edge:\n" +
                "vertex1:" + firstVertexIndex +"\n" +
               "vertex2:" + secondVertexIndex +"\n" +
               "weight:" + weight +"\n" ;
    }

}
