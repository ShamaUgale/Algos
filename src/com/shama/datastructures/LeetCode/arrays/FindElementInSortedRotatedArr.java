package com.shama.datastructures.LeetCode.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FindElementInSortedRotatedArr {

    public static void main(String[] args) {
        int[] arr = {11,23,34,56,78, 8,9,10};

        int midIndex = findMinElemIndex(arr);
        int firstHalf = Arrays.binarySearch(arr, 0, midIndex-1, 23);
        int secondHalf = Arrays.binarySearch(arr, midIndex+1, arr.length-1, 23);

        if(firstHalf < 0 && secondHalf < 0){
            System.out.println("Not found");
        }else if(firstHalf < 0){
            System.out.println("found at : " + secondHalf);
        }else{
            System.out.println("Found at : " + firstHalf);
        }

    }

    public static int findMinElemIndex(int[] nums) {

        int l =0, len = nums.length, r = len-1;
        int prev, next;
        while(l<=r){
            //when array is already sorted
            if(nums[l] <= nums[r]){
                return l;
            }

            int mid= l+ (r-l)/2;
            prev = (mid+len-1)%len;
            next = (mid+1)%len;

            //mid is less then the prev and the next element
            if(nums[mid]<= nums[prev] && nums[mid] <= nums[next]){
                return mid;
            }
            else if(nums[mid] >= nums[l]){
                l = mid+1;
            }
            else {
                r= mid-1;
            }

        }
        return l;
    }


}
