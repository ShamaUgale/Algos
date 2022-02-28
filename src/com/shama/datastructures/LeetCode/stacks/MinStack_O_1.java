package com.shama.datastructures.LeetCode.stacks;

import java.util.Stack;

// no extra space
public class MinStack_O_1 {


    Stack<Integer> stack;
    static int minElement = Integer.MAX_VALUE;

    MinStack_O_1(){
        this.stack = new java.util.Stack<>();
    }

    public void push(int val){
        if(stack.isEmpty()){
            stack.push(val);
            minElement = val;
        }else{
            if(val >= minElement){
                stack.push(val);
            }else if(val < minElement){
                stack.push(2*val - minElement);
                minElement = val;
            }
        }
    }

    public int pop(){
        int result = 0;
       if(stack.isEmpty()){
           return -1;
       }else{
           if(stack.peek() >= minElement){
               result = stack.pop();
           }else if(stack.peek() < minElement){
               minElement = 2*minElement - stack.peek();
               result = stack.pop();
           }
       }
        return result;
    }

    public int peek(){
        int result = 0;
        if(stack.isEmpty()){
            return -1;
        }else{
            if(stack.peek() >= minElement){
                result = stack.peek();
            }else if(stack.peek() < minElement){
                result =  minElement;
            }
        }
        return  result;
    }

    public int getMin(){
        if(stack.isEmpty()){
            return -1;
        }else{
            return minElement;
        }
    }

    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(34);
        m.push(4);
        m.push(21);
        m.push(11);
        m.push(0);

        m.pop();

        System.out.println(m.getMin());
    }

}
