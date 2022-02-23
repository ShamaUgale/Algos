package com.shama.datastructures.LeetCode.arrays;

public class FindNextAlphabet {
    public static void main(String[] args) {
        char[] arr = {'a', 'c', 'e'};
        System.out.println("next alphabet is : " + nextGreatestLetter(arr, 'a'));
    }
    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return target >= letters[start] ? letters[0] : letters[start];
    }
}
