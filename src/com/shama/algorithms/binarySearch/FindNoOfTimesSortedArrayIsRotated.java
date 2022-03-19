package com.shama.algorithms.binarySearch;

public class FindNoOfTimesSortedArrayIsRotated {

    public static void main(String[] args) {
        int[] arr = {11,12,14,17,18,3,4};
        System.out.println("Its rotated : " + findMinElemIndex(arr) + " no of times");
        System.out.println("the min elem is arry is : " + findMin(arr));
    }
    public static int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }
        int start = 0, end = num.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid > 0 && num[mid] < num[mid - 1]) {
                return num[mid];
            }
            if (num[start] <= num[mid] && num[mid] > num[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return num[start];
    }

    // aditya verma
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
