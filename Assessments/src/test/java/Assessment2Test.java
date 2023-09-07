import Assessment2.Assessment2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Assessment2Test
{

    Assessment2 assessment2;

    @BeforeEach
    void setup()
    {
        assessment2 = new Assessment2();
    }

    @ParameterizedTest
    @CsvSource({"5,5,1 2 3 4 5 10 15 20 25 24 23 22 21 16 11 6 7 8 9 14 19 18 17 12 13",
            "5,4,1 2 3 4 5 10 15 20 19 18 17 16 11 6 7 8 9 14 13 12",
            "2,4,1 2 4 6 8 7 5 3"})
    void testSpiralSuccess(final int columns, final int rows, String expectedResult)
    {
        final int[][] getMatrix = assessment2.getMatrix(rows,columns);
        final String spiral = assessment2.printSpiral(rows,columns, getMatrix);
        assertEquals(expectedResult, spiral);
    }

    @Test
    void testSpiralErrorWithInvalidRow()
    {
        final String expected = "Invalid row and column provided";
        final String spiral = assessment2.printSpiral(0, 5, assessment2.getMatrix(5,5));
        assertEquals(spiral, expected);
    }

    @Test
    void testSpiralErrorWithInvalidColumn()
    {
        final String expected = "Invalid row and column provided";
        final String spiral = assessment2.printSpiral(5, 0, assessment2.getMatrix(5,5));
        assertEquals(spiral, expected);
    }

    @Test
    void testInvalidMatrixProvided()
    {
        final String expected = "Invalid board provided";
        final String spiral = assessment2.printSpiral(5, 5, new int[0][0]);
        assertEquals(spiral, expected);
    }

}
