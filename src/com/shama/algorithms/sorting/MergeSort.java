package com.shama.algorithms.sorting;

public class MergeSort {

    public static void mergeSort(int[] arr){
        if(arr.length <2){
            return;
        }
        int mid = arr.length/2;
        int left[] = new int[mid];
        for(int i=0; i< mid; i++){
            left[i] = arr[i];
        }

        int right[] = new int[arr.length-mid];
        for(int i=mid; i<arr.length;i++){
            right[i-mid] = arr[i];
        }
        mergeSort(left);
        mergeSort(right);

        merge(left, right,arr);

    }

    private static void merge(int[] left, int[] right, int[] res) {
        int i=0;
        int j=0;
        int k =0;
        while (i<left.length && j< right.length){
            if(left[i] <right[j]){
                res[k] = left[i];
                k++;
                i++;
            }else{
                res[k] = right[j];
                k++;
                j++;
            }
        }
        while(i<left.length){
            res[k] = left[i];
            k++;
            i++;
        }
        while(j<right.length){
            res[k] = right[j];
            k++;
            j++;
        }
    }


    public static void main(String[] args) {
        int[] arr = {-5,1,3,6,2};
        mergeSort(arr);
        for(int i=0; i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
