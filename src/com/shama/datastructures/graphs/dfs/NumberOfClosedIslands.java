package com.shama.datastructures.graphs.dfs;

/*

A closed island is known as the group of 1s that is surrounded by only 0s on all the four sides (excluding diagonals).
If any 1 is at the edges of the given matrix then it is not considered as the part of the connected island
as it is not surrounded by all 0.

Input: N = 5, M = 8,
mat[][] =
{
    {0, 0, 0, 0, 0, 0, 0, 1},
    {0, 1, 1, 1, 1, 0, 0, 1},
    {0, 1, 0, 1, 0, 0, 0, 1},
    {0, 1, 1, 1, 1, 0, 1, 0},
    {0, 0, 0, 0, 0, 0, 0, 1}
}

Output: 2

 */
public class NumberOfClosedIslands {
    public int noOfClosedIslands(int[][] grid) {
        if (grid.length == 0 || grid == null) {
            return 0;
        }
        // Number of rows & columns in a grid
        int numberOfRows = grid.length;
        int numberOfColumns = grid[0].length;

        // Initial number of islands
        int noOfClosedIslands = 0;

        // DFS
        for (int r = 0; r < numberOfRows; r++) {
            for (int c = 0; c < numberOfColumns; c++) {
                if (grid[r][c] == 1) {
                    if(isClosedIsland(grid,r,c,numberOfRows,numberOfColumns)) {
                        noOfClosedIslands++;
                    }
                }
            }
        }
        return noOfClosedIslands;
    }

    private boolean isClosedIsland(int[][] grid, int r, int c, int numberOfRows, int numberOfColumns) {

        if(grid[r][c] == -1 || grid[r][c] == 0){
            return true;
        }
        if (r == 0 || c == 0 || r == numberOfRows-1 || c == numberOfColumns-1) {
            return false;
        }
        grid[r][c] = -1;

        boolean up = isClosedIsland(grid, r - 1, c,numberOfRows,numberOfColumns );
        boolean down = isClosedIsland(grid, r + 1, c,numberOfRows,numberOfColumns);
        boolean left = isClosedIsland(grid, r, c - 1,numberOfRows,numberOfColumns);
        boolean right = isClosedIsland(grid, r, c + 1,numberOfRows,numberOfColumns);

        return left && right && up && down;
    }


}
