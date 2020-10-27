public class GameOfLife {


    public Grid nextGen(Grid grid) {

        Grid futureGrid = new Grid(grid.grid.length);

        // Loop through every cell
        for (int l = 1; l < grid.grid.length - 1; l++) {
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
                final int ALIVE = 1;
                final int DEAD = 0;
                boolean isAlive = (grid.grid[l][m] == 1);
                boolean cellLivesNextGen = shouldFutureCellBeAlive(isAlive, aliveNeighbours);
                if (cellLivesNextGen)
                    futureGrid.grid[l][m] = ALIVE;
                else
                    futureGrid.grid[l][m] = DEAD;
            }
        }
        return futureGrid;
    }


    public boolean shouldFutureCellBeAlive(boolean isAlive, int aliveNeighbors) {
        if (isAlive == true)
            return willLivingCellSurvive(aliveNeighbors);
        return isCellBorn(aliveNeighbors);
    }

    private boolean willLivingCellSurvive(int aliveNeighbors) {
        if (aliveNeighbors == 2 || aliveNeighbors == 3)
            return true;
        return false;
    }

    private boolean isCellBorn(int aliveNeighbors) {
        if (aliveNeighbors == 3)
            return true;
        return false;
    }

}
