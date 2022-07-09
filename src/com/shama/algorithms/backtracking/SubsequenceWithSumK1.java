package com.shama.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;
/*

this is a follow-up question to the print all subsequences with sum k
print any 1 subsequence with sum k
*/

public class SubsequenceWithSumK1 {
    public static void subsequenceSum(int[] nums, int k) {
        subsequenceSum(nums, k, 0, new ArrayList<>(), 0);
    }

    private static boolean subsequenceSum(int[] nums, int k, int index, List<Integer> subsequence, int sum) {
        if (index == nums.length) {
            if (sum == k) {
                System.out.println(subsequence);
                return true;
            }
                return false;
        }

        subsequence.add(nums[index]);
        if(subsequenceSum(nums, k, index+1, subsequence, sum + nums[index])){
            return true;
        }

        subsequence.remove(subsequence.size() - 1);
        if(subsequenceSum(nums, k, index+1, subsequence, sum)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,2,3,5,3};
        subsequenceSum(arr, 6);
    }
}
