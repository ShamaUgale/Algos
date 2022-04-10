package com.shama.datastructures.LeetCode.stacks;

public class RainWaterTrapping {
/*
    1. for each elem in the array find the max on left
    2. for each elem in array find the max on right
    3. eg : 3,0,0,2,0,4
            in  a nutshell max on right is 4 and left is 3
          === > maxOnLeft array [3,3,3,3,3,4]
          === > maxOnRight array [4,4,4,4,4,4]
    4. now the water of is min of maxOnLeft[i] and maxOnRight[i]
    5. the are trapped for a building is the water on top can be the water minus the height of building
    6. the area trapping water is the sum of all the trapped water for each building


 */


    public static void main(String[] args) {
        int arr[] = {3,0,0,2,0,4};
        int totalWaterTrappedArea = findWaterTrappedArea(arr, arr.length);
        System.out.println(totalWaterTrappedArea);
    }

    private static int findWaterTrappedArea(int[] arr, int length) {
        int max_area_trapped_in_water = 0;

        // find the max num in right for each elem in an arr
        int[] maxL = new int[length];
        maxL[0] = arr[0];
        for(int i=1; i<length;i++){
            maxL[i] = Math.max(arr[i], maxL[i-1]);
        }

        int[] maxR = new int[length];
        maxR[length-1] = arr[length-1];
        for(int i=length-2; i>=0;i--){
            maxR[i] = Math.max(arr[i], maxR[i+1]);
        }

        int[] water = new int[length];
        for(int i=0; i<length;i++){
            water[i] = Math.min(maxL[i], maxR[i]) - arr[i];
        }

        for(Integer x : water){
            max_area_trapped_in_water = max_area_trapped_in_water + x;
        }
        return max_area_trapped_in_water;
    }

}
