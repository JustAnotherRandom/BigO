package bigO.src.graphs.utils;


/**
 * Created by Stanimir on 6/30/17.
 */
public interface Edge {
    Vertex getSource();

    Vertex getDestination();

    int getWeight();
}
