package com.shama.datastructures.LeetCode.heap;

import java.util.PriorityQueue;

public class ConectRopesToMinimizeCost {

    public static void main(String[] args) {
            int[] arr=new int[] {2,3,4,1,5};

            PriorityQueue<Integer> heap=new PriorityQueue<>();
            int ans=0;
            for(int x:arr){
                heap.add(x);
            }


            while(heap.size()!=1){
                int x1=heap.poll();
                int x2=heap.poll();

                int temp=x1+x2;
                ans+=temp;
                heap.add(temp);
            }
            System.out.println(ans);
        }
    }

