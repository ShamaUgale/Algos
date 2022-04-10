package com.shama.datastructures.LeetCode.stacks;
/*

Find the largest rectangular area possible in a given histogram
where the largest rectangle can be made of a number of contiguous bars.

For simplicity, assume that all bars have same width and the width is 1 unit.
For example, consider the following histogram with 7 bars of heights {6, 2, 5, 4, 5, 1, 6}.
The largest possible rectangle possible is 12 (see the below figure, the max area rectangle is highlighted in red)

https://www.geeksforgeeks.org/largest-rectangle-under-histogram/

 */
public class MaxAreaHistogram {

    // 1. get the nearest smaller at right
    // 2. get the nearest smaller at left
    // 3. find width array - width[i] = right[i] - left[i] +1
    // 4. area is width[i] * arr[i]
    // 5. find max in area array

    public static long getMaxArea(long arr[], long n)
    {
        // your code here
        long right[]= new long[arr.length];
        long left[]= new long[arr.length];
        long res=1; // find the max area
        Stack<Integer> s = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        //NEAREST SMALLER TO left
        for (int i = 0; i < arr.length; i++) {
            if (s.isEmpty()) {
                left[i]=-1;
            } else if (arr[s.peek()] < arr[i]) {
                left[i]= s.peek();
            } else if (arr[s.peek()] >= arr[i]) {
                while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    left[i]=-1;
                } else {
                    left[i] = s.peek();
                }
            }
            s.push(i);
        }

        // NEAEREST SMALLER TO RIGHT
        for (int i = arr.length-1; i >=0; i--) {
            if (s2.isEmpty()) {
                right[i]=arr.length;
            } else if (arr[s2.peek()] < arr[i]) {
                right[i]= s2.peek();
            } else if (arr[s2.peek()] >= arr[i]) {
                while (!s2.isEmpty() && arr[s2.peek()] >= arr[i]) {
                    s2.pop();
                }
                if (s2.isEmpty()) {
                    right[i]=arr.length;
                } else {
                    right[i] = s2.peek();
                }
            }
            s2.push(i);
        }
        //calculate width= index of right - index of left -1
        long width[] = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            width[i] = right[i]-left[i]-1;
        }
        //calculating max area  element * width
        for (int i = 0; i < width.length; i++) {
            res = Math.max(res, arr[i]*width[i]);
        }
        return res;
    }
}
