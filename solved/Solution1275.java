package solved;
public class Solution1275 {

    public int sumOfRow(int[][] grid, int row) {
        return grid[row][0] + grid[row][1] + grid[row][2];
    }

    public int sumOfColumn(int[][] grid, int col) {
        return grid[0][col] + grid[1][col] + grid[2][col];
    }

    public int leftDiagonal(int[][] grid) {
        return grid[0][0] + grid[1][1] + grid[2][2];
    }

    public int rightDiagonal(int[][] grid) {
        return grid[2][0] + grid[1][1] + grid[0][2];
    }

    public String tictactoe(int[][] moves) {
        int[][] gameGrid = new int[3][3];
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0)
                gameGrid[moves[i][0]][moves[i][1]] = 1;
            else
                gameGrid[moves[i][0]][moves[i][1]] = -1;
        }
        // if any of the diagonals or col or row is sum 3, return A
        if (sumOfRow(gameGrid,0) == 3 || sumOfRow(gameGrid,1) == 3 || sumOfRow(gameGrid,2) == 3) {
            return "A";
        }
        if (sumOfColumn(gameGrid, 0) == 3 || sumOfColumn(gameGrid, 1) == 3 || sumOfColumn(gameGrid, 2) == 3) {
            return "A";
        }
        if (leftDiagonal(gameGrid) == 3)
            return "A";
        if (rightDiagonal(gameGrid) == 3)
            return "A";
        
        // if same as above is -3 return B
        if (sumOfRow(gameGrid,0) == -3 || sumOfRow(gameGrid,1) == -3 || sumOfRow(gameGrid,2) == -3) {
            return "B";
        }
        if (sumOfColumn(gameGrid, 0) == -3 || sumOfColumn(gameGrid, 1) == -3 || sumOfColumn(gameGrid, 2) == -3) {
            return "B";
        }
        if (leftDiagonal(gameGrid) == -3)
            return "B";
        if (rightDiagonal(gameGrid) == -3)
            return "B";

        if(moves.length == 9) return "DRAW";

        return "PENDING";
    }
}
