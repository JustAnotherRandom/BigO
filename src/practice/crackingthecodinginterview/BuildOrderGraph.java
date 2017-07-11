package bigO.src.practice.crackingthecodinginterview;

import java.util.*;

/**
 * Created by Stanimir on 6/28/17.
 */
public class BuildOrderGraph {


    public static <T> List<T> resolveBuildOrder(List<T> projects, List<T[]> dependencies) {


        Map<T, Project<T>> map = new HashMap<>();
        for (T[] dep : dependencies) {
            T first = dep[0];
            T second = dep[1];

            Project p = map.get(second);
            if (p == null) {
                p = new Project(second, first);
                map.put(second, p);
            }
            p.addIncomingLink(first);
        }
        List<T> result = buildOrder(map);
        return result;
    }

    private static <T> List<T> buildOrder(Map<T, Project<T>> map) {


        List<T> result = new ArrayList<>();
        for (Project<T> p : map.values()) {
            if (p.incomingLinks.isEmpty()) {
                result.add(p.project);
            } else {
                Set<T> incomingLinks = p.incomingLinks;
                for (T n : incomingLinks) {

                }
            }
        }
        return result;
    }



    static class Graph<T> {
        List<T> projects = new ArrayList<>();

        Graph(Collection<T> projects) {
            this.projects = (List<T>) projects;
        }

    }

    static class Project<T> {
        enum Status {COMPLETE, PARTIAL, BLANK}

        Status status = Status.BLANK;

        Set<T> incomingLinks = new HashSet<>();
        T project;


        Project(T project, T incoming) {
            incomingLinks.add(incoming);
            this.project = project;
        }

        public void addIncomingLink(T link) {
            incomingLinks.add(link);
        }
    }
}
