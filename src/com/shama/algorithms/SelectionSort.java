package com.shama.algorithms;

public class SelectionSort {

    public static void selectionStart(int[] arr){
        for(int i=0; i< arr.length;i++) {
            int min_index = i;
            for(int j =i; j<arr.length;j++){
                if(arr[j] < arr[min_index]){
                    min_index =j;
                }
            }
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }

    }
    public static void main(String[] args) {
        int[] arr = {5,1,3,6,2,2,-5};
        selectionStart(arr);
        for(int i=0; i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

}
