package com.shama.datastructures.LeetCode.arrays;

public class FindMisssingNum {
    public void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int findMissingNum(int[] arr){
        int n = arr.length+1;
        int sum = (n*(n+1))/2;
        int arrSum=0;
        for(int i=0;i<arr.length;i++){
            arrSum= arrSum+arr[i];
        }
        return sum -arrSum;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,7};

        FindMisssingNum f = new FindMisssingNum();
        System.out.println(f.findMissingNum(arr));
    }
}
