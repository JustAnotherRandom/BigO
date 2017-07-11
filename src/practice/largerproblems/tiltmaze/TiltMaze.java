package bigO.src.practice.largerproblems.tiltmaze;

import bigO.src.practice.largerproblems.tiltmaze.utils.BoardPrinter;

/**
 * Created by Stanimir on 6/7/17.
 */
public class TiltMaze {


    private int size;
    private Point[][] board;

    public TiltMaze(int size) {
        this.size = size;
        BoardGenerator generator = new BoardGenerator();
        board = generator.generate(size);


        BoardPrinter printer = new BoardPrinter();
        printer.print(board);

    }


    public static void main(String[] str) {
        TiltMaze maze = new TiltMaze(8);
        maze.solve();


    }

    private void solve() {


    }

}
