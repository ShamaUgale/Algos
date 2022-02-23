package com.shama.datastructures.LeetCode.arrays;

import java.util.HashMap;

public class TowNumberSum {

    public static void main(String[] args) {
        int[] arr = {3,5,-4,8,11,1,-1,6};
        int target = 0;

        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0; i< arr.length; i++){
            int complement = target - arr[i];
            if(map.containsKey(complement)){
                System.out.println(complement + " " + arr[i]);;
            }else{
                map.put(arr[i], arr[i]);
            }
        }
    }
}
