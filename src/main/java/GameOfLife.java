public class GameOfLife {



    public Grid nextGen(Grid grid) {

        Grid futureGrid = new Grid(grid.grid.length);

        // Loop through every cell
        for (int l = 1; l < grid.grid.length -1; l++) {
            for (int m = 1; m < grid.grid.length - 1; m++) {
                // finding no Of Neighbours that are alive
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours += grid.grid[l + i][m + j];

                // The cell needs to be subtracted from
                // its neighbours as it was counted before
                aliveNeighbours -= grid.grid[l][m];

                // Implementing the Rules of Life

                // Cell is lonely and dies
                if ((grid.grid[l][m] == 1) && (aliveNeighbours < 2))
                    futureGrid.grid[l][m] = 0;

                    // Cell dies due to over population
                else if ((grid.grid[l][m] == 1) && (aliveNeighbours > 3))
                    futureGrid.grid[l][m] = 0;

                    // A new cell is born
                else if ((grid.grid[l][m] == 0) && (aliveNeighbours == 3))
                    futureGrid.grid[l][m] = 1;

                    // Remains the same
                else
                    futureGrid.grid[l][m] = grid.grid[l][m];
            }
        }
        return futureGrid;
    }
}
