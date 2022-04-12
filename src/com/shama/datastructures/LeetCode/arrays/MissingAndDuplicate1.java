package com.shama.datastructures.LeetCode.arrays;

public class MissingAndDuplicate1 {

// use this code only during the interview
    static void printTwoElements(int arr[], int size) {
        int i;
        System.out.println("****************************");

        System.out.println("The repeating element is/are ");

        for (i = 0; i < size; i++) {
            int abs_val = Math.abs(arr[i]);
            if (arr[abs_val - 1] > 0)
                arr[abs_val - 1] = -arr[abs_val - 1];
            else
                System.out.println(abs_val);
        }

        System.out.println("****************************");
        System.out.println("And the missing element is/are ");
        for (i = 0; i < size; i++) {
            if (arr[i] > 0)
                System.out.println(i + 1);
        }
        System.out.println("****************************");

    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {7, 4, 4, 5, 5, 6, 2};
        int n = arr.length;
        printTwoElements(arr, n);
    }
}
