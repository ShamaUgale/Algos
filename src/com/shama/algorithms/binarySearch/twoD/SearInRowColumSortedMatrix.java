package com.shama.algorithms.binarySearch.twoD;

public class SearInRowColumSortedMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };

        int key = 23;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int i =0;
        int j = cols-1;

        while(i>=0 && i<rows && j>=0 && j<cols){
            if(matrix[i][j] == key){
                System.out.println("Key found at : " + i + " " + j);
                return;
            }else if(matrix[i][j] > key){
                j--;
            }else{
                i++;
            }
        }
        System.out.println("Key is not preset in th matrix");
    }
}