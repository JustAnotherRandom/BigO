//package bigO.tests;
//
//import bigO.src.games.Tetris.Board;
//import bigO.src.games.Tetris.Game;
//import bigO.src.games.Tetris.TetrisImpl;
//import bigO.src.games.Tetris.pieces.BasePiece;
//import bigO.src.games.Tetris.pieces.Piece;
//import bigO.src.games.Tetris.pieces.TetrisPoint;
//import org.junit.Test;
//
//import java.awt.*;
//
//import static junit.framework.TestCase.assertTrue;
//
///**
// * Created by Stanimir on 7/8/17.
// */
//public class BoardTest {
//
//    @Test
//    public void clearRowTest() {
//        Game g = new TetrisImpl();
//        Board board = new Board(g);
//
//
//        TetrisPoint[] mockPoints = new TetrisPoint[Board.WIDTH];
//
//        for (int col = 0; col < Board.WIDTH; col++) {
//            TetrisPoint p = new TetrisPoint(col, 0);
//            mockPoints[col] = p;
//        }
//        Piece p = new TestPiece(board, mockPoints);
//        board.insertPiece(p);
//
//        TetrisPoint[][] board = board.getWell();
//        for (int i = 0; i < Board.WIDTH; i++) {
//            assertTrue(board[i][0] == null);
//        }
//    }
//
//
//    static class TestPiece extends BasePiece {
//        TetrisPoint[] points;
//        Color c = null;
//
//
//        TestPiece(Board board, TetrisPoint... points) {
//            super(board);
//            this.points = points;
//        }
//
//        @Override
//        public void rotateClockWise() {
//
//        }
//
//        @Override
//        public void rotateCounterClockWise() {
//
//        }
//
//        @Override
//        public TetrisPoint[] getPoints() {
//            return points;
//        }
//
//
//    }
//
//}
