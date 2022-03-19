package com.shama.algorithms.binarySearch;

public class MinimumDifferenceElementInSortedArray {
    /*

    Given a sorted array, find the element in the array which has minimum difference with
    the given number.

     */

    public static void main(String[] args) {
        int arr[] = {1,3,10,15};
        int key = 12;
        // if the key is present in the arr then the min diff will be zero and hence thats the ans
        // if key isnt present then, when binary search ends , end will be less than start
        // the abs diff between ( arr[start] - key ) and  ( arr[end] - key) which ever is lowest is your ans

        System.out.println("The elem with min diff is : " + elemWithMinDifference(arr, key));

    }

    private static int elemWithMinDifference(int[] arr, int key){
        if(arr == null || arr.length == 0){
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == key){
                return arr[mid];
            }else if(arr[mid] > key){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return Math.abs(arr[end] - key) > Math.abs(arr[start] - key) ? arr[start]: arr[end] ;
    }
}
