package bigO.src.graphs.practice;

import bigO.src.graphs.utils.Edge;
import bigO.src.graphs.utils.Graph;
import bigO.src.graphs.utils.Vertex;

import java.util.*;


/**
 * Created by Stanimir on 5/8/17.
 */
public class DjikstraSP {

    Graph g;

    Map<String, Path> paths;
    Map<String, Map<String, Integer>> edgesFromSources;

    public DjikstraSP(Graph g) {
        this.g = g;
    }

    /*
    *
    * Qeueue, visited, costs
    * keep track of the path for all nodes
    * //DFS
    * // for each neigthbour --> Update shortest path
    *
    *
    *
    *
    * */
    public void execute(Vertex src) {

        edgesFromSources = precomputeGraph();

        Deque<String> q = new ArrayDeque<>();

        paths = new HashMap<>();


        q.add(src.getId());
        Path srcPath = new Path(src.getId());
        srcPath.cost = 0;
        paths.put(src.getId(), srcPath);


        Set<String> visited = new HashSet<>();


        while (!q.isEmpty()) {
            String currentId = q.remove();

            if (!visited.contains(currentId)) {
                visited.add(currentId);
                Path currentPath = paths.get(currentId);

                Map neightboringEdges = edgesFromSources.get(currentId);
                if (neightboringEdges != null) {
                    Set<String> neightbours = edgesFromSources.get(currentId).keySet();
                    for (String nId : neightbours) {
                        Path neightbourPath = paths.get(nId);
                        int linkWeigth = edgesFromSources.get(currentId).get(nId);

                        int pathWeight = linkWeigth + currentPath.cost;
                        if (neightbourPath == null || pathWeight < neightbourPath.cost) {
                            Path currentPAth = paths.get(currentId);

                            Path shortestPath = new Path(nId,currentPAth,pathWeight);

                            paths.put(nId, shortestPath);
                        }

                        q.offer(nId);
                    }
                }

            }


        }

        System.out.println();
    }

    private Map<String, Map<String, Integer>> precomputeGraph() {
        Map<String, Map<String, Integer>> edgesFromSources = new HashMap<>();
        for (Edge e : g.edges) {
            Vertex srcE = e.getSource();
            Vertex dstE = e.getDestination();
            int weigth = e.getWeight();

            Map<String, Integer> destToWeight = edgesFromSources.get(srcE.getId());
            if (destToWeight == null) {
                destToWeight = new HashMap<>();
                edgesFromSources.put(srcE.getId(), destToWeight);
            }
            destToWeight.put(dstE.getId(), weigth);
        }
        return edgesFromSources;
    }

    static class Path {
        int cost;
        Path previous;
        String vertexId;

        public Path(String id) {

            vertexId=id;
        }

        public Path(String nId, Path prev, int pathWeight) {
            this.vertexId=nId;
            previous=prev;
            cost=pathWeight;
        }

    }

    public void shortestPAth(Vertex dest) {
        Path shortestPath = paths.get(dest.getId());
        System.out.println(shortestPath.cost);
        while(shortestPath != null){
            System.out.println(shortestPath.vertexId);
            shortestPath=shortestPath.previous;
        }

    }


}
