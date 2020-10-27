public class InitGame {

    private static GameOfLife gol;

    public static void main(String[] args) {
        InitGame initGame = new InitGame();
        gol = new GameOfLife();
        Grid future = new Grid(5);
        Grid grid = initGame.createGrid();
        PrintGrid.printGameBoard(grid);

        while(initGame.gridsAreDifferent(grid, future)){
            future = gol.nextGen(grid);
            PrintGrid.printGameBoard(future);
            if (initGame.gridsAreDifferent(grid, future)) {
                grid = future;
                future = new Grid(5);
            }
        }
    }

    private Grid createGrid() {
        int[][] temp = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };
        return new Grid(temp);
    }


    private boolean gridsAreDifferent(Grid grid, Grid futureGrid) {
        return !grid.compareGrids(futureGrid);
    }


}
