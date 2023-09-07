package Assessment1;

import Assessment1.models.ExtraMovement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Assessment1
{
    private final List<ExtraMovement> extraMovements = new ArrayList<>();

    ExtraMovement mov1 = new ExtraMovement(3, 11);
    ExtraMovement mov2 = new ExtraMovement(9, 18);
    ExtraMovement mov3 = new ExtraMovement(10, 12);
    ExtraMovement mov4 = new ExtraMovement(6, 17);
    ExtraMovement mov5 = new ExtraMovement(14, 4);
    ExtraMovement mov6 = new ExtraMovement(19, 8);
    ExtraMovement mov7 = new ExtraMovement(22, 20);
    ExtraMovement mov8 = new ExtraMovement(24, 16);


    public Assessment1(){}

    public String setupPlay()
    {
        String finalMessage = "";
        String[][] board = new String[5][5];

        populateExtraMovements();

        int position = 1;
        final String[][] tempBoard = reprintBoard(position, board);
        if (tempBoard == null)
        {
            return "Invalid Board Provided";
        }

        while(position < 25)
        {
            int diceRoll = rollDice();
            System.out.println("Dice Roll: " + diceRoll);
            position += diceRoll;

            int newPosition = checkForSnakeOrLadder(position, extraMovements);
            if (newPosition > position)
            {
                System.out.println("Yay!! You've climbed a ladder");
            }
            else if (newPosition < position)
            {
                System.out.println("Boo!! You're sliding down a snake");
            }
            position = newPosition;

            if (newPosition >= 25)
            {
                finalMessage = "Invalid Board Provided";
                System.out.println("Congratulations, You've won");
                break;
            }

            board = reprintBoard(newPosition, board);
            if (board == null)
            {
                finalMessage = "Invalid Board Provided";
                break;
            }
        }
        return finalMessage;
    }

    public void populateExtraMovements()
    {
        extraMovements.add(mov1);
        extraMovements.add(mov2);
        extraMovements.add(mov3);
        extraMovements.add(mov4);
        extraMovements.add(mov5);
        extraMovements.add(mov6);
        extraMovements.add(mov7);
        extraMovements.add(mov8);
    }

    public int rollDice()
    {
        final Random rand = new Random();
        final int lowerBound = 1;
        final int upperBound = 6;
        return rand.nextInt((upperBound - lowerBound) + 1) + lowerBound;
    }

    public int checkForSnakeOrLadder(final int position, final List<ExtraMovement> snakesAndLadders)
    {
        if (snakesAndLadders == null || snakesAndLadders.isEmpty())
        {
            return position;
        }

        final List<ExtraMovement> movementList = snakesAndLadders.stream().filter(x -> x.getStart() == position).collect(Collectors.toList());
        if (movementList.size() > 0)
        {
            return movementList.get(0).getEnd();
        }
        return position;
    }

    public void printBoard(final String[][] matrix)
    {
        for (final String[] row : matrix)
        {
            // traverses through number of rows
            for (final String element : row)
            {
                // 'element' has current element of row index
                System.out.print( element  + "\t");
            }
            System.out.println();
        }

        System.out.println();
    }

    public int getRow(final int position)
    {
        if (position < 1)
            return -1;

        int row = 4 - ((position - 1) / 5);
        return (row);
    }

    public int getColumn(final int position, final int row)
    {
        if (position < 1 || row < 0)
        {
            return -1;
        }

        int col = (position - 1) % 5;
        if (row % 2 == 1)
        {
            col = 4 - col;
        }
        return col;
    }

    public String[][] reprintBoard(final int position, final String[][] board)
    {
        final int row = getRow(position);
        if (row < 0)
        {
            return null;
        }

        final int col = getColumn(position, row);
        if (col < 0)
        {
            return null;
        }

        if (board == null || row + 1 > board.length || col + 1 > board[0].length)
        {
            return null;
        }

        for (int i = 0; i < board.length; i ++)
        {
            for (int j = 0; j < board.length; j++)
            {
                board[i][j] = "0";
            }
        }
        board[row][col] = "X";

        printBoard(board);
        return board;
    }
}
