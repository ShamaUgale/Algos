package com.shama.misc.recursion;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(5);
        st.push(1);
        st.push(0);
        st.push(9);
        st.push(6);
        st.push(7);
        st.push(5);

        reverse(st);
        System.out.println(st);
    }
    static void reverse(Stack<Integer> stk ){
        if(stk.size()==1)
            return;
        int temp=stk.pop();
        reverse(stk);
        pushInStack(stk,temp);
    }

    static void pushInStack(Stack<Integer> stk, int temp){
        if(stk.size()==0){
            stk.push(temp);
            return;
        }else{
            int value=stk.pop();
            pushInStack(stk,temp);
            stk.push(value);
            return;
        }
    }
}
