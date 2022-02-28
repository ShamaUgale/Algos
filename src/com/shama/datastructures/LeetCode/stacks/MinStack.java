package com.shama.datastructures.LeetCode.stacks;

import java.util.Stack;

// with extra space
// Time complexity O(n)  ,  space complexity O(n)

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    MinStack(){
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val){
        if(stack.isEmpty()){
            minStack.push(val);
        }else if(!minStack.isEmpty() && minStack.peek() >= val){
            minStack.push(val);
        }
        stack.push(val);

    }

    public int pop(){
        int result = 0;
        if(stack.isEmpty()){
            return  -1;
        }else{
            result = stack.pop();
            if(result == minStack.peek()){
                minStack.pop();
            }
            return result;
        }
    }

    public int getMin(){
        if(minStack.isEmpty()){
            return -1;
        }else{
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(34);
        m.push(4);
        m.push(21);
        m.push(11);
        m.push(0);

        System.out.println(m.getMin());
    }
}
