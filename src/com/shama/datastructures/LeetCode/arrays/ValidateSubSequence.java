package com.shama.datastructures.LeetCode.arrays;

public class ValidateSubSequence {

    public static void main(String[] args) {
        int[] arr = {5,1,22,25,6,-1,8,10};
        int[] subSequence = {};
        int arrIndex =0;
        int sequenceIndex =0;
       while(arrIndex < arr.length && sequenceIndex < subSequence.length){
           if(arr[arrIndex] == subSequence[sequenceIndex]){
               sequenceIndex++;
           }

           arrIndex++;
       }
       boolean isSubsequence = sequenceIndex == subSequence.length;

       if(isSubsequence){
           System.out.println("Yes , is  vaild subsequence");
       }else{
           System.out.println("Not a valid subsequence");
       }

    }
}
