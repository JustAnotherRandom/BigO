package bigO.src.practice.google.matrix;

import bigO.src.practice.utils.Point;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Stanimir on 5/29/17.
 */
public class FindPathMine {

    public static final char START = '2';
    public static final char END = '3';
    public static final char LAND = '1';
    public static final char WATER = '0';


    public static void main(String args[]) {
        char[][] board2 = {
                {'0', '2', '1', '1', '1'},
                {'0', '1', 'a', '0', 'A'},
                {'0', '1', '0', '0', '3'},
                {'0', '1', '0', '0', '1'},
                {'0', '1', '1', '1', '1'}};

        Path solution = solve(board2);
        System.out.println(solution.toString());
//        solution.stream().map(v -> v.toString()).forEach(System.out::println);

    }

    private static Path solve(char[][] board) {

        Point start = null;
        Point end = null;


        for (int row = 0; row < board.length; row++) {//n^2
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == START) {
                    start = new Point(row, col);
                } else if (board[row][col] == END) {
                    end = new Point(row, col);
                }

            }
        }
        Set<Point> visited = new HashSet<>();
        Set<Character> keys = new HashSet<>();

        return solve(board, start, end, visited, new Path(), keys);
    }


    /*              {'0', '2', '1', '1', '1'},
                    {'0', '1', 'a', '0', 'A'},
                    {'0', '1', '0', '0', '3'},
                    {'0', '1', '0', '0', '1'},
                    {'0', '1', '1', '1', '1'}};*/
    private static Path solve(char[][] board, Point current, Point end, Set<Point> visited, Path path, Set<Character> keys) {
        path.add(current);
        if (visited.contains(current)) return path;

        if (current.equals(end)) {
            return path;
        }

        if (Character.isLowerCase(getValue(board, current))) {
            keys.add(getValue(board, current));
        }

        if (Character.isUpperCase(getValue(board, current))) {
            char character = getValue(board, current);
            if (keys.contains(Character.toLowerCase(getValue(board, current)))) {
                return path;
            }
        }

        visited.add(current);
        List<Point> neightbours = getNeightbours(board, current, visited);


        List<Path> results = neightbours.stream()
                .filter(e -> e != null)
                .map(e -> solve(board, e, end, visited, new Path(), keys))
                .collect(Collectors.toList());
        if (results.size() > 0)
            Collections.sort(results);//nlogn
        Path res = results.isEmpty() ? null : path.add(results.get(0));
        return res;
    }

    /*              {'0', '2', '1', '1', '1'},
                    {'0', '1', 'a', '0', 'A'},
                    {'0', '1', '0', '0', '3'},
                    {'0', '1', '0', '0', '1'},
                    {'0', '1', '1', '1', '1'}};*/
    public static final int[] directions = new int[]{0, 1, -1};

    static int[] xO = new int[]{0, 0, 1, -1};
    static int[] yO = new int[]{-1, 1, 0, 0};

    private static List<Point> getNeightbours(char[][] board, Point current, Set<Point> visited) {
        int row = current.row;
        int col = current.col;
        Set<Point> result = new HashSet<>(4);

//        if (col > 0){
//            result.addFirst({x-1, y});
//        }
//        if y > 0:
//        result.addFirst({x, y-1});
//        if row < maxX:
//        result.addFirst({x+1, y});
//        if col < maxY:
//        result.addFirst({x, y+1});


        for (int i = 0; i < xO.length; i++) {//o(1)
            for (int j = 0; j < xO.length; j++) {
                int tr = row + xO[i];
                int tc = col + yO[j];
                Point p = new Point(tr, tc);
                if (isInBounds(board, p) && !isVisited(p, visited)) {
                    result.add(p);
                }

            }
        }
        return new ArrayList<>(result);
    }

    private static boolean isInBounds(char[][] board, Point p) {
        int row = p.row;
        int col = p.col;
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }

    private static boolean isVisited(Point point, Set<Point> visited) {
        return visited.contains(point);
    }

    private static char getValue(char[][] board, Point current) {
        return board[current.row][current.col];
    }

    static class Path implements Comparable {
        public LinkedList<Point> path;
        public Point current;
        public int length;

        public Path() {
            path = new LinkedList<>();
        }

        public Path(Point point, int length) {
            this.current = point;
            this.length = length;
        }

        LinkedList<Point> collapse() {
            LinkedList<Point> result = new LinkedList();
            path.addFirst(current);
            return path;
        }

        public Path add(Path p) {
            path.addAll(p.getPath());
            return this;
        }


        @Override
        public int compareTo(Object o) {
            return Integer.compare(path.size(), ((Path) o).getPath().size());
        }

        public int getLength() {
            return length;
        }

        public LinkedList<Point> getPath() {
            return path;
        }

        public Path add(Point p) {
            if (p != null)
                path.add(current);
            return this;
        }
    }
}
