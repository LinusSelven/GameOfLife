public class GameOfLife {


    public Grid nextGen(Grid grid) {
        Grid futureGrid = new Grid(grid.grid.length);
        for (int row = 1; row < grid.grid.length - 1; row++)
            for (int column = 1; column < grid.grid.length - 1; column++) {
                int aliveNeighbours = getAliveNeighbours(grid, row, column);
                var currentCell = grid.grid[row][column];
                aliveNeighbours -= currentCell;
                setFutureCell(futureGrid, currentCell, row, column, aliveNeighbours);
            }
        return futureGrid;
    }

    private int getAliveNeighbours(Grid grid, int row, int column) {
        int aliveNeighbours = 0;
        for (int i = -1; i <= 1; i++)
            for (int j = -1; j <= 1; j++)
                aliveNeighbours += grid.grid[row + i][column + j];
        return aliveNeighbours;
    }

    private void setFutureCell(Grid futureGrid, int currentCell, int row, int column, int aliveNeighbours) {
        final byte ALIVE = 1;
        final byte DEAD = 0;
        boolean isCellAlive = (currentCell == 1);
        boolean cellLivesNextGen = isCellAliveNextGen(isCellAlive, aliveNeighbours);
        if (cellLivesNextGen)
            futureGrid.grid[row][column] = ALIVE;
        else
            futureGrid.grid[row][column] = DEAD;
    }


    public boolean isCellAliveNextGen(boolean isAlive, int aliveNeighbors) {
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
