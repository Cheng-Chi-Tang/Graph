package Graph.ShortestPaths;

public class ShortestPathVertex {

    private int index;
    private ShortestPathVertex predecessor;
    private int distance;

    /**
     * The maximum weight in this graph
     */
    private static final int MAX_DISTANCE = 10000;

    private static final ShortestPathVertex NIL = new ShortestPathVertex(-1, null, 0);


    ShortestPathVertex(int vertexIndex) {
        this.index = vertexIndex;
        this.predecessor = NIL;
        this.distance = MAX_DISTANCE;
    }

    ShortestPathVertex(int vertexIndex, ShortestPathVertex predecessor, int distance) {
        this.index = vertexIndex;
        this.predecessor = predecessor;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public ShortestPathVertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(ShortestPathVertex vertex) {
        predecessor = vertex;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
