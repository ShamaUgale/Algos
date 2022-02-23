package com.shama.datastructures.LeetCode.strings;

import java.util.HashMap;
import java.util.Map;

public class CountAnagramOfPatternInString {

    public int search(String pat, String txt) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<pat.length();i++){
            char ch=pat.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int count=map.size();
        int ans=0;
        int i=0,j=0;
        int k=pat.length();
        while(j<txt.length()){
            char ch=txt.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0){
                    count--;
                }
            }

            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                if(count==0){
                    ans++;
                }
                if(map.containsKey(txt.charAt(i))){
                    map.put(txt.charAt(i),map.get(txt.charAt(i))+1);
                    if(map.get(txt.charAt(i))==1){
                        count++;
                    }
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
