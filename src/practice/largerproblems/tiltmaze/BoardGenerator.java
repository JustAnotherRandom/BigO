package bigO.src.practice.largerproblems.tiltmaze;

/**
 * Created by Stanimir on 6/8/17.
 */
public class BoardGenerator {
    private static final int DEFAULT_SIZE = 10;

    private Point[][] board;
    private int size = DEFAULT_SIZE;

    protected Point[][] generate(int size) {
        this.size = size;
        board = new Point[size][size];
        generateOuterWalls();


        return board;
    }

    private void generateOuterWalls() {//n
        for (int i = 0; i < size; i++) {
            applyStyle(0, i, CordinateType.NORTH);
            applyStyle(size - 1, i, CordinateType.SOUTH);
            applyStyle(0, i, CordinateType.WEST);
            applyStyle(size - 1, i, CordinateType.EAST);
        }
    }

    private void applyStyle(int x, int y, CordinateType style) {
        Point focusPoint = getPoint(x, y);
        focusPoint.applyStyle(style);
    }

    private Point getPoint(int x, int y) {
        if (board[x][y] == null) {
            board[x][y] = new Point(size, x, y);
        }
        return board[x][y];
    }
}
