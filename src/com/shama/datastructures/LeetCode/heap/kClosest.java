package com.shama.datastructures.LeetCode.heap;

import java.util.*;

public class kClosest {

     public List<Integer> findClosestElements(int[] arr, int k, int x) {
            Queue<Integer> pq = new PriorityQueue<>((a, b)->(Math.abs(a-x)<Math.abs(b-x))?1:-1);
            List<Integer> result = new ArrayList<>();
            for(int i : arr) {
                pq.add(i);
                if(pq.size()>k)
                    pq.remove();
            }
            while(!pq.isEmpty()) {
                result.add(pq.remove());
            }
            Collections.sort(result);
            return result;
     }
}


