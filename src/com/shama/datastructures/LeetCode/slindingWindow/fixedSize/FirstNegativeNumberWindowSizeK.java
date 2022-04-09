package com.shama.datastructures.LeetCode.slindingWindow.fixedSize;

import java.util.ArrayList;

/*
input = 12, -1, -7, 8, -15, 30, 16, 28
output = -1,-1,-7, -15,-15,0
 */
public class FirstNegativeNumberWindowSizeK {

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        getNegativeNumInWindow(arr,k);
    }

    private static void getNegativeNumInWindow(int[] arr, int k){
        int i = 0;
        int j = 0;
        ArrayList<Integer> negative_num_list = new ArrayList<>();
        while (j < arr.length) {
            if (arr[j] < 0)
                negative_num_list.add(arr[j]);
            if (j - i + 1 < k)
                j++;
            else if (j - i + 1 == k) {
                if(negative_num_list.size() == 0)
                    System.out.print("0 ");
                else {
                    System.out.print(negative_num_list.get(0)+" ");
                    if(arr[i] == negative_num_list.get(0)) {
                        negative_num_list.remove(0);
                    }
                }
                i++;
                j++;
            }
        }
        System.out.println();
    }
}
