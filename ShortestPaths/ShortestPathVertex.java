package Graph.ShortestPaths;

public class ShortestPathVertex {

    private int index;
    private ShortestPathVertex predecessor;
    private int distance;
    private int discoverTime;
    private int finishTIme;
    private int color;

    private static final int WHITE = 0;
    private static final int GRAY  = 1;
    private static final int BLACK = 2;


    /**
     * The maximum weight in this graph
     */
    private static final int MAX_DISTANCE = 10000;

    private static final ShortestPathVertex NIL = new ShortestPathVertex(-1, null, 0);


    ShortestPathVertex(int vertexIndex) {
        this.index = vertexIndex;
        this.predecessor = NIL;
        this.distance = MAX_DISTANCE;
        this.discoverTime = 0;
        this.finishTIme = 0;
        this.color = WHITE;
    }

    ShortestPathVertex(ShortestPathVertex anotherVertex) {
        this.index = anotherVertex.getIndex();
        this.predecessor = anotherVertex.getPredecessor();
        this.distance = anotherVertex.getDistance();
        this.discoverTime = anotherVertex.getDiscoverTime();
        this.finishTIme = anotherVertex.getFinishTIme();
        this.color = anotherVertex.getColor();
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

    public int getDiscoverTime() {
        return discoverTime;
    }

    public void setDiscoverTime(int discoverTime) {
        this.discoverTime = discoverTime;
    }

    public int getFinishTIme() {
        return finishTIme;
    }

    public void setFinishTIme(int finishTIme) {
        this.finishTIme = finishTIme;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
