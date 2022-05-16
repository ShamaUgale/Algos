package com.shama.datastructures.LeetCode.slindingWindow.variableSize;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String str = "ABAB";
        System.out.println(afterReplace(str, 2));//4
        System.out.println(afterReplace("AABABBAAAA",1));//5
    }

    private static int afterReplace(String str, int k) {
        int size = str.length();
        int start =0;
        int maxLen = 0;
        int maxCount =0; // the most freq char
        int[] char_counts = new int[26];

        for(int end =0 ; end < size ; end++){
            char_counts[str.charAt(end) - 'A']++;
            int currentMax = char_counts[str.charAt(end) - 'A'];
            maxCount = Math.max(maxCount, currentMax);

            if(end -start -maxCount +1 > k){
                char_counts[str.charAt(start) - 'A']--;
                start++;
            }
            maxLen = Math.max(maxLen, end-start+1);
        }
        return maxLen;
    }
}
