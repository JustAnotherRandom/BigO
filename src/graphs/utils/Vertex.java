package bigO.src.graphs.utils;

import java.util.List;

/**
 * Created by Stanimir on 6/30/17.
 */
public interface Vertex {

    void setWeigth(int w);

    int getWeigth();

    String getId();

    String getName();

    void addNeightbour(Vertex destination);

    List<Vertex> getNeightbours();
}
