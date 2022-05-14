package com.shama.datastructures.LeetCode.slindingWindow.variableSize;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubStringWithUniqueChars {

    public static void main(String[] args) {
        System.out.println(longestUniqueSubsttr("pwwkew")); // 3
        System.out.println(longestUniqueSubsttr("bbbbbb")); // 1
        System.out.println(longestUniqueSubsttr("")); // 0

        System.out.println("=======================");
        System.out.println(allUniqueCharWinSize("pwwkewx"));

    }

    static int allUniqueCharWinSize(String s){
        {
            HashMap<Character,Integer> charMap=new HashMap<>();
            int i =0;
            int j =0;
            int maxStringlen = Integer.MIN_VALUE;
            while(j<s.length()){
                char ch=s.charAt(j);
                charMap.put(ch, charMap.getOrDefault(ch, 0)+1);

                if(charMap.size()== (j-i+1) ){
                    maxStringlen=Math.max(maxStringlen,j-i+1);
                    j++;
                }
                else if(charMap.size() < (j-i+1) ){
                    while(charMap.size()< (j-i+1)){

                        if(charMap.containsKey(s.charAt(i))){
                            int freq=charMap.get(s.charAt(i));
                            freq--;
                            charMap.put(s.charAt(i),freq);
                        }
                        if(charMap.get(s.charAt(i))==0){
                            charMap.remove(s.charAt(i));
                        }
                        i++;
                    }
                    j++;
                }
            }
            System.out.println("The no of unique chars are : " + charMap.size());
            return  maxStringlen;
        }
    }

    static int  longestUniqueSubsttr(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        int i=0;
        int j=0;
        int maxL = Integer.MIN_VALUE;
        while(j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                maxL = Math.max(maxL, j-i+1);
                j++;
            }
            else{
                while(s.charAt(i) != s.charAt(j)){
                    set.remove(s.charAt(i));
                    i++;
                }
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxL;
    }
}
