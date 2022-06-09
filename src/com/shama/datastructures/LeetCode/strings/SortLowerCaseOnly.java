package com.shama.datastructures.LeetCode.strings;


public class SortLowerCaseOnly {
    static int count[] = new int[27];
    static int current = 0;

    static boolean isLowerCaseChar(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    static String sortLowerCase(String input) {
        count[26] = 0; // dummy character
        StringBuilder string = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (isLowerCaseChar(ch))
                count[ch - 'a']++;
        }

        for (int i = 0; i < string.length(); i++) {
            char ch = input.charAt(i);
            if (isLowerCaseChar(ch)) {
                string.setCharAt(i, findNext());
            }
        }
        return string.toString();
    }

    static char findNext() {
        while (current < 26 && count[current] == 0) {
            current++;
        }
        count[current]--;
        return (char) ('a' + current);

    }
}