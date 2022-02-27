package com.shama.datastructures.LeetCode.stacks;

import java.util.Stack;

public class NextSmallerElement {


    // https://www.youtube.com/watch?v=rSf9vPtKcmI

    public static void main(String[] args) {
        long[] arr =  {4,5,2,10,8};
        long[] result = nextSmallerElementToRight(arr, arr.length);
        System.out.println("To Right");
        display(result);

        System.out.println("To Left");
        result = nextSmallerNumberToLeft(arr, arr.length);
        display(result);
    }

    private static void display(long[] result) {
        StringBuilder sb = new StringBuilder();
        for(long i : result){
            sb.append(i + "  ");
        }

        System.out.println(sb.toString());
    }

    private static long[] nextSmallerNumberToLeft(long[] arr, int n) {
        long[] result = new long[n];
        java.util.Stack<Long> stack = new java.util.Stack<>();

        for(int i = 0; i < n; i++){
            if(stack.isEmpty()){
                result[i]= -1;
            }
            else if(!stack.isEmpty() && stack.peek() < arr[i]){
                result[i]=stack.peek();
            }
            else if(!stack.isEmpty() && stack.peek() >= arr[i]){
                while(!stack.isEmpty() && stack.peek() >= arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    result[i]= -1;
                }
                else{
                    result[i]=stack.peek();
                }
            }
            stack.push(arr[i]);
        }

        return result;
    }

    // time complexity is O(n)

    public static long[] nextSmallerElementToRight(long[] arr, int n) {
        long[] result = new long[n];
        java.util.Stack<Long> stack = new Stack<>();

        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty()){
                result[i]= -1;
            }
            else if(!stack.isEmpty() && stack.peek() < arr[i]){
                result[i]=stack.peek();
            }
            else if(!stack.isEmpty() && stack.peek() >= arr[i]){
                while(!stack.isEmpty() && stack.peek() >= arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    result[i]= -1;
                }
                else{
                    result[i]=stack.peek();
                }
            }
            stack.push(arr[i]);
        }

        return result;
    }
}
