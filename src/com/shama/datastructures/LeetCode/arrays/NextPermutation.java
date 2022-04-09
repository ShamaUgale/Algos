package com.shama.datastructures.LeetCode.arrays;

public class NextPermutation {

    public static void main(String[] args) {
        // traverse from last elem
        // find the elem which is smaller than its next elem ( to right)
        // store that elem's index as idx1
        // now again traverse the arr from last
        // this time find an elem from last which is greater than the elem on idx1
        // store this index now as idx2
        // swap elems at id1 and idx2

        //now reverse the array from the elem next to idx1 to end of array
        // thats my final next permutation
    }
}
