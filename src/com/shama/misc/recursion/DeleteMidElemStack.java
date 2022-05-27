package com.shama.misc.recursion;

import java.util.Stack;

public class DeleteMidElemStack {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(5);
        st.push(1);
        st.push(0);
        st.push(9);
        st.push(6);
        st.push(7);
        st.push(5);

        Stack<Integer> result = midDelete(st);
        System.out.println(result);
    }
    private static Stack<Integer> midDelete(Stack<Integer> st) {
        int midPos = (st.size() / 2) + 1;
        solve(st, midPos);
        return st;
    }

    private static void solve(Stack<Integer> stack, int midPos) {
        if (stack.size() == midPos) {
            stack.pop();
            return;
        }
        int temp = stack.pop();
        solve(stack, midPos);
        stack.push(temp);
    }
}
