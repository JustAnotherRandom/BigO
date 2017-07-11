package bigO.src.practice.google.matrix;

import java.util.*;

public class FindPath {

    public static class Point {
        int row;
        int col;

        public Point(int x, int y) {
            super();
            this.row = x;
            this.col = y;
        }

        @Override
        public boolean equals(Object o) {

            if (o == this)
                return true;
            if (!(o instanceof Point)) {
                return false;
            }
            Point point = (Point) o;
            return row == point.row && col == point.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    public static void main(String args[]) {
        char[][] board2 = {
                {'0', '2', '1', '1', '1'},
                {'0', '1', 'a', '0', 'A'},
                {'0', '1', '0', '0', '3'},
                {'0', '1', '0', '0', '1'},
                {'0', '1', '1', '1', '1'}};

        List<int[]> solution = solve(board2);
        for (int[] pos : solution) {
            System.out.println(Arrays.toString(pos));
        }
    }

    public static List<int[]> solve(char[][] board) {
        Point start = null;
        Point goal = null;
        HashSet<Point> visited = new HashSet<Point>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '2') {
                    start = new Point(i, j);
                } else if (board[i][j] == '3') {
                    goal = new Point(i, j);
                }
            }
        }

        return solve(start, board, visited, goal, new LinkedList<int[]>(), new HashSet<Character>());
    }

    private static List<int[]> solve(Point cur, char[][] board, HashSet<Point> visited, Point goal,
                                     LinkedList<int[]> solution, HashSet<Character> keys) {

        if (cur.equals(goal)) {
            return (LinkedList<int[]>) solution.clone();
        }

        if (Character.isLowerCase(board[cur.row][cur.col])) {
            keys.add(board[cur.row][cur.col]);
        }

        visited.add(new Point(cur.row, cur.col));

        int row = cur.row;
        int col = cur.col;

        solution.add(new int[]{row, col});

        List<int[]> up = null;
        List<int[]> down = null;
        List<int[]> left = null;
        List<int[]> right = null;

        if (row - 1 >= 0 && board[row - 1][col] != '0' && !visited.contains(new Point(row - 1, col))
                && isOpenableIfDoor(board, row - 1, col, keys)) {
            cur.row -= 1;
            up = solve(cur, board, visited, goal, solution, keys);
            cur.row += 1;
        }
        if (row + 1 < board.length && board[row + 1][col] != '0' && !visited.contains(new Point(row + 1, col))
                && isOpenableIfDoor(board, row + 1, col, keys)) {
            cur.row += 1;
            down = solve(cur, board, visited, goal, solution, keys);
            cur.row -= 1;
        }
        if (col - 1 >= 0 && board[row][col - 1] != '0' && !visited.contains(new Point(row, col - 1))
                && isOpenableIfDoor(board, row, col - 1, keys)) {
            cur.col -= 1;
            left = solve(cur, board, visited, goal, solution, keys);
            cur.col += 1;
        }
        if (col + 1 < board[0].length && board[row][col + 1] != '0' && !visited.contains(new Point(row, col + 1))
                && isOpenableIfDoor(board, row, col + 1, keys)) {
            cur.col += 1;
            right = solve(cur, board, visited, goal, solution, keys);
            cur.col -= 1;
        }

        List<List<int[]>> res = new LinkedList<List<int[]>>();
        res.add(up);
        res.add(down);
        res.add(left);
        res.add(right);
        Collections.sort(res, new Comparator<List<int[]>>() {

            @Override
            public int compare(List<int[]> arg0, List<int[]> arg1) {
                if (arg0 != null && arg1 != null) {
                    return Integer.compare(arg0.size(), arg1.size());
                } else if (arg0 != null) {
                    return -1;
                } else if (arg1 != null) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        if (Character.isLowerCase(board[cur.row][cur.col])) {
            keys.remove(board[cur.row][cur.col]);
        }
        solution.removeLast();
        visited.remove(new Point(row, col));
        return res.get(0);
    }

    private static boolean isOpenableIfDoor(char[][] board, int i, int j, HashSet<Character> keys) {
        if (Character.isUpperCase(board[i][j])) {
            return keys.contains(Character.toLowerCase(board[i][j]));
        }
        return true;
    }
}
