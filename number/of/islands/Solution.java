package number.of.islands;

import java.util.HashMap;
import java.util.HashSet;

class Solution {

    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            try {
                if (obj == null)
                    return false;
                if (this.getClass() != obj.getClass())
                    return false;
                Point point = (Point) obj;
                if (this.x == point.x && this.y == point.y)
                    return true;
            } catch (Exception e) {
                return false;
            }
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 31 * hash + x;
            hash = 31 * hash + y;
            return hash;
        }
    }

    Solution() {
        island = new HashMap<>();
        islandNumber = 0;
        traversalHistory = new HashSet<>();
    }

    HashMap<Integer, HashSet<Point>> island;
    HashSet<Point> traversalHistory;
    char[][] myGrid;
    int rows, cols, islandNumber;

    /**
     * To traverse the island in all 4 directions and add it to the HashMap
     */
    public void chainReaction(int x, int y, int islandNumber) {
        
        if(isVisitedBefore(x, y))return;
        traversalHistory.add(new Point(x, y));

        // travel guard insurance
        if (x < 0 || x >= rows || y < 0 || y >= cols)
            return;
        if (myGrid[x][y] == '1') {
            island.get(islandNumber).add(new Point(x, y));
        } else {
            return;
        }
        chainReaction(x + 1, y, islandNumber);
        chainReaction(x, y + 1, islandNumber);
        chainReaction(x - 1, y, islandNumber);
        chainReaction(x, y - 1, islandNumber);
    }

    /**
     * To see if the Point is present in the discovered islands
     * 
     * @param x
     * @param y
     * @return
     */
    public boolean isVisitedBefore(int x, int y) {
        return traversalHistory.contains(new Point(x, y));
    }

    /**
     * main solution, do not delete
     * 
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {

        rows = grid.length;
        cols = grid[0].length;
        myGrid = grid;

        // repeat the process
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // look for a 1 not in islands hashset
                if (grid[i][j] == '1' && !isVisitedBefore(i, j)) {
                    // increment the counter
                    islandNumber++;
                    island.put(islandNumber, new HashSet<>());
                    // use chain reaction to find the full island
                    chainReaction(i, j, islandNumber);
                }
            }
        }

        return islandNumber;
    }

}