package bigO.src.practice.randomCompanies;

// This is the text editor interface.
// Anything you type or change here will be seen by the other person in real time.

/*
 *
 * a board c d e
 * e f g h i
 * j k l m n
 * o p q r s
 * t u v w x
 * y z
 *
 *
 * breaking
 *
 * r1!r2d3!r1u3!l4!....
 *
 */


// Remote (String characterSet = "abcdefghijkl...", width = 5)

//  String getDirections(String search){
//      StringBuilder sb = new StringBuilder()


//  }

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Remote {

    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {

            return x == ((Location) obj).x && y == ((Location) obj).y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "x: " + x + " y: " + y;
        }
    }

    Map<String, Location> map = new HashMap<>();

    public Remote(String charset, int width) {

        int row = 0;
        int col = 0;

        String[] chars = charset.split(",");

        for (int i = 0; i < chars.length; i++) {
            String c = chars[i];

            map.put(c, new Location(col, row));


            if (col == width - 1) {
                row++;
                col = 0;
            } else {
                col++;
            }

        }
    }


    public String getDirections(String search) {
        StringBuilder sb = new StringBuilder();
        Location currentLoc = new Location(0, 0);
        String[] chars = search.split("");
        for (int i = 0; i < chars.length; i++) {
            Location letterLoc = map.get(chars[i]);
            if (letterLoc != null) {
                if (currentLoc.equals(letterLoc)) {
                    sb.append("!");
                    break;
                } else {
                    int xMove = calculateX(currentLoc, letterLoc);
                    int yMove = calculateY(currentLoc, letterLoc);
                    append(sb, currentLoc, xMove, yMove);
                }
                currentLoc = letterLoc;
            }
        }
        return sb.toString();
    }

    int calculateX(Location currentLoc, Location letterLoc) {
        return letterLoc.x - currentLoc.x;
    }

    int calculateY(Location currentLoc, Location letterLoc) {
        return letterLoc.y - currentLoc.y;
    }


    void append(StringBuilder sb, Location current, int x, int y) {
        if (x < 0) {
            append(sb, 'l', x);
        } else if (x == 0) {
            //donothing
        } else {
            append(sb, 'r', x);
        }

        if (y < 0) {
            append(sb, 'u', y);
        } else if (y == 0) {
            //donothing
        } else {
            append(sb, 'd', y);
        }
        sb.append("!");
    }

    void append(StringBuilder sb, char direction, int move) {
        sb.append("" + direction + Math.abs(move));
    }


    public static void main(String str[]) {
        Remote remote = new Remote("a,board,c,d,e,f,g,h,i,z,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y", 5);
        System.out.printf(remote.getDirections("breaking"));
    }
}
//        * a board c d e
//        * f g h i z
//        * j k l m n
//        * o p q r s
//        * t u v w x
//        * y
