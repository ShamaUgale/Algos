package com.shama.datastructures.LeetCode.heap;

import java.util.PriorityQueue;

public class SortLowerCaseLetters {
    public String lowerCaseSort(String str) {
        if (str.length() == 0) return "";

        PriorityQueue<Character> pq = new PriorityQueue<>();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i))) {
                pq.add(str.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i))) {
                sb.append(pq.poll());
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
