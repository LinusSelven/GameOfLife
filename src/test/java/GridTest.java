import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


public class GridTest {

    Grid expectedGrid;

    @BeforeEach
    void setup() {
        expectedGrid = new Grid();
    }

    @Test
    void checkThatGridCreatedHasTheSameValuesAsTheOneWeSentIn() {
        int[][] tempArray = new int[][]{
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        expectedGrid = new Grid(tempArray);

        assertThat(Arrays.deepEquals(expectedGrid.grid, tempArray)).isTrue();
    }


    @Test
    void gridShouldOnlyContainTwoDifferentNumbers(){
        IntStream stream = Arrays.stream(expectedGrid.grid).flatMapToInt(Arrays::stream);
        assertEquals(2, stream.distinct().count());
    }

    @Test
    void gridOnlyContainsZerosAndOnes() {
        IntStream stream = Arrays.stream(expectedGrid.grid).flatMapToInt(x -> Arrays.stream(x));
        var countOfNumbersNotEqualToOneOrTwo = stream.filter(n -> n <= -1 || n >= 2).count();

        assertThat(countOfNumbersNotEqualToOneOrTwo).isEqualTo(0);
    }

    @Test
    void checkIfIncomingGridIsTheSameAsCurrentAndReturnTrue(){
        int[][] tempArray = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        Grid futureGrid = new Grid(tempArray);

        assertThat(expectedGrid.compareGrids(futureGrid)).isTrue();
    }

    @Test
    void checkIfAllCellsAreDeadAndReturnTrue() {
        int[][] tempArray = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        Grid gameOverGrid = new Grid(tempArray);

        var sum = Arrays.stream(gameOverGrid.grid).flatMapToInt(Arrays::stream).sum();
        assertThat(sum).isEqualTo(0);
    }

    @Test
    void checkThatTwoIncomingGridsAreDifferentAndReturnFalse() {
        int[][] firstArray = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        int[][] secondArray = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
        };
        Grid grid = new Grid(firstArray);
        Grid secondGrid = new Grid(secondArray);
        assertThat(grid.compareGrids(secondGrid)).isFalse();
    }
}

