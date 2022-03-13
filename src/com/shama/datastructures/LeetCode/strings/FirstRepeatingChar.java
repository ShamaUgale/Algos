package com.shama.datastructures.LeetCode.strings;

import java.util.HashSet;

public class FirstRepeatingChar {

    public static void main(String[] args) {
        char[] arr = {'a','b','c','d','b','a'};
        System.out.println(getFirstRepeatingChar(arr));
    }

    private static char getFirstRepeatingChar(char[] arr) {
        HashSet<Character> set = new HashSet<>();
        for (Character c : arr) {
            if (set.contains(c)) {
                return c;
            }else {
                set.add(c);
            }
        }
        return '\0';
    }
}
