package com.shama.datastructures.LeetCode.strings;

public class ReverseString {

    public static void main(String[] args) {
        String input = "This is a string";
        System.out.println(reverseString(input));
    }

    private static String reverseString(String input){
        String reveredString = "";
        char[] temparray = input.toCharArray();
        int left, right = 0;
        right = temparray.length - 1;

        for (left = 0; left < right; left++, right--) {
            // Swap values of left and right
            char temp = temparray[left];
            temparray[left] = temparray[right];
            temparray[right] = temp;
        }

        for (char c : temparray)
            System.out.print(reveredString+c);

        return reveredString;
    }

    private static String reverseWords(String str){

        String result = "";

        int start =0;
        int end = str.length() - 1;


        return result;
    }
}
