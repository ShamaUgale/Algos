package com.shama.datastructures.LeetCode.strings;

public class Anagrams {
    static boolean areAnagram(char[] str1, char[] str2) {
        if (str1.length != str2.length)
            return false;

        int[] count = new int[256];
        int i;

        for(i = 0; i < str1.length; i++) {
            count[Math.abs(str1[i] - 'a')]++;
            count[Math.abs(str2[i] - 'a')]--;
        }

        for(i = 0; i < count.length; i++)
            if (count[i] != 0) {
                return false;
            }
        return true;
    }

    // Driver code
    public static void main(String[] args)
    {
        char str1[] = "For".toCharArray();
        char str2[] = "orF".toCharArray();

        // Function call
        if (areAnagram(str1, str2))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}
