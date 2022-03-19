package com.shama.algorithms.binarySearch;

import static java.util.Arrays.binarySearch;

public class FindFisrtAndLastOccurenceOfNumber {

    public static void main(String[] args) {
        int[] nums = {7,7,7,7,8,8,8,8,9,9,9};
        int fisrt = findFirstOccurenceOfNumber(nums, 7);
        System.out.println("First occurence of : " + 7 + " in array is : " + fisrt);
        int last = findLastOccurenceOfNumber(nums, 7);
        System.out.println("Last occurence of : " + 7 + " in array is : " + last);
        int res[] = searchRange(nums, 8);
        System.out.println(res[0] + " : " + res[1]);
    }

    public static int findFirstOccurenceOfNumber(int[] nums, int key){
        int elemIndex = binarySearch(nums, key);
        int firstOccurenceIndex = elemIndex;
        while(elemIndex >0 && nums[elemIndex-1] == key){
                firstOccurenceIndex = elemIndex-1;
                elemIndex--;
        }

        return firstOccurenceIndex;
    }

    public static int findLastOccurenceOfNumber(int[] nums, int key){
        int elemIndex = binarySearch(nums, key);
        int firstOccurenceIndex = elemIndex;
        while(elemIndex < nums.length-1 && nums[elemIndex+1] == key){
            firstOccurenceIndex = elemIndex+1;
            elemIndex++;
        }

        return firstOccurenceIndex;
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
