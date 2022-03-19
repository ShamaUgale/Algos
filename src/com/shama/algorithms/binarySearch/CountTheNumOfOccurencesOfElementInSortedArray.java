package com.shama.algorithms.binarySearch;

public class CountTheNumOfOccurencesOfElementInSortedArray {

    public static void main(String[] args) {
        int[] nums = {2,3,4,5,6,6,6,6,6,7};
        int[] res = searchRange(nums, 7);
        System.out.println("The no of occureneces on elemn 7 is : " + (res[1] - res[0] + 1));
    }
    public static int[] searchRange(int[] nums, int target) {

        //********************* binary search - O(nlogn)************************
        int result[] = new int[2];
        result[0] = findFirstPosition(nums, target);
        result[1] = findLastPosition(nums, target);

        return result;
    }

    private static int findFirstPosition(int[] a, int target) {
        int start = 0;
        int end = a.length-1;

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

    private static int findLastPosition(int[] a, int target) {
        int start = 0;
        int end = a.length-1;

        int lastPosition = -1;
        while(start <= end) {
            int mid = (start + end)/2;

            if(target == a[mid]) {
                // Found target, update lastPosition
                //and move to the right to find a higher position by setting start=mid+1
                lastPosition = mid;
                start = mid+1;
            } else if (target < a[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return lastPosition;
    }
}
