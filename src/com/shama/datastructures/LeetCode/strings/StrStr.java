package com.shama.datastructures.LeetCode.strings;
/*

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string.
This is consistent to C's strstr() and Java's indexOf().



Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Example 3:

Input: haystack = "", needle = ""
Output: 0



 */
public class StrStr {

    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) {
            return 0;
        }
        if(haystack.length() < needle.length()) {
            return -1;
        }
        if(haystack.length() == needle.length()) {
            return haystack.equals(needle) ? 0 : -1;
        }
        for(int i=0; i < haystack.length(); i++) {
            int hIndex = i;
            int nIndex = 0;
            while(hIndex < haystack.length() && nIndex < needle.length() && haystack.charAt(hIndex) == needle.charAt(nIndex)) {
                hIndex++;
                nIndex++;
            }
            if(nIndex == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
