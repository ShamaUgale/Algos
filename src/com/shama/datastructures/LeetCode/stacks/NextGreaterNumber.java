package com.shama.datastructures.LeetCode.stacks;
import java.util.Stack;

public class NextGreaterNumber {

    // https://www.youtube.com/watch?v=rSf9vPtKcmI

    public static void main(String[] args) {
        long[] arr =  {1,3,0,0,1,2,4};
        long[] result = nextLargerElementToRight(arr, arr.length);
        System.out.println("To Right");
        display(result);

        System.out.println("To Left");
        result = findNextGreaterNumberToLeft(arr, arr.length);
        display(result);
    }

    private static void display(long[] result) {
        StringBuilder sb = new StringBuilder();
        for(long i : result){
           sb.append(i + "  ");
        }

        System.out.println(sb.toString());
    }

    private static long[] findNextGreaterNumberToLeft(long[] arr, int n) {
        long[] result = new long[n];
        Stack<Long> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            if(stack.isEmpty()){
                result[i]= -1;
            }
            else if(!stack.isEmpty() && stack.peek() > arr[i]){
                result[i]=stack.peek();
            }
            else if(!stack.isEmpty() && stack.peek() <= arr[i]){
                while(!stack.isEmpty() && stack.peek() <= arr[i]){
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

    public static long[] nextLargerElementToRight(long[] arr, int n) {
        long[] result = new long[n];
        Stack<Long> stack = new Stack<>();

        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty()){
                result[i]= -1;
            }
            else if(!stack.isEmpty() && stack.peek() > arr[i]){
                result[i]=stack.peek();
            }
            else if(!stack.isEmpty() && stack.peek() <= arr[i]){
                while(!stack.isEmpty() && stack.peek() <= arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    result[i]= -1;
                }else{
                    result[i]=stack.peek();
                }
            }
            stack.push(arr[i]);
        }

        return result;
    }
}
