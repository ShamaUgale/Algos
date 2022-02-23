package com.shama.datastructures.LeetCode.stacks;
import java.util.Stack;

public class NextGreaterNumber {

    // https://www.youtube.com/watch?v=rSf9vPtKcmI

    public static void main(String[] args) {
        int[] arr =  {8,4,5,6,7,2};
        int[] result = findNextGreaterNumberToRight(arr);
        display(result);
    }

    private static void display(int[] result) {
        StringBuilder sb = new StringBuilder();
        for(int i : result){
           sb.append(i + "  ");
        }

        System.out.println(sb.toString());
    }

    private static int[] findNextGreaterNumberToRight(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();

        int[] res = new int[arr.length];

        stack.push(arr[arr.length-1]); /// pushed last elem of arr to stack
        arr[arr.length-1] = -1; // and marked it as -1

        for(int i = arr.length-2; i>=0; i--){
            // unless stack is not empty and the number is greater that the ith elem
            // 1. pop
            // get the ans
            // 3. add that elem to stack

            while(stack.size()>0 && arr[i]>= stack.peek()){
                stack.pop();
            }

            if(stack.size() == 0){
                res[i] = -1;
            }else{
                res[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return res;
    }

    // time complexity is O(n)


}
