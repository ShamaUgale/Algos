package com.shama.algorithms.binarySearch;


/*

    Given a sorted array and a value x, the floor of x is the largest element in array smaller than or equal to x. Write efficient functions to find floor of x.

    Example:

    Input : arr[] = {1, 2, 8, 10, 10, 12, 19}, x = 5
    Output : 2
    2 is the largest element in arr[] smaller than 5.

 */
//and ciel
public class FindFloor {

    public static void main(String[] args) {
    int[] arr = {1,2,3,4,8,11,34,56};
        System.out.println("floor is : " + floorOfNumber(arr,5));
        System.out.println("ciel is : " + cielOfNumber(arr,1));

    }

    public static int floorOfNumber(int[] arr,int key) {
        int n = arr.length;
        int start = 0, end = n - 1;
        int max=0;

        while(start<=end)
        {
            int mid=(start+end)/2;

            if(arr[mid]==key)
                return key;

            if(arr[mid]>key)
            {
                end=mid-1;
            }
            if(arr[mid]<key) {
                start=mid+1;
                max=arr[mid];
            }
        }
        return max;
    }

    public static int cielOfNumber(int[] arr,int key) {
        int n = arr.length;
        int start = 0, end = n - 1;
        int max=0;

        while(start<=end)
        {
            int mid=(start+end)/2;

            if(arr[mid]==key)
                return key;

            if(arr[mid]>key){
                end=mid-1;
                max=arr[mid];
            }
            if(arr[mid]<key) {
                start=mid+1;
//                max=arr[mid];
            }
        }
        return max;
    }
}
