package com.shama.datastructures.LeetCode.strings;

import java.util.Scanner;

class TestClass {
    public static int countSubsequences(String line) {
        // TODO -- write your code here, and remember to return the
        // count
        char s[]=line.toCharArray();
        int i=0,count=0;
        for(i=0;i<line.length()-2;i++){

            if(s[i]==s[i+1]){
                count++;
                if(s[i+2]==s[i+1]){
                    count--;
                }
            }
        }
        if(s[line.length()-1]==s[line.length()-2]){
            count++;
        }
        return count;
    }

    public static void main(String args[]) throws Exception {
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()) {
            System.out.println(countSubsequences(input.nextLine()));
        }
    }
}