package com.shama.datastructures.graphs.dfs;

public class PathForMaxGold {

    public int maxArea(int[][] grid) {
        if (grid.length == 0 || grid == null) {
            return 0;
        }
        // Number of rows & columns in a grid
        int numberOfRows = grid.length;
        int numberOfColumns = grid[0].length;

        // Initial number of islands
        int maxGold = Integer.MIN_VALUE;

        // DFS
        for (int r = 0; r < numberOfRows; r++) {
            for (int c = 0; c < numberOfColumns; c++) {
                if (grid[r][c] > 0) {
                    int gold = getGoldPath(grid, r, c, numberOfRows, numberOfColumns, new boolean[numberOfRows][numberOfColumns]);
                    maxGold = Math.max(gold, maxGold);
                }
            }
        }
        return maxGold;
    }

    private int getGoldPath(int[][] grid, int r, int c, int numberOfRows, int numberOfColumns, boolean[][] visited) {
        if (r < 0 || c < 0 || r >= numberOfRows || c >= numberOfColumns || grid[r][c] == '0') {
            return 0;
        }
        visited[r][c] = true;

        int up = getGoldPath(grid, r - 1, c,numberOfRows,numberOfColumns, visited );
        int down = getGoldPath(grid, r + 1, c,numberOfRows,numberOfColumns, visited);
        int left = getGoldPath(grid, r, c - 1,numberOfRows,numberOfColumns, visited);
        int right = getGoldPath(grid, r, c + 1,numberOfRows,numberOfColumns, visited);
        visited[r][c] = false;

        return Math.max(left, Math.max(right, Math.max(up, down))) + grid[r][c];
    }

}
