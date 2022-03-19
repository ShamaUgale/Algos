package com.shama.algorithms.binarySearch;

public class NextAlphabeticalElement {
    public static void main(String[] args) {
        char[] arr = {'a', 'c', 'f', 'h'};
        char key = 'h';
        System.out.println("The next char to " + key + " is : " +getNextChar(arr, key) );
    }

    public static char getNextChar(char[] arr,char key) {
        int n = arr.length;
        int start = 0, end = n - 1;
        char result= '#';

        while(start<=end)
        {
            int mid=(start+end)/2;

            if(arr[mid]==key)
                start = mid+1;

            if(arr[mid]>key){
                end=mid-1;
                result=arr[mid];
            }
            if(arr[mid]<key) {
                start=mid+1;
            }
        }
        return result;
    }

}
