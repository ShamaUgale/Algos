package com.shama.datastructures.LeetCode.arrays;

public class FindNoOfTimesSortedArrayIsRotated {

    public static void main(String[] args) {
        int[] arr = {11,12,14,17,18,3,4};
        System.out.println("Its rotated : " + findMinElemIndex(arr) + " no of times");
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
