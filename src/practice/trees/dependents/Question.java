package bigO.src.practice.trees.dependents;

import java.util.*;

/**
 * Created by Stanimir on 3/23/17.
 */
public class Question {

    public static void main(String[] str) throws Exception {
        String[] projects = {"a", "board", "c", "d", "e", "f"};
        String[][] dependencies = {
                {"a", "d"},
                {"f", "board"},
                {"board", "d"},
                {"f", "a"},
                {"d", "c"},
        };

//        String[] projects = {"a", "board", "c"};
//        String[][] dependencies = {
//                {"a", "c"},
//                {"a", "board"},
//                {"board", "a"},
//        };

        Question app = new Question();
        Graph graph = app.buildGraph(projects, dependencies);

        String[] sequence = findSequence(graph);
        for (String s : sequence) {
            System.out.print(s + " ");
        }

        Random r = new Random();
        System.out.println(r.nextBoolean());

    }

    private static String[] findSequence(Graph graph) throws Exception {
        List<Node> result = new ArrayList<>();


        Deque<Node> temp = new ArrayDeque<>();
        for (Node project : graph.getNodes()) {
            if (project.getDependents() == 0) {
//                result.addFirst(project);
                temp.add(project);
            }
        }

        while (!temp.isEmpty()) {
            Node current = temp.remove();

            if (current.getState() != Graph.State.Visited) {

                current.setState(Graph.State.Visiting);

                if (current.getDependents() == 0) {
                    current.setState(Graph.State.Visited);
                    result.add(current);
                } else {
                    continue;
                }

                List<Node> neightbors = current.getNieghtbor();
                for (Node neightbor : neightbors) {
                    if (neightbor.getState() == Graph.State.Visiting) {
                        System.out.println("loop");
                        throw new Exception("loop");
                    }
                    neightbor.decrementDependents();

                    temp.add(neightbor);

                }
            }


        }
        if (result.size() != graph.getNodes().size()) {
            throw new Exception("cannot be built");
        }

        return generateStringRes(result);
    }

    private static String[] generateStringRes(List<Node> result) {
        String[] stringArray = result.stream().map(e -> e.getValue().toString()).toArray(String[]::new);
        return stringArray;
    }

    private Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String p : projects) {
            graph.getOrCreate(p);
        }
        for (int i = 0; i < dependencies.length; i++) {

            Node from = graph.getOrCreate(dependencies[i][1]);
            Node to = graph.getOrCreate(dependencies[i][0]);
            graph.addDependent(from, to);
        }
        return graph;
    }

}
