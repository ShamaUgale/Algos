package com.shama.algorithms.dynamicProgramming;


import java.util.LinkedHashMap;
import java.util.Map;

/*

given string aaaaabbbccccdddddee can be encoded as a5b3c4d4e2

if the encoded string helps in shortening the length of given string return true else return false

 */
public class Huffman {

    public static void main(String[] args) {
//        String input = "aaaaabbbccccdddddee";
        String input = "abc";

        String huffmanString = "";

        Map<Character, Integer> map = new LinkedHashMap<>();
         for(Character c : input.toCharArray()){
             map.put(c, map.getOrDefault(c, 0)+1);
         }

         for(Map.Entry<Character,Integer> entry: map.entrySet()){
             huffmanString = huffmanString + entry.getKey() + entry.getValue();
         }

        System.out.println(huffmanString);

        System.out.println(huffmanString.length() >= input.length() ? false: true);
    }
}
