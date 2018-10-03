package Graph.ShortestPaths;

public class ShortestPathVertex {

    private int index;
    private int predecessor;
    private int distance;

    ShortestPathVertex(int vertexIndex, int predecessorIndex, int distance){
        this.index = vertexIndex;
        this.predecessor = predecessorIndex;
        this.distance = distance;
    }

    public int getIndex(){
        return index;
    }

    public int getPredecessor(){
        return predecessor;
    }

    public int getDistance(){
        return distance;
    }

    public void setPredecessor(int index){
        predecessor = index;
    }

    public void setDistance(int distatnce){
        this.distance = distatnce;
    }
}
