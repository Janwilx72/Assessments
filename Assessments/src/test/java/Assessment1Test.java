import Assessment1.Assessment1;
import Assessment1.models.ExtraMovement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Assessment1Test
{
    private Assessment1 assessment1;

    @BeforeEach
    void setup()
    {
        assessment1 = new Assessment1();
    }

//    @Test
    void runProgram()
    {
        assessment1.setupPlay();
    }

    @Test
    void test_getColumn_withInvalidRow()
    {
        int col = assessment1.getColumn(1,-1);
        assertEquals(col, -1);
    }
    @Test
    void test_getColumn_withInvalidPosition()
    {
        int col = assessment1.getColumn(0,1);
        assertEquals(col, -1);
    }

    @Test
    void test_getRow_WithInvalidPosition()
    {
        int col = assessment1.getRow(0);
        assertEquals(col, -1);
    }

    @Test
    void test_getRow_WithValidPosition()
    {
        int col = assessment1.getRow(1);
        assertEquals(col, 4);
    }

    @Test
    void test_reprintBoard_With_Invalid_Position_Based_on_Row_and_Column()
    {
        String[][] board = assessment1.reprintBoard(5, new String[0][0]);
        assertNull(board);
    }

    @Test
    void test_reprintBoard_With_Position_Less_Than_One()
    {
        String[][] board = assessment1.reprintBoard(0, new String[5][5]);
        assertNull(board);
    }

    @Test
    void test_validBoardReturned()
    {
        String[][] board = assessment1.reprintBoard(1, new String[5][5]);
        assertEquals(board[4][0], "X");
    }

    @RepeatedTest(5)
    void test_diceRollWithinRange()
    {
        int diceRoll = assessment1.rollDice();
        assert diceRoll >= 1 && diceRoll <= 6;
    }

    @Test
    void test_checkForSnakeAndLadderWithEmptyList_findsNone()
    {
        List<ExtraMovement> movements = new ArrayList<>();
        int position = 5;

        int positionAfterCheck = assessment1.checkForSnakeOrLadder(position, movements);
        assertEquals(positionAfterCheck, position);
    }

    @Test
    void test_checkForSnakeAndLadder_findsNone()
    {
        List<ExtraMovement> movements = new ArrayList<>();
        ExtraMovement movement = new ExtraMovement(9, 5);
        movements.add(movement);

        int position = 5;

        int positionAfterCheck = assessment1.checkForSnakeOrLadder(position, movements);
        assertEquals(positionAfterCheck, position);
    }

    @Test
    void test_checkForSnakeAndLadder_ChangePosition()
    {
        int endPosition = 2;

        List<ExtraMovement> movements = new ArrayList<>();
        ExtraMovement movement = new ExtraMovement(5, endPosition);
        movements.add(movement);

        int position = 5;

        int positionAfterCheck = assessment1.checkForSnakeOrLadder(position, movements);
        assertEquals(positionAfterCheck, endPosition);
    }


}
