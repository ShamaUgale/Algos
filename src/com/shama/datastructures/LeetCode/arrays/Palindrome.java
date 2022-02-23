package com.shama.datastructures.LeetCode.arrays;

public class Palindrome {

    public static boolean isPalindrome(String str){
        char[] arr = str.toCharArray();
        int start =0;
        int end = arr.length-1;
        while(start < end){
            if(arr[start]!= arr[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "madamm";
        System.out.println("Is palindrome: " + isPalindrome(s));
    }
}
