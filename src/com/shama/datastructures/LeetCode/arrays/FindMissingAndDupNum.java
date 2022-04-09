package com.shama.datastructures.LeetCode.arrays;

/*
Time complexity O(n)
space O(1)
 */
public class FindMissingAndDupNum {
    public static void main(String[] args) {
        int[] arr = {1,3,1,5,1,5};
        swapSort(arr);
    }

    public static void swapSort(int[] arr) {
        int i = 0;
        int len = arr.length;
        while(i < len) {
            int value = arr[i];
            int correctIndexToBe = value - 1;
            if( value != (i+1)) {
                if(value == arr[correctIndexToBe]){   // in case of duplicate value
                    i++;      // just increase 'i' forward
                    continue;
                }
                swap(arr, i , correctIndexToBe);
            }
            else {
                i++;
            }
        }
        for(int j = 0 ; j < len ; j++) {
            if( arr[j] != (j+1) ) {
                System.out.println("Missing : " + (j+1) + "  Duplicate : " + arr[j]);
            }
        }
    }

    private static void swap(int[] arr, int i, int correctIndexToBe) {
        int temp = arr[i];
        arr[i] = arr[correctIndexToBe];
        arr[correctIndexToBe] = temp;
    }
}
