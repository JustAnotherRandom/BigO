package bigO.src.practice.largerproblems.tiltmaze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Stanimir on 6/8/17.
 */
public class Point {

    private int x;
    private int y;
    private List<String> types;

//    protected Point(int board_sizex, int x, int y){
//        verify(board_sizex, x, y, types);
//        this.x=x;
//        this.y=y;
//    }

    protected Point(int board_size, int x, int y, CordinateType... types) {
        verify(board_size, x, y, types);
        this.types = new ArrayList();
        this.x = x;
        this.y = y;
        this.types = Arrays.stream(types).map(e -> e.name()).collect(Collectors.toList());
    }

    private void verify(int board_size, int x, int y, CordinateType... types) {
        if (x < 0 || x >= board_size || y < 0 || y >= board_size || types == null) {
            throw new IllegalArgumentException("Invalid argumetns");
        }
    }

    public void applyStyle(CordinateType... styles) {
        if (styles != null) {
            for (CordinateType t : styles) {
                types.add(t.name());
            }
        }
    }


    //TODO Protected?
    public List<String> getTypes() {
        return types;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Point, x=").append(x).append(" ");
        sb.append("Point, y=").append(y).append(" ");
        sb.append("Types: ");
        for (String t : types) {
            sb.append(t).append(" ");
        }

        return sb.toString();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
