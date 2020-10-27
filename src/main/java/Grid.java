import java.util.Arrays;

class Grid {

    final int[][] grid;

    Grid(int[][] grid) {
        this.grid = grid;
    }

    Grid(int size) {
        this.grid = new int[size][size];
    }


    boolean compareGrids(Grid gridToCompareTo) {
        return Arrays.deepEquals(grid, gridToCompareTo.grid);
    }
}
