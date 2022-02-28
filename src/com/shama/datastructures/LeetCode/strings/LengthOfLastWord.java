package com.shama.datastructures.LeetCode.strings;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
//         String[] arr = s.trim().split(" ");
//         System.out.println(arr[arr.length-1].length());
//         return arr[arr.length-1].length();


        int len=s.length(), lastLength=0;

        while(len > 0 && s.charAt(len-1)==' '){
            len--;
        }

        while(len > 0 && s.charAt(len-1)!=' '){
            lastLength++;
            len--;
        }

        return lastLength;
    }
}
