package com.shama.algorithms.binarySearch;

public class FindFirstOccurrenceOfOne {

    /*
    Given an infinite sorted array consisting 0s and 1s.
    The problem is to find the index of first ‘1’ in that array.
    As the array is infinite, therefore it is guaranteed that number ‘1’ will be present in the array.

    Example:

       Input : arr[] = {0, 0, 1, 1, 1, 1}
       Output : 2

     */

    public static void main(String[] args) {

        // lets say this is infinite sorted binary arr
        int[] arr = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

        int start = 0;
        int end = 1;
        while(arr[end] != 1){
            start = end;
            end = end * 2;
        }
        int fistPositionForOne = findFirstPosition(arr, start, end, 1);
        System.out.println("The 1st position of 1 in sorted binary array is : " + fistPositionForOne);
    }

    private static int findFirstPosition(int[] a, int start, int end, int target) {
        int firstPosition = -1;

        while(start <= end) {
            int mid = (start + end)/2;

            if(target == a[mid]) {
                // Found target, update firstPosition
                // and move to the left to find a smaller position by setting end=mid-1
                firstPosition = mid;
                end = mid-1;
            } else if (target < a[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return firstPosition;
    }

}
