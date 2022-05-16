package com.shama.datastructures.LeetCode.stacks;
/*
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock
and we need to calculate span of stock’s price for all n days.

The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days
just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.

For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 */
public class StockSpan {

    // this prob is deduced to greater number to left

    // we will keep track on the index
    public static void main(String[] args) {
        int[] array =  {100, 80, 60, 70, 60, 75, 85};
        Stack<Integer> stack = new Stack();
        int[] result = new int[array.length];

        result[0] = 1;
        stack.push(0);
        for (int i = 1; i < array.length; i++) {

            while(!stack.isEmpty() && array[i] >= array[stack.peek()])
                stack.pop();

            result[i] = stack.isEmpty() ? i+1 : i - stack.peek();

            stack.push(i);
        }

        for(int i=0; i< result.length; i++){
            System.out.print(result[i] + "  ");
        }

    }
}
