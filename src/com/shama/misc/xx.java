package com.shama.misc;

public class xx {

    public static void main(String[] args) {
        int ret1[] = foo(8);

        for(Integer x : ret1){
            System.out.println(x);
        }
    }

    private static int[] foo(int num){
        int ret[] = new int[num+1];
        ret[0] =0;
        int bar = 1;
        for(int i=1, t=0; i<= num ; i++ , t++ ){
            if(i==bar){
                bar*= 2;
                t=0;
            }
            ret[i] = ret[t] + 1;
        }
        return ret;
    }
}
