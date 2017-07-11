package bigO.src.practice.largerproblems.tiltmaze.utils;

import bigO.src.practice.largerproblems.tiltmaze.CordinateType;
import bigO.src.practice.largerproblems.tiltmaze.Point;
import bigO.lib.StdDraw;

import java.util.List;

/**
 * Created by Stanimir on 6/8/17.
 */
public class BoardPrinter {

    Point[][] board;

    public void print(Point[][] board) {
        this.board = board;
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                Point p = board[i][j];
//                if (p != null)
//                    sb.append(p.toString()).append(" ");
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb.toString());
        draw();
    }

    // draw the maze
    public void draw() {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledCircle(board.length / 2.0 + 0.5, board.length / 2.0 + 0.5, 0.375);
        StdDraw.filledCircle(1.5, 1.5, 0.375);

        StdDraw.setPenColor(StdDraw.BLACK);

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                Point p = board[row][col];
                drawPoint(p);
            }
        }

        StdDraw.setPenColor(StdDraw.GRAY);
//        StdDraw.filledCircle(x + 0.5, y + 0.5, 0.25);
        StdDraw.show();
//        StdDraw.pause(30);


//        for (int x = 1; x <= n; x++) {
//            for (int y = 1; y <= n; y++) {
//                if (south[x][y]) StdDraw.line(x, y, x + 1, y);
//                if (north[x][y]) StdDraw.line(x, y + 1, x + 1, y + 1);
//                if (west[x][y]) StdDraw.line(x, y, x, y + 1);
//                if (east[x][y]) StdDraw.line(x + 1, y, x + 1, y + 1);
//            }
//        }
        StdDraw.show();
        StdDraw.pause(1000);
    }

    private void drawPoint(Point p) {
        if (p == null) return;
        List<String> types = p.getTypes();

        for (String type : types) {

            switch (CordinateType.forName(type)) {
                case NORTH:
                    StdDraw.line(p.getX(), p.getY() + 1, p.getX() + 1, p.getY() + 1);
                    break;

                case SOUTH:
                    StdDraw.line(p.getX(), p.getY(), p.getX() + 1, p.getY());
                    break;

                case WEST:
                    StdDraw.line(p.getX(), p.getY(), p.getX(), p.getY() + 1);
                    break;
                case EAST:
                    StdDraw.line(p.getX() + 1, p.getY(), p.getX() + 1, p.getY() + 1);
                    break;
            }
        }

    }
}
