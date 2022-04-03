package com.shama.algorithms.sorting;

/*
 Time complexity O(n square)
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr){
        for(int i=0; i<arr.length;i++) {
            for (int j = 1; j < arr.length-i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,1,3,6,2};
        bubbleSort(arr);
        for(int i=0; i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
