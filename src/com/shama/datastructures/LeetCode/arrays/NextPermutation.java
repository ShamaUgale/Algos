package com.shama.datastructures.LeetCode.arrays;

public class NextPermutation {

    public static void main(String[] args) {
        // traverse from last elem
        // find the elem which is smaller than its next elem ( to right)
        // store that elem's index as idx1
        // now again traverse the arr from last
        // this time find an elem from last which is greater than the elem on idx1
        // store this index now as idx2
        // swap elems at id1 and idx2

        //now reverse the array from the elem next to idx1 to end of array
        // thats my final next permutation

        int[] arr = {4,1,5,3,2};
        getNextPermutation(arr);
        display(arr);
    }

    private static void display(int[] arr) {
        for(Integer i : arr){
            System.out.print(i + "  ");
        }
    }

    private static void getNextPermutation(int[] arr) {
        int idx1 = -1;
        int size = arr.length;
        for(int i = size-2; i>=0;i--){
            if(arr[i] < arr[i+1]){
                idx1 = i;
                break;
            }
        }

        if(idx1 < 0){
            reverse(arr, 0, size);
        }

        int idx2 = 0;
        for(int i = size-1; i>=0;i++){
            if(arr[i] > arr[idx1]){
                idx2 = i;
                break;
            }
        }

        swap(arr, idx1, idx2);
        reverse(arr, idx1+1, size-1);
    }

    private static void reverse(int[] arr, int i, int j) {
        while(i<j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
