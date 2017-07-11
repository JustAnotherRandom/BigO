package bigO.src.practice.crackingthecodinginterview;

import java.util.*;

/**
 * Created by Stanimir on 6/27/17.
 */
public class BuildOrder_4_7 {
    public static <T> List<T> resolveBuildOrder(List<T> projects, List<T[]> dependencies) {


        Map<T, List<T>> depMap = new HashMap<>();
        for (T[] dep : dependencies) {
            T dependent = dep[1];//assumes input correctness//otherwise verify
            List<T> revDeps = depMap.get(dependent);
            if (revDeps == null) {
                revDeps = new ArrayList<>();
                depMap.put(dependent, revDeps);
            }
            revDeps.add(dep[0]);
        }


        Set<T> result = new LinkedHashSet<>();

        for (T p : projects) {//o(p*n*n*d
            if (!hasUnresolvedDependencies(p, depMap, result)) {
                result.add(p);
            } else {
                resolveDependenciesAndAddToResult(p, depMap, result);
            }
        }


        return new ArrayList<T>(result);
    }

    private static <T> void resolveDependenciesAndAddToResult(T startProject, Map<T, List<T>> depMap, Set<T> result) {
        Deque<T> toResolve = new ArrayDeque<>();
        toResolve.add(startProject);

        while (!toResolve.isEmpty()) {//o(n *n*d
            T p = toResolve.remove();
            if (hasUnresolvedDependencies(p, depMap, result)) {
                checkCircularAndAdd(toResolve, depMap.get(p));
                toResolve.add(p);
            } else {
                result.add(p);
            }
        }
    }

    private static <T> void checkCircularAndAdd(Deque<T> toResolve, List<T> deps) {//o(n * d) -> n number dependencies of y  --  >
        for (T d : deps) {
            if (toResolve.contains(d))
                throw new RuntimeException();//o(d) number of pending dependencies // could be optimized if the content of q maintained a separate set ?
            toResolve.add(d);
        }
    }

    private static <T> boolean hasUnresolvedDependencies(T p, Map<T, List<T>> depMap, Set<T> result) {
        List<T> dependencies = depMap.get(p);
        if (dependencies == null) return false;

        for (T d : dependencies) {
            if (!result.contains(d)) return true;
        }

        return false;
    }
}
