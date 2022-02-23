package com.shama.datastructures.LeetCode.strings;

import java.util.Scanner;

class CountSequences {
    public static int countSubsequences(String line) {
        // TODO -- write your code here, and remember to return the 
        // count
        int slow=0,fast=1,count=0;
        boolean repeatStarts=false;
        if(line.length()<2)
            return 0;
        while(fast<line.length()){
            if(line.charAt(slow)==line.charAt(fast)){
                repeatStarts=true;
                fast++;
            }
            else{
                if(repeatStarts){
                    count++;
                    slow=fast;
                    fast++;
                    repeatStarts=false;
                }
                else{
                    slow=fast;
                    fast++;
                }
            }
        }
        if(repeatStarts)
            count++;
        return count;
    }

    public static void main(String args[]) throws Exception {
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()) {
            System.out.println(countSubsequences(input.nextLine()));
        }
    }
}