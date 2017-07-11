package bigO.src.graphs.utils;

/**
 * Created by Stanimir on 5/22/17.
 */
public class Path implements Comparable {
    private Integer distance;
    private VertexImpl previous;
    boolean isStart;

    public Path(VertexImpl v, int d) {
        this.previous = v;
        this.distance = d;
    }

    public Path(VertexImpl v, int d, boolean isStart) {
        this.previous = v;
        this.distance = d;
        this.isStart = isStart;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Object o) {
        return distance.compareTo(((Path) o).getDistance());
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public VertexImpl getPrevious() {
        return previous;
    }

    public boolean isStart() {
        return isStart;
    }
}
