package bigO.src.graphs.utils;


/**
 * Created by Stanimir on 5/8/17.
 */
public class EdgeImpl implements Edge{
    private final String id;
    private final Vertex source;
    private final Vertex destination;
    private final int weight;

    public EdgeImpl(String id, Vertex source, Vertex destination, int weight) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public Vertex getDestination() {
        return destination;
    }

    public Vertex getSource() {
        return source;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return source + " " + destination;
    }


}
