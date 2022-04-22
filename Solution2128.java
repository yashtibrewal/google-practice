public class Solution2128 {

    public boolean isCol(int[][] grid, int y, int num) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][y] == num)
                return false;
        }
        return true;
    }


    public boolean isRow(int[][] grid, int x, int num) {
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[x][i] == num)
                return false;
        }
        return true;
    }

    public boolean removeOnes(int[][] grid) {
        // base case
        if (grid.length == 1 && grid[0].length == 1)
            return true;
        boolean isZero = true;
        boolean isOne = true;
        // case for self 0 and other row or coloumns 1
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(!isCol(grid, j, 0))isZero = false;
                if(!isCol(grid, j, 1))isOne = false;
            }
            if(!isRow(grid, i, 0))isZero = false;
            if(!isRow(grid, i, 1))isOne = false;
        }
        return isZero || isOne;
    }

}
