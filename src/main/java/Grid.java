import java.util.Arrays;

public class Grid {

    public final int[][] grid;

    public Grid(int[][] grid) {
        this.grid = grid;
    }

    public Grid(int size) {
        this.grid = new int[size][size];
    }


    public boolean compareGrids(Grid futureGrid) {
        return Arrays.deepEquals(grid, futureGrid.grid);
    }
}
