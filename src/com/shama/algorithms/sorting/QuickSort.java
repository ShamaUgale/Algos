package com.shama.algorithms.sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4,1,9,0,2,7,8};
        quickSort(arr);
        display(arr);
    }

    private static void display(int[] arr){
        for(Integer i : arr){
            System.out.print(" " + i);
        }
    }

    private static  void quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }
    private static void quickSort(int[] arr, int start, int end) {
        // edge condition - to stop recursion from getting into infinite loop
        if(start >= end){
            return;
        }

        int boundary = partition(arr, start, end);

        // sort right array
        quickSort(arr, start, boundary-1);
        // sort left array
        quickSort(arr, boundary+1, end);
    }

    private static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
        int boundary = start-1;
        for(int i=start; i<=end ; i++){
            if(arr[i] <= pivot){
                boundary++;
                swap(arr, boundary, i);
            }
        }
        return boundary;
    }

    private static void swap(int[] arr, int boundary, int i) {
        int temp = arr[boundary];
        arr[boundary] = arr[i];
        arr[i] = temp;
    }
}
