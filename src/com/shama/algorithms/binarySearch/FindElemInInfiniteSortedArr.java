package com.shama.algorithms.binarySearch;

public class FindElemInInfiniteSortedArr {

    // Find position of an element in an Infinite Sorted Array

    private static int binarySearch(int[] a, int target) {
        int start = 0;
        int end = 1;

        // First try to find the lower and upper bounds before applying binary search
        while (target > a[end]) {
            start = end;
            end *= 2; // just keep increasing the search size by 2 times
        }

        while (start <= end) {
            int mid = (start + end) / 2;

            if (target == a[mid]) {
                return mid;
            } else if (target < a[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

}
