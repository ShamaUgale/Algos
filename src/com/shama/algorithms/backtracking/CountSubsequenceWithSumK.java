package com.shama.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CountSubsequenceWithSumK {
    public static void subsequenceSum(int[] nums, int k) {
       int count = subsequenceSum(nums, k, 0, 0);
        System.out.println("No of subsequences with sum "+ k + " is : " + count);
    }

    private static int subsequenceSum(int[] nums, int k, int index, int sum) {
        if (index == nums.length) {
            if (sum == k) {
                return 1;
            }
            return 0;
        }

        int left = subsequenceSum(nums, k, index+1, sum + nums[index]);
        int right = subsequenceSum(nums, k, index+1, sum);

        return left + right;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1};
        subsequenceSum(arr, 2);
    }
}
