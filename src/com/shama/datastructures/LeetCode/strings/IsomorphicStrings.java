package com.shama.datastructures.LeetCode.strings;

import java.util.HashMap;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length())
            return false;
        char[] chars = t.toCharArray();

        HashMap<Character, Character> map = new HashMap();
        for(int i=0; i< s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(chars[i])){
                    return false;
                }
            }else{
                if(map.containsValue(chars[i])){
                    return false;
                }
                map.put(ch, chars[i]);
            }
        }
        return true;
    }
}
