import java.util.Arrays;

public class Grid {

    public final int[][] grid;

    public Grid(int[][] grid) {
        this.grid = grid;
    }


    public boolean compareGrids(Grid futureGrid) {
        return Arrays.deepEquals(grid, futureGrid.grid);

    }
}
