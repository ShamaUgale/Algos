package com.shama.algorithms.binarySearch.twoD;

public class findFirstBadVersion {

    public static void main(String[] args) {
        char[] arr = {'g', 'g', 'g', 'b'};

        System.out.println("The first bad version is found at : " + getBadVersion(arr));
    }

    private static int getBadVersion(char[] arr) {
        if( arr== null || arr.length == 0){
            return -1;
        }
        int index = -1;
        int start = 0;
        int end = arr.length -1;

        while(start <= end ){
            int mid = start + (end - start)/2;
            if(arr[mid] == 'b'){
                index = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return index;
    }
}
