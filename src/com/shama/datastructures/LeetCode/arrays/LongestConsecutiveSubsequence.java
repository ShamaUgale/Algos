package com.shama.datastructures.LeetCode.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] arr = {13,11,10,1,4,12};
        System.out.println(findLongestConseqSubseq(arr));
    }

    static int findLongestConseqSubseq(int arr[]) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        int N = arr.length;
        HashSet<Integer> hash = new HashSet<>();
        for(int i = 0;i<N;i++) {
            hash.add(arr[i]);
        }
        TreeSet<Integer> tree = new TreeSet<>(hash);
        Arrays.fill(arr,0);
        int k = 0;
        for(Integer a : tree) {
            arr[k] = a;
            k++;
        }
        int max = 1,count = 1;
        for(int i = 0;i<k-1;i++) {
            if(arr[i]+1 == arr[i+1]) {
                count++;
                max = Math.max(count,max);
            }
            else {
                count=1;
            }
        }
        return max;
    }
}
