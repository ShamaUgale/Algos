package com.shama.misc;

public class CountCharSum {
    public static void main(String args[]) {
        String str = "Anitha";
        int sum = 0;
        int[] freq = new int[26];

        char[] arr = str.toLowerCase().toCharArray();

        for(int i=0; i<arr.length;i++){
            int x = arr[i] - 'a';
            freq[x]++;
        }

        for(int i=0; i<freq.length; i++){
            sum = sum +  freq[i]*26;

        }

        System.out.println(sum);

    }
}
