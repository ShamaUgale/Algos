package com.shama.datastructures.graphs.dfs;

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
