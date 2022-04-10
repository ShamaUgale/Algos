package com.shama.datastructures.LeetCode.stacks;

import java.util.Stack;

public class StockSpan_AdityaVerma {

    // 1. get the left smaller elem's index
    // 2. then get the difference between the elem ind and smaller_to_left element index

    public static void main(String[] args) {
        int[] stocks = {100,80,60, 70, 60, 75, 85};

        int[] result = findNextGreaterNumberToLeft(stocks, stocks.length);
        for(Integer elem : result){
            System.out.print(elem + " ");
        }
    }

    private static int[] findNextGreaterNumberToLeft(int[] arr, int n) {
        int[] result = new int[n];
        java.util.Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){
            if(stack.empty()){
                result[i] =(1+i);
            }else if(arr[stack.peek()] > arr[i]){
                result[i] = i-stack.peek();
            }else if(arr[stack.peek()]<=arr[i]){
                while(!stack.empty() && arr[stack.peek()]<=arr[i]){
                    stack.pop();
                }
                if(stack.empty()){
                    result[i] = i+1;
                }
                else
                   result[i] = i-stack.peek();
            }
            stack.push(i);
        }
        return result;
    }
}