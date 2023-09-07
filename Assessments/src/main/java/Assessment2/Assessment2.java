package Assessment2;

// Seed for math Random.


public class Assessment2
{
    public Assessment2() {}

    public int[][] getMatrix(final int rows, final int columns)
    {
        int[][] matrix = new int[rows][columns];
        int counter = 1;
        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < columns; col++)
            {
                matrix[row][col] = counter;
                counter++;
            }
        }

        return matrix;
    }

    public String printSpiral(int rows, int columns, int[][] matrix)
    {
        if (rows <= 0 || columns <= 0)
        {
            return "Invalid row or column provided";
        }
        else if (matrix.length == 0 || matrix[0].length == 0)
        {
            return "Invalid board provided";
        }

        int spiralSize = 0;
        int offset = 0;
        String spiral = "";

        while(spiralSize < rows * columns)
        {
            // Go right
            for (int col = offset; col < columns - offset; col ++)
            {
                if (spiralSize == (rows*columns))
                    break;

                if (col == 0)
                {
                    spiral = spiral + "" + matrix[offset][col];
                }
                else {
                    spiral = spiral + " " + matrix[offset][col];
                }

                spiralSize++;
            }


            // Go down
            for (int row = 1 + offset; row < rows - 1 - offset; row ++)
            {
                if (spiralSize == (rows*columns))
                    break;

                spiral = spiral + " " + matrix[row][(columns - 1) - offset];
                spiralSize++;
            }

            // Go Left
            for (int col = columns - 1 - offset; col >= offset; col --)
            {
                if (spiralSize == (rows*columns))
                    break;

                spiral = spiral + " " + matrix[(rows - 1) - offset][(col)];
                spiralSize++;
            }

            // Go Up
            for (int row = rows-2-offset; row >= 1 + offset; row--)
            {
                if (spiralSize == (rows*columns))
                    break;

                spiral = spiral + " " + matrix[row][offset];
                spiralSize++;
            }

            offset++;
        }

        return spiral;
    }


}
