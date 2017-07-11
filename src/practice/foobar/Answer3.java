package bigO.src.practice.foobar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by Stanimir on 5/9/17.
 * Don't Get Volunteered!
 * ======================
 * <p>
 * As a henchman on Commander Lambda's space station, you're expected to be resourceful, smart, and a quick thinker. It's not easy building a doomsday device and capturing bunnies at the same time, after all! In order to make sure that everyone working for her is sufficiently quick-witted, Commander Lambda has installed new flooring outside the henchman dormitories. It looks like a chessboard, and every morning and evening you have to solve a new movement puzzle in order to cross the floor. That would be fine if you got to be the rook or the queen, but instead, you have to be the knight. Worse, if you take too much time solving the puzzle, you get "volunteered" as a test subject for the LAMBCHOP doomsday device!
 * <p>
 * To help yourself get to and from your bunk every day, write a function called answer(src, dest) which takes in two parameters: the source square, on which you start, and the destination square, which is where you need to land to solve the puzzle.  The function should return an integer representing the smallest number of moves it will take for you to travel from the source square to the destination square using a chess knight's moves (that is, two squares in any direction immediately followed by one square perpendicular to that direction, or vice versa, in an "L" shape).  Both the source and destination squares will be an integer between 0 and 63, inclusive, and are numbered like the example chessboard below:
 * <p>
 * -------------------------
 * | 0| 1| 2| 3| 4| 5| 6| 7|
 * -------------------------
 * | 8| 9|10|11|12|13|14|15|
 * -------------------------
 * |16|17|18|19|20|21|22|23|
 * -------------------------
 * |24|25|26|27|28|29|30|31|
 * -------------------------
 * |32|33|34|35|36|37|38|39|
 * -------------------------
 * |40|41|42|43|44|45|46|47|
 * -------------------------
 * |48|49|50|51|52|53|54|55|
 * -------------------------
 * |56|57|58|59|60|61|62|63|
 * -------------------------
 * <p>
 * Languages
 * =========
 * <p>
 * To provide a Python solution, edit solution.py
 * To provide a Java solution, edit solution.java
 * <p>
 * Test cases
 * ==========
 * <p>
 * Inputs:
 * (int) src = 19
 * (int) dest = 36
 * Output:
 * (int) 1
 * <p>
 * Inputs:
 * (int) src = 0
 * (int) dest = 1
 * Output:
 * (int) 3
 */
public class Answer3 {

    static class Point {
        int x;
        int y;

        public Point(int x) {
            int xCord = x / 8;
            int yCord = x % 8;
            this.x = xCord;
            this.y = yCord;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static final int[] xMoves = new int[]{-2, -1, 1, 2};
    static final int[] yMoves = new int[]{-2, -1, 1, 2};

    public static void main(String[] str) {


//        answer(10, 19);
        System.out.println(answer(0, 1)); //3
        System.out.println(answer(-1, 1)); //3
        System.out.println(answer(19, 36)); //1
//        System.out.println(answer(19, 53)); //2
    }

    public static int answer(int src, int dest) {
        if ((src < 0 || src > 63) || (dest < 0 || dest > 63)) return -1;

        int[][] board = board = new int[8][8];
        for (int[] a : board) {
            Arrays.fill(a, -1);//1
        }

        Point source = new Point(src);
        Point destination = new Point(dest);
        bfs(source, destination, board);

        return board[destination.x][destination.y];
    }

    private static void bfs(Point src, Point dst, int[][] board) {
        Deque<Point> q = new ArrayDeque<>();
        board[src.x][src.y] = 0;
        q.add(src);

        System.out.println();
        while (!q.isEmpty()) {//n
            Point previous = q.removeFirst();
//            System.out.println("for point: x=" + previous.x + " y=" + previous.y);

            for (int nextX = 0; nextX < xMoves.length; nextX++) {
                for (int nextY = 0; nextY < yMoves.length; nextY++) {
                    if (Math.abs(nextX) == Math.abs(nextY)) continue;

                    Point newPoint = new Point(previous.x + xMoves[nextX], previous.y + yMoves[nextY]);
//                    if (isInBounds(newPoint.x, newPoint.y) && !isVisited(board, newPoint.x, newPoint.y)) {
                    if (isInBounds(newPoint.x, newPoint.y) && (!isVisited(board, newPoint.x, newPoint.y))) {
                        board[newPoint.x][newPoint.y] = board[previous.x][previous.y] + 1;
//                        board[newPoint.x][newPoint.y] = calculateNewWeigth(board, newPoint, previous);
                        print(board);
                        q.addLast(newPoint);
                    }

                }

            }
        }
    }

    private static int calculateNewWeigth(int[][] board, Point newPoint, Point oldPoint) {

        if (isVisited(board, newPoint.x, newPoint.y)) {
            board[newPoint.x][newPoint.y] = Math.min(board[newPoint.x][newPoint.y], board[oldPoint.x][oldPoint.y] + 1);
        } else {
            board[newPoint.x][newPoint.y] = board[oldPoint.x][oldPoint.y] + 1;
        }

        return board[newPoint.x][newPoint.y];
    }

    private static boolean isVisited(int[][] board, int x, int y) {
        return board[x][y] != -1;
    }

    private static boolean pointEquals(Point destination, int x, int y) {
        return x == destination.x && y == destination.y;
    }

    private static boolean isInBounds(int x, int y) {
        return x >=0 && x <=7 && y >=0 && y <=7;
    }

    private static void print(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println();
        for (int x = 0; x < board.length; x++) {
            System.out.print(x);
            for (int y = 0; y < board.length; y++) {
                System.out.print(" " + board[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
