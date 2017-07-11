package bigO.src.graphs.utils;


import java.util.*;

/**
 * Created by Stanimir on 5/8/17.
 */
public class VertexImpl implements Vertex {
    private String id;
    private String name;
    private List<Vertex> neightbours = new ArrayList<>();

    private int weigth=Integer.MAX_VALUE;

    @Override
    public void setWeigth(int w){
        this.weigth=w;
    }
    @Override
    public int getWeigth(){
        return weigth;
    }

    public Set<LinkedList<Vertex>> previousRoutes = new HashSet<>();


    public VertexImpl(String id, String name) {
        this.id = id;
        this.name = name;
    }


    public VertexImpl(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (id == null) {
            if (other.getId() != null)
                return false;
        } else if (!id.equals(other.getId()))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public void addNeightbour(Vertex destination) {
        neightbours.add(destination);
    }

    @Override
    public List<Vertex> getNeightbours() {
        return neightbours;
    }
}
