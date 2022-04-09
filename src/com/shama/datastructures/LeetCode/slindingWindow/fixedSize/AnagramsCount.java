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
    public static List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            HashMap<Character, Integer> anagramMap = new HashMap<>();

            //put all elements of pattern p in map
            for (int i = 0; i < p.length(); i++) {
                char current_char = p.charAt(i);
                anagramMap.put(current_char, anagramMap.getOrDefault(current_char, 0)+1);
            }
            int count = anagramMap.size();
            int i = 0, j = 0;
            while (j < s.length()) {
                //calculations
                if (anagramMap.containsKey(s.charAt(j))) {
                    anagramMap.put(s.charAt(j), anagramMap.get(s.charAt(j)) - 1);
                    if (anagramMap.get(s.charAt(j)) == 0) {
                        count--;
                    }
                }
                //window size less than k
                if (j - i + 1 < p.length())
                    j++;

                else if (j - i + 1 == p.length()) {
                    //result calculate
                    if (count == 0) {
                        result.add(i);
                        //remove result of i before sliding
                    }
                    if (anagramMap.containsKey(s.charAt(i))) {
                        anagramMap.put(s.charAt(i), anagramMap.get(s.charAt(i)) + 1);
                        if (anagramMap.get(s.charAt(i)) == 1)
                            count++;
                    }
                    i++;
                    j++;
                }
            }
            return result;
        }
}
