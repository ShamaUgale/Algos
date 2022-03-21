package com.shama.datastructures.LeetCode.slindingWindow;
/*
Given an array of integers Arr of size N and a number K.
Return the maximum sum of a subarray of size K.

Example:

Input:
N = 4, K = 2
Arr = [100, 200, 300, 400]
Output:
700
Explanation:
Arr3  + Arr4 =700,
which is maximum.
 */
public class MaxSunSubArraySizeK {
    public static void main(String[] args) {
        int arr[] = {10,20,30,40};
        int k = 2;
        System.out.println("Max sum is : " + getMaxSum(arr,k));

    }

    private static int getMaxSum(int[] arr, int k){
        int start = 0;
        int end = 0;
        int len = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        while (end < len){
            sum +=arr[end];
            if(end-start+1 < k){
                end++;
            }else if(end-start+1 == k){
                maxSum = Math.max(maxSum, sum);
                sum = sum - arr[start];
                start++;
                end++;
            }
        }
        return  maxSum;
    }
}
