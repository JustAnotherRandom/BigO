package bigO.src.practice.utils;

import java.util.Objects;

/**
 * Created by Stanimir on 5/29/17.
 */
public class Point {
    public int row;
    public int col;

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

    @Override
    public String toString() {
        return "Row:" + row + " Col:" + col;
    }
}
