package com.shama.datastructures.LeetCode.arrays;

import java.util.HashMap;
import java.util.Map;

public class FindUnique {

    public static void main(String[] args) {
        int[] arr = {4,5,2,1,8,2,1,5,3};
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer i : arr){ // int, Integer, traditional
            Integer current_num = i;
           map.put(current_num, map.getOrDefault(current_num,0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//            System.out.println(entry.getKey() + " - " + entry.getValue());
            if(entry.getValue() == 1){
                System.out.println(entry.getKey());
            }
        }
    }
}
