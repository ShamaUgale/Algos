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
    public static List<String> letterCasePermutation(String s) {
        List<String> list  = new LinkedList<>();
        if(s == "")
            return list;

        String op = "";
        helper( s, op, list);
        return list;
    }
    private static void helper( String s, String op, List<String> list){
        if(s.length() == 0){
            list.add(op);
            return;
        }

        if(Character.isDigit(s.charAt(0))  ){
            op += s.charAt(0);
            s = s.substring(1);
            helper(s, op, list);
        }
        else{
            String op1 = op, op2= op;
            op1+= Character.toLowerCase(s.charAt(0));
            op2+= Character.toUpperCase(s.charAt(0));
            s = s.substring(1);
            helper(s, op1, list);
            helper(s, op2, list);
        }
        return;
    }
}
