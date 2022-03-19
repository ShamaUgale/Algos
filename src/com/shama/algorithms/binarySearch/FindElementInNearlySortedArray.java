package com.shama.algorithms.binarySearch;

public class FindElementInNearlySortedArray {

    static int near(int arr[],int target){
        int start=0;
        int end =arr.length-1;
        while(start<=end){
            int mid= start+(end-start)/2;

            if(arr[mid]==target)

                System.out.println(mid);
            if(mid-1>=start && target==arr[mid-1])
                System.out.println(mid-1);

            if(mid+1<=end && target==arr[mid+1])
                System.out.println(mid+1);

            if(target<=arr[mid])
                end=mid-2;
            else
                start=mid+2;
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[]={10, 3, 40, 20, 50, 80, 70};
        near(arr,70);

    }
}
