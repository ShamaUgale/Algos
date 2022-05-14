package com.shama.datastructures.LeetCode.slindingWindow.fixedSize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnagramsCount {
    public static void main(String[] args) {
        String str = "forxxorfxdofr";
        String pattern = "for";
        System.out.println("The anagrams starts at index : " + findAnagrams(str, pattern));
        System.out.println("No of anagrams in the string '" + str + "' is : " + findAnagrams(str, pattern).size());

    }
    public static List<Integer> findAnagrams(String str, String pattern) {
            List<Integer> result = new ArrayList<>();
            HashMap<Character, Integer> anagramMap = new HashMap<>();

            //put all elements of pattern  in map
            for (int i = 0; i < pattern.length(); i++) {
                char current_char = pattern.charAt(i);
                anagramMap.put(current_char, anagramMap.getOrDefault(current_char, 0)+1);
            }
            int count = anagramMap.size();
            int start = 0, end = 0;
            while (end < str.length()) {
                //calculations
                if (anagramMap.containsKey(str.charAt(end))) {
                    anagramMap.put(str.charAt(end), anagramMap.get(str.charAt(end)) - 1);
                    if (anagramMap.get(str.charAt(end)) == 0) {
                        count--;
                    }
                }
                //window size less than k
                if (end - start + 1 < pattern.length())
                    end++;

                else if (end - start + 1 == pattern.length()) {
                    //result calculate
                    if (count == 0) {
                        result.add(start);
                        //remove result of start before sliding
                    }
                    // watch video from 22 mins
                    if (anagramMap.containsKey(str.charAt(start))) {
                        anagramMap.put(str.charAt(start), anagramMap.get(str.charAt(start)) + 1);
                        if (anagramMap.get(str.charAt(start)) == 1)
                            count++;
                    }
                    start++;
                    end++;
                }
            }
            return result;
        }
}
