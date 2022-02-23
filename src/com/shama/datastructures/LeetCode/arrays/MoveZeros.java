package com.shama.datastructures.LeetCode.arrays;

public class MoveZeros {
    public void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /*
        2 pointers
         - j for 0
         - i for non zero
        will swap i and j if j is 0 and i is non zero,
        j will move only if its non-zero i will move normally in for loop
     */
    public void moveZerosToEndOfArray(int[] arr){
        int j=0;
        for(int i=0; i<arr.length;i++){
            if(arr[i]!=0 && arr[j]==0){
                swapNumbers(arr,i, j);
            }
            if(arr[j]!=0){
                j++;
            }
        }
    }

    public void moveOnesToEndOfArray(int[] arr){
        int j=0;
        for(int i=0; i<arr.length;i++){
            if(arr[i]!=1 && arr[j]==1){
                swapNumbers(arr,i, j);
            }
            if(arr[j] !=1){
                j++;
            }
        }
    }

    public void swapNumbers(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        MoveZeros m = new MoveZeros();
        int[] arr = {8,1,0,2,1,0,3};
        m.printArray(arr);
        System.out.println("After moving 0s");
        m.moveZerosToEndOfArray(arr);
        m.printArray(arr);
        System.out.println("After moving 1s");
        m.moveOnesToEndOfArray(arr);
        m.printArray(arr);
    }
}
