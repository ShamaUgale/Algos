package com.shama.datastructures.LeetCode.slindingWindow;

import java.util.HashSet;

public class LongestSubStringWithUniqueChars {

    public static void main(String[] args) {
        System.out.println(longestUniqueSubsttr("pwwkew")); // 3
        System.out.println(longestUniqueSubsttr("bbbbbb")); // 1
        System.out.println(longestUniqueSubsttr("")); // 0

    }

    static int  longestUniqueSubsttr(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        HashSet<Character> hm = new HashSet<>();
        int i=0;
        int j=0;
        int maxL = -1;
        while(j<s.length()){
            if(!hm.contains(s.charAt(j))){
                hm.add(s.charAt(j));
                maxL = (j-i+1) > maxL ? (j-i+1) : maxL;
                j++;
            }
            else{
                while(s.charAt(i) != s.charAt(j)){
                    hm.remove(s.charAt(i));
                    i++;
                }
                hm.remove(s.charAt(i));
                i++;
            }
        }
        return maxL;
    }
}
