package com.shama.misc;

import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return -1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        // the roman numbers are decreasing in nature
        // if the prev char is less than next char (if its increasing in nature) then decrement it
        // else add it
        for(int i=0; i< s.length(); i++){
            int val = map.get(s.charAt(i));
            if(i+1 < s.length() && val < map.get(s.charAt(i+1))){
                result = result - val;
            }else{
                result = result + val;
            }
        }
        return result;
    }
}
