package com.shama.algorithms.dynamicProgramming;

public class Knapsack_0_1 {

    // core knapsack 0/1
    private static int findMaxValue(int[] values, int[] weights, int W) {
        int[][] KP = new int[W + 1][values.length + 1];

        for (int i = 1; i <= W; i++) {
            for (int j = 1; j <= values.length; j++) {
                if (i - weights[j - 1] >= 0) {
                    KP[i][j] = Math.max(KP[i - weights[j - 1]][j - 1] + values[j - 1], KP[i][j - 1]);
                } else {
                    KP[i][j] = KP[i][j - 1];
                }
            }
        }

        return KP[W][values.length];
    }

    static boolean equalSumPartion(int[] arr, int n){
        int sum =0;
        for(int i=0; i<arr.length; i++){
            sum = sum + arr[i];
        }
        if(sum%2 !=0){
            return false;
        }
        else return isSubsetSum(arr, n, sum/2);
    }

    static boolean isSubsetSum(int arr[], int n, int sum) {
        // The value of subset[i][j] will be
        // true if there is a subset of
        // set[0..j-1] with sum equal to i
        boolean dp[][] = new boolean[n+1][sum + 1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    dp[i][j] = false;
                }

                if (j == 0) {
                    dp[i][j] = true;
                }
            }
        }

        // Fill the subset table in bottom
        // up manner
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        /* // uncomment this code to print table
        for (int i = 0; i <= sum; i++)
        {
        for (int j = 0; j <= n; j++)
            System.out.println (subset[i][j]);
        } */

        return dp[n][sum];
    }

    static int countNoOfSubsetSumForGivenSum(int arr[], int n, int sum) {
        // The value of subset[i][j] will be
        // true if there is a subset of
        // set[0..j-1] with sum equal to i
        int dp[][] = new int[n+1][sum + 1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                }

                if (j == 0) {
                    dp[i][j] = 1;
                }
            }
        }

        // Fill the subset table in bottom
        // up manner
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j - arr[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        /* // uncomment this code to print table
        for (int i = 0; i <= sum; i++)
        {
        for (int j = 0; j <= n; j++)
            System.out.println (subset[i][j]);
        } */

        return dp[n][sum];
    }


    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};

        int w = 50;

        System.out.printf("Max value of Knapsack = %d%n", findMaxValue(values, weights, w));

        // **********************************************************************************************************************************************

        int set[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        int n = set.length;
        if (isSubsetSum(set, n, sum) == true)
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");

        // **********************************************************************************************************************************************

        int arr[] = { 3, 1, 5, 9, 12, 1 };
        n = arr.length;

        // Function call
        if (equalSumPartion(arr, n) == true)
            System.out.println("Can be divided into two "
                    + "subsets of equal sum");
        else
            System.out.println(
                    "Can not be divided into "
                            + "two subsets of equal sum");

        // **********************************************************************************************************************************************

        int[] arr1 = {1, 2, 3, 3};
        sum = 6;

        System.out.println("No of subsets with given count are : " + countNoOfSubsetSumForGivenSum(arr1, arr1.length, sum));

        // **********************************************************************************************************************************************



    }
}

