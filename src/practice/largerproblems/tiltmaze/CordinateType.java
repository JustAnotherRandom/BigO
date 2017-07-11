package bigO.src.practice.largerproblems.tiltmaze;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stanimir on 6/8/17.
 */
public enum CordinateType {
    NORTH("north", 1),
    SOUTH("south", 2),
    EAST("east", 3),
    WEST("west", 4),
    SOURCE("source", 0),
    TARGET("target", 5),
    EMPTY("empty", 6);
    private String name;
    private byte value;

    private static Map<String, CordinateType> TYPE_KINDS = new HashMap<String, CordinateType>();

    static {
        for (CordinateType k : EnumSet.allOf(CordinateType.class)) {
            TYPE_KINDS.put(k.name, k);

        }

    }

    CordinateType(String name, int value) {
        this.name = name;
        this.value = (byte) value;
    }

    public static CordinateType forName(String name) {

        return TYPE_KINDS.get(name.toLowerCase());
    }




}
