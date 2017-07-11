package bigO.src.arrays;

/**
 * Created by Stanimir on 6/12/17.
 */
public class Microsoft_Assignment {

    public static void main(String[] str) {
        int[][] grid = new int[][]{
                {1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1},

        };

        int width = 5;
        int height = 5;

        Microsoft_Assignment app = new Microsoft_Assignment();
        print(grid);
        System.out.println();

        int lvl = 1;
        while (app.nextGeneration(width, height, grid) == true) {
            System.out.println("level" + lvl++);
            print(grid);
        }
    }

    private static void print(int[][] grid) {

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println("");
        }
    }

    public boolean nextGeneration(int width, int height, int[][] grid) {
        int[][] temp = clone(grid);
        boolean hasAlive = false;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                boolean isAliveBefore = temp[row][col] == 1;

                boolean isAlive = tick(row, col, temp, isAliveBefore);
                if (isAlive) {
                    grid[row][col] = 1;
                    hasAlive = isAlive;
                } else {
                    grid[row][col] = 0;
                }


            }
        }

        return hasAlive;
    }

    private boolean tick(int row, int col, int[][] temp, boolean isAliveBefore) {
        int sum = 0;
        int[] n = getPoint(row - 1, col);
        sum += isAlive(n, temp);

        int[] nw = getPoint(row - 1, col - 1);
        sum += isAlive(nw, temp);

        int[] ne = getPoint(row - 1, col + 1);
        sum += isAlive(ne, temp);

        int[] s = getPoint(row + 1, col);
        sum += isAlive(s, temp);

        int[] sw = getPoint(row + 1, col - 1);
        sum += isAlive(sw, temp);

        int[] se = getPoint(row + 1, col + 1);
        sum += isAlive(se, temp);

        int[] w = getPoint(row, col - 1);
        sum += isAlive(w, temp);

        int[] e = getPoint(row, col + 1);
        sum += isAlive(e, temp);

        if (!isAliveBefore) {
            return sum == 3;

        } else {
            if (sum < 2) return false;
            return sum <= 3;

        }
    }

    private int isAlive(int[] n, int[][] temp) {
        if (!isInBounds(n, temp)) return 0;
        return (temp[n[0]][n[1]] == 1) ? 1 : 0;
    }


    private int[][] clone(int[][] grid) {
        int[][] temp = new int[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                temp[row][col] = grid[row][col];
            }
        }
        return temp;
    }

    private int[] getPoint(int x, int y) {
        return new int[]{x, y};
    }

    private static boolean isInBounds(int[] point, int[][] board) {
        int x = point[0];
        int y = point[1];
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

}
