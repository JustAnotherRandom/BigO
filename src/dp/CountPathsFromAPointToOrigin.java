package bigO.src.dp;

/**
 * Created by Stanimir on 6/14/17.
 * http://www.geeksforgeeks.org/counts-paths-point-reach-origin/
 */
public class CountPathsFromAPointToOrigin {

    public static int topDownDP(int x, int y) {
        int[][] cache = new int[x + 1][y + 1];
        return countDP(x, y, cache);

    }

    private static int countDP(int x, int y, int[][] cache) {
        if (x == 0 && y == 0) return 0;
        if (x == 0 || y == 0) return 1;

        int val = cache[x][y];
        if (val > 0) return val;

        cache[x][y] = topDownDP(x - 1, y) + topDownDP(x, y - 1);
        return cache[x][y];
    }

    public static int bottomUpDP(int targetX, int targetY) {
        int[][] cache = new int[targetX + 1][targetY + 1];

        for (int i = 0; i <= targetX; i++) {
            cache[i][0]=1;
        }
        for (int i = 0; i <= targetY; i++) {
            cache[0][i]=1;
        }


        for (int x = 1; x <= targetX; x++) {
            for (int y = 1; y <= targetY; y++) {
                cache[x][y]= cache[x-1][y]+ cache[x][y-1];
            }
        }


        return cache[targetX][targetY];
    }
}
