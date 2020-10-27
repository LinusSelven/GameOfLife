public class PrintGrid {
    public static void printGameBoard(Grid grid) {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        for (int column = 0; column < grid.grid.length; column++) {
            for (int row = 0; row < grid.grid.length; row++) {
                if (grid.grid[column][row] == 0)
                    System.out.print(". ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
