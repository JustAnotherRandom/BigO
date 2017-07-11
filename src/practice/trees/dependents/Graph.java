package bigO.src.practice.trees.dependents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Stanimir on 3/23/17.
 */
public class Graph {
    enum State {
        Blank, Visiting, Visited
    }

    private List<Node> nodes = new ArrayList<>();
    private Map<Node, Node> edges = new HashMap<>();
    private Map<String, Node> map = new HashMap<>();

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public Node getOrCreate(String name) {
        if (!map.containsKey(name)) {
            Node<String> node = new Node<>(name);
            nodes.add(node);
            return map.put(name, node);
        } else {
            return map.get(name);
        }

    }

    public void addDependent(Node from, Node to) {
        from.addNieghtbor(to);
        to.incrementDependents();
        edges.put(from, to);
    }
}
