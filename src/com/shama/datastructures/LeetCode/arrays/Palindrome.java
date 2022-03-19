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

    public static boolean isPalindrome(int num){
        int rev =0;
        int orignalNum = num;
        while(num != 0){
            rev = rev*10 + num%10;
            num = num/10;
        }

        if(orignalNum == rev){
            return true;
        }else{
            return false;
        }

    }

    public static void main(String[] args) {
        String s = "madamm";
//        System.out.println("Is palindrome: " + isPalindrome(s));

        int x = 01;
        System.out.println("Is palindrome: " + isPalindrome(x));

    }
}
