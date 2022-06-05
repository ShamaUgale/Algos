package com.shama.datastructures.graphs.dfs;

public class MaxAreaIsland {

    public int maxArea(int[][] grid) {
        if (grid.length == 0 || grid == null) {
            return 0;
        }
        // Number of rows & columns in a grid
        int numberOfRows = grid.length;
        int numberOfColumns = grid[0].length;

        // Initial number of islands
        int maxArea = Integer.MIN_VALUE;

        // DFS
        for (int r = 0; r < numberOfRows; r++) {
            for (int c = 0; c < numberOfColumns; c++) {
                if (grid[r][c] == 1) {
                    int area = getArea(grid, r, c, numberOfRows, numberOfColumns);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int getArea(int[][] grid, int r, int c, int numberOfRows, int numberOfColumns) {
        if (r < 0 || c < 0 || r >= numberOfRows || c >= numberOfColumns || grid[r][c] == '0') {
            return 0;
        }
        grid[r][c] = '0';

        int up = getArea(grid, r - 1, c,numberOfRows,numberOfColumns );
        int down = getArea(grid, r + 1, c,numberOfRows,numberOfColumns);
        int left = getArea(grid, r, c - 1,numberOfRows,numberOfColumns);
        int right = getArea(grid, r, c + 1,numberOfRows,numberOfColumns);

        return left + right + up + down + 1;
    }


}
