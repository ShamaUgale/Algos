package com.shama.datastructures.graphs.dfs;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid == null) {
            return 0;
        }
        // Number of rows & columns in a grid
        int numberOfRows = grid.length;
        int numberOfColumns = grid[0].length;

        // Initial number of islands
        int num_islands = 0;

        // DFS
        for (int r = 0; r < numberOfRows; r++) {
            for (int c = 0; c < numberOfColumns; c++) {
                if (grid[r][c] == '1') {
                    num_islands++;
                    dfs(grid, r, c, numberOfRows, numberOfColumns);
                }
            }
        }
        return num_islands;
    }

    private void dfs(char[][] grid, int r, int c, int numberOfRows,int numberOfColumns) {
        if (r < 0 || c < 0 || r >= numberOfRows || c >= numberOfColumns || grid[r][c] == '0') {
            return;
        }

        // Mark current node as visited
        grid[r][c] = '0';

        dfs(grid, r - 1, c,numberOfRows,numberOfColumns );
        dfs(grid, r + 1, c,numberOfRows,numberOfColumns);
        dfs(grid, r, c - 1,numberOfRows,numberOfColumns);
        dfs(grid, r, c + 1,numberOfRows,numberOfColumns);
    }
}
