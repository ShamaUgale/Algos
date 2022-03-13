package com.shama.datastructures.LeetCode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ReverseInteger {

    // time O(n) space )(n)
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        int x = 34567;
        while(x!=0){
            stack.push(x%10);
            x = x/10;
        }

        for(Integer i : stack){
            System.out.print(i);
        }

        System.out.println();
        System.out.println(printReverseInt(6234519));

        String s = "2";
        int a = s.charAt(0)-'0';
        System.out.println(a);
        ArrayList<String> arr = new ArrayList<>(Arrays.asList("+","-","*","/"));
    }

    public static  int printReverseInt(int x){
        int rev = 0;

        while(x != 0){
            rev = rev*10 + x%10;
            x= x/10;
        }
        return rev;
    }
}

