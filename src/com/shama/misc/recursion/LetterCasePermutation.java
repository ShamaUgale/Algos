package com.shama.misc.recursion;

import java.util.LinkedList;
import java.util.List;

// Problem statement
// https://leetcode.com/problems/letter-case-permutation/
/*

Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. Return the output in any order.



Example 1:

Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
Example 2:

Input: s = "3z4"
Output: ["3z4","3Z4"]



 */
class LetterCasePermutation {

    public static void main(String[] args) {
        String str = "a1b2";
        System.out.println("Permuted string is : "+letterCasePermutation(str));//[a1b2, a1B2, A1b2, A1B2]
        System.out.println("Permuted string is : "+letterCasePermutation("3z4"));// [3z4, 3Z4]

    }
    public static List<String> letterCasePermutation(String str) {
        List<String> list  = new LinkedList<>();
        if(str == "")
            return list;

        String output = "";
        helper( str, output, list);
        return list;
    }
    private static void helper( String str, String output, List<String> list){
        if(str.length() == 0){
            list.add(output);
            return;
        }

        if(Character.isDigit(str.charAt(0))){
            output += str.charAt(0);
            str = str.substring(1);
            helper(str, output, list);
        }
        else{
            String op1 = output, op2= output;
            op1+= Character.toLowerCase(str.charAt(0));
            op2+= Character.toUpperCase(str.charAt(0));
            str = str.substring(1);
            helper(str, op1, list);
            helper(str, op2, list);
        }
        return;
    }
}
