package com.shama.datastructures.LeetCode.slindingWindow.variableSize;

import java.util.HashMap;

public class MinWindowSubstring {

    public static void main(String[] args) {
        minWindowSubString("timetopractice","toc");
    }

    static void minWindowSubString(String s, String t){

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i= 0 ; i<t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)+1);
        }

        int count = map.size();
        int min = Integer.MAX_VALUE;
        String ans = "";
        int i=0;
        for(int j=0 ; j<s.length() ; j++) {
            char ch = s.charAt(j);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1 );
                if(map.get(ch) == 0) {
                    count-- ;
                }
            }
            if(count == 0 ) {
                if(j-i+1 < min) {
                    ans = s.substring(i,j+1);
                    min =  j-i+1;
                }
                while(count == 0 && i<=j) {
                    char c = s.charAt(i);
                    if(map.containsKey(c)) {
                        if(map.get(c)==0) {
                            count++;
                        }
                        map.put(c, map.get(c)+1);
                    }
                    i++;
                    if(count == 0 && min>j-i+1) {
                        ans = s.substring(i,j+1);
                        min =  j-i+1 ;
                    }
                }
            }
        }
        System.out.println(ans);
        System.out.println("Min window size is : " + min);
    }
}
