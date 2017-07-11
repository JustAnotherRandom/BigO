//package bigO.src.practice.foobar;
//
///**
// * Created by Stanimir on 5/10/17.
// */
//
//import java.util.ArrayDeque;
//import java.util.Arrays;
//import java.util.Deque;
//
//
///**
// * Created by Stanimir on 5/9/17.
// * Don't Get Volunteered!
// * ======================
// * <p>
// * As a henchman on Commander Lambda's space station, you're expected to be resourceful, smart, and a quick thinker. It's not easy building a doomsday device and capturing bunnies at the same time, after all! In order to make sure that everyone working for her is sufficiently quick-witted, Commander Lambda has installed new flooring outside the henchman dormitories. It looks like a chessboard, and every morning and evening you have to solve a new movement puzzle in order to cross the floor. That would be fine if you got to be the rook or the queen, but instead, you have to be the knight. Worse, if you take too much time solving the puzzle, you get "volunteered" as a test subject for the LAMBCHOP doomsday device!
// * <p>
// * To help yourself get to and from your bunk every day, write a function called answer(src, dest) which takes in two parameters: the source square, on which you start, and the destination square, which is where you need to land to solve the puzzle.  The function should return an integer representing the smallest number of moves it will take for you to travel from the source square to the destination square using a chess knight's moves (that is, two squares in any direction immediately followed by one square perpendicular to that direction, or vice versa, in an "L" shape).  Both the source and destination squares will be an integer between 0 and 63, inclusive, and are numbered like the example chessboard below:
// * <p>
// * -------------------------
// * | 0| 1| 2| 3| 4| 5| 6| 7|
// * -------------------------
// * | 8| 9|10|11|12|13|14|15|
// * -------------------------
// * |16|17|18|19|20|21|22|23|
// * -------------------------
// * |24|25|26|27|28|29|30|31|
// * -------------------------
// * |32|33|34|35|36|37|38|39|
// * -------------------------
// * |40|41|42|43|44|45|46|47|
// * -------------------------
// * |48|49|50|51|52|53|54|55|
// * -------------------------
// * |56|57|58|59|60|61|62|63|
// * -------------------------
// * <p>
// * Languages
// * =========
// * <p>
// * To provide a Python solution, edit solution.py
// * To provide a Java solution, edit solution.java
// * <p>
// * Test cases
// * ==========
// * <p>
// * Inputs:
// * (int) src = 19
// * (int) dest = 36
// * Output:
// * (int) 1
// * <p>
// * Inputs:
// * (int) src = 0
// * (int) dest = 1
// * Output:
// * (int) 3
// */
//public class Answer3_1_res {
//
//    private static class Point {
//        private int x;
//        private int y;
//
//        public Point(int x) {
//            this.x = x / 8;
//            this.y = x % 8;
//        }
//
//        public Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//
//    public static final int[] xValues = new int[]{1, -1, 1, -1, -2, 2, -2, 2};
//    public static final int[] yValues = new int[]{2, -2, -2, 2, -1, -1, 1, 1};
//
//    public static int answer(int src, int dest) {
//
//        if (src < 0 || src > 63 || dest < 0 || dest > 63) return -1;
//        Answer3_1_res app = new Answer3_1_res();
//
//        int[][] board = new int[8][8];
//        for (int[] a : board) {
//            Arrays.fill(a, -1);//1
//        }
//
//        Point source = new Point(src);
//        Point destination = new Point(dest);
//
//        app.bfs(board, source);
//        return board[destination.x][destination.y];
//    }
//
//    private void bfs(int[][] board, Point source) {
//        Deque<Point> q = new ArrayDeque<>();
//        board[source.x][source.y] = 0;
//        q.addFirst(source);
//        while (!q.isEmpty()) {
//            Point previous = q.remove();
//
//            for (int nextX = 0; nextX < xMoves.length; nextX++) {
//                for (int nextY = 0; nextY < yMoves.length; nextY++) {
//                    if (Math.abs(nextX) == Math.abs(nextY)) continue;
//
//                    Point newPoint = new Point(previous.x + xMoves[nextX], previous.y + yMoves[nextY]);
//                    if (isInBounds(board, newPoint) && (!isVisited(board, newPoint))) {
//                        board[newPoint.x][newPoint.y] = board[previous.x][previous.y] + 1;
//
//                        q.addLast(newPoint);
//                    }
//
//                }
//
//            }
//
//
//        }
//    }
//
//    private boolean isVisited(int[][] board, Point p) {
//        return board[p.x][p.y] != -1;
//    }
//
//    private boolean isInBounds(int[][] board, Point p) {
//        return p.x >= 0 && p.x <= 7 && p.y >= 0 && p.y <= 7;
//    }
//
//
//}
