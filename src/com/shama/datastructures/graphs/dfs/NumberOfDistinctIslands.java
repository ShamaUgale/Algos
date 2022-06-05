package com.shama.datastructures.graphs.dfs;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
    public int noOfDistinctIslands(int[][] grid) {
        if (grid.length == 0 || grid == null) {
            return 0;
        }
        // Number of rows & columns in a grid
        int numberOfRows = grid.length;
        int numberOfColumns = grid[0].length;

        // Initial number of islands
        Set<String> set = new HashSet();

        // DFS
        for (int r = 0; r < numberOfRows; r++) {
            for (int c = 0; c < numberOfColumns; c++) {
                if (grid[r][c] == 1) {
                    String path = computePath(grid, r, c, numberOfRows, numberOfColumns, "X");
                    set.add(path);
                }
            }
        }
        return set.size();
    }

    private String computePath(int[][] grid, int r, int c, int numberOfRows, int numberOfColumns, String direction) {
        if (r < 0 || c < 0 || r >= numberOfRows || c >= numberOfColumns || grid[r][c] == '0') {
            return "O";
        }
        grid[r][c] = '0';

        String up = computePath(grid, r - 1, c,numberOfRows,numberOfColumns,"U" );
        String down = computePath(grid, r + 1, c,numberOfRows,numberOfColumns, "D");
        String left = computePath(grid, r, c - 1,numberOfRows,numberOfColumns, "L");
        String right = computePath(grid, r, c + 1,numberOfRows,numberOfColumns, "R");

        return direction + left + right + up + down;
    }

}
