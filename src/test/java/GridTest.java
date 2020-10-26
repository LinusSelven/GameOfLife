import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


public class GridTest {

    Grid grid;

    @BeforeEach
    void setup() {
        int[][] tempGrid = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        grid = new Grid(tempGrid);
    }

    @Test
    void checkThatGridCreatedHasTheSameValuesAsTheOneWeSentIn() {
        int[][] tempGrid = new int[][]{
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
        grid = new Grid(tempGrid);

        assertThat(Arrays.deepEquals(grid.grid, tempGrid)).isTrue();
    }

    @Test
    void gridShouldOnlyContainTwoDifferentNumbers(){
        IntStream stream = Arrays.stream(grid.grid).flatMapToInt(Arrays::stream);
        assertEquals(2, stream.distinct().count());
    }

    @Test
    void gridOnlyContainsZerosAndOnes() {
        IntStream stream = Arrays.stream(grid.grid).flatMapToInt(x -> Arrays.stream(x));
        var countOfNumbersNotEqualToOneOrTwo = stream.filter(n -> n <= -1 || n >= 2).count();

        assertThat(countOfNumbersNotEqualToOneOrTwo).isEqualTo(0);
    }

    @Test
    void checkIfIncomingGridIsTheSameAsCurrentAndReturnTrue(){
        int[][] testGrid = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        Grid futureGrid = new Grid(testGrid);

        assertThat(grid.compareGrids(futureGrid)).isTrue();
    }
}

