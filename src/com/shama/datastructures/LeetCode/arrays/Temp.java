package com.shama.datastructures.LeetCode.arrays;


import java.util.*;

public class Temp {

    public static void main(String[] args) {
        firstNegativeIntegerInWindowOfSizeK();
        System.out.println("*****");
        MaxIntegerInWindowOfSizeK();
    }

    public static int[] firstNegativeIntegerInWindowOfSizeK() {
        int[] arr = new int[]{12, -1, -7, 8, -4, 5, 0, 2};
        int K = 3;
        int start = 0, end = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        while (end < arr.length) {

            if (arr[end] < 0)
                queue.add(arr[end]);

            if (end - start + 1 < K)
                end++;
            else if (end - start + 1 == K) {
                if (queue.isEmpty()) {
                    result.add(0);
                    System.out.println(0);
                } else {
                    result.add(queue.peek());
                    System.out.println(queue.peek());
                }
                if (!queue.isEmpty() && arr[start] == queue.peek())
                    queue.remove();
                start++;
                end++;
            }
        }
        return new int[result.size()];
    }

    public static void MaxIntegerInWindowOfSizeK() {
        int[] arr = {12, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;
        // create a priority queue which stores the maximum element at the front end
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int i;
        // add first k numbers in the priority queue
        for (i = 0; i < k; i++)
            priorityQueue.add(arr[i]);

        // print the maximum number in the first subarray with size k
        System.out.print(priorityQueue.peek() + " ");

        // remove the first element from priority queue
        priorityQueue.remove(arr[0]);

        // add one element in every iteration and find the maximum element
        for (; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
            System.out.print(priorityQueue.peek() + " ");
            priorityQueue.remove(arr[i - k + 1]);
        }
    }
}