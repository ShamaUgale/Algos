package com.shama.datastructures.LeetCode.slindingWindow.variableSize;

public class LargestSubarrayOfSumK {

    public static void main(String[] args) {
        int[] arr = {4, 1, 1, 1, 2, 3, 5};
        int sum = 5;
        System.out.println("Max window size for sum " + sum + " is : " + largestWindowSizeForSumK(arr, sum));
        System.out.println("(1)Max window size for sum " + sum + " is : " + largestSubarray(arr, sum));
    }

    private static int largestWindowSizeForSumK(int[] arr, int sum){
        int maxWindowSize = 0;
        int arr_length = arr.length;
        int current_sum = 0;
        int start =0;
        int end =0;

        while (end < arr_length){
            current_sum = current_sum + arr[end];
            if(current_sum < sum){
                end++;
            }else if(current_sum == sum){
                maxWindowSize = Math.max(maxWindowSize, end-start+1);
                end++;
            }else{
                while(current_sum > sum){
                    current_sum = current_sum - arr[start];
                    start++;
                }
                end++;
            }
        }

        return  maxWindowSize;
    }

    static int largestSubarray(int[] arr, int k){
        int max = 0, sum = 0, i = 0, j = 0;
        while(j < arr.length){
            sum += arr[j];
            if(sum < k){
                j++;
            }
            else if(sum == k){
                max = Math.max(max, j - i + 1);
                j++;
            }
            else{
                while(sum > k){
                    sum -= arr[i];
                    i++;
                    if(sum == k){
                        max = Math.max(max, j - i + 1);
                    }
                }
                j++;
            }
        }
        return max;
    }
}
