package com.shama.datastructures.LeetCode.strings;
import java.util.*;

public class WordSuggestions {
        public static void main(String[] args) {

            String[] arr = {"abc", "abcde", "ame", "abd"};
            String pattern = "ab";
            Map<String, List<String>> output = getMatchingWords(arr, pattern);
            System.out.println(output.get(pattern));
        }

        static Map<String, List<String>> getMatchingWords(String[] arr, String pattern){

            HashMap<String, List<String>> map = new HashMap();
            List<String> result = new ArrayList();

            if(arr == null  || arr.length == 0){
                map.put(pattern, result);
                return map;
            }

            for(String s : arr){
                if( s.length() >= pattern.length() && s.substring(0,pattern.length()).equals(pattern)){
                    result.add(s);
                }
            }
            map.put(pattern, result);
            return map;
        }
}

