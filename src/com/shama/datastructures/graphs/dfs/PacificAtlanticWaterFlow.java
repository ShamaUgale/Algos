package com.shama.datastructures.graphs.dfs;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public ArrayList<ArrayList<Integer>> pacificAtlantic(int[][] grid){
        int no_of_rows = grid.length;
        int no_of_cols = grid[0].length;

        int[][] pacific = new int[no_of_rows][no_of_cols];
        int[][] atlantic = new int[no_of_rows][no_of_cols];

        // top and bottom
        for(int col=0; col < no_of_cols ; col++){
            dfs(grid, 0, col, Integer.MIN_VALUE, pacific); // first row
            dfs(grid, no_of_rows-1, col, Integer.MIN_VALUE, atlantic); // last row
        }

        // right and left
        for(int row=0; row < no_of_cols ; row++){
            dfs(grid, row, 0, Integer.MIN_VALUE, pacific); // first column (left)
            dfs(grid, row, no_of_cols-1, Integer.MIN_VALUE, atlantic); // last column(right)
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i< no_of_rows; i++){
            for(int j=0; j< no_of_cols; j++){
                if(pacific[i][j] == 1 && atlantic[i][j] == 1){
                    ArrayList<Integer> sol = new ArrayList<>();
                    sol.add(i);
                    sol.add(j);
                    result.add(sol);
                }
            }
        }
        return result;
    }

    private void dfs(int[][] grid, int row, int col, int prevValue, int[][] ocean){
        if(row < 0 || row > grid.length ||
                col < 0 || col > grid[0].length ||
                ocean[row][col] == 1 ||
                ocean[row][col] < prevValue ){
            return;
        }

        ocean[row][col] = 1;
        dfs(grid, row-1, col, grid[row][col], ocean);
        dfs(grid, row+1, col, grid[row][col], ocean);
        dfs(grid, row, col-1, grid[row][col], ocean);
        dfs(grid, row, col+1, grid[row][col], ocean);
    }
}
