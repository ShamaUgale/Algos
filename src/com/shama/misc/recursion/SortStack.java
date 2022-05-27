package com.shama.misc.recursion;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(5);
        st.push(1);
        st.push(0);
        st.push(9);
        st.push(6);
        st.push(7);
        st.push(5);

        sortedStack(st);
        System.out.println(st);

    }

    private static Stack<Integer> sortedStack(Stack<Integer> st) {
        // Base condition
        if (st.size() == 1) {
            return st;
        }
        Integer topEl = st.pop();
        // Hypotheses
        sortedStack(st);

        // Induction
        return insertElementAt(st, topEl);
    }

    private static Stack<Integer> insertElementAt(Stack<Integer> st, Integer el) {
        // Base condition
        if (st.size() == 0 || st.peek() <= el) {
            st.push(el);
            return st;
        }

        Integer topEl = st.pop();
        // Hypotheses
        insertElementAt(st, el);

        // Induction
        st.push(topEl);
        return st;
    }
}

