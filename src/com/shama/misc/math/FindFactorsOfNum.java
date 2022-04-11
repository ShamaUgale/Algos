package com.shama.misc.math;

public class FindFactorsOfNum {

    public static void main(String[] args) {
        int f = 9;
        printFactorsOf(f);
    }

    private static void printFactorsOf(int f) {
        for(int i=1; i<=Math.sqrt(f);i++){
            if(f%i == 0){
                if((f/i)== i){
                    System.out.print(i + " ");
                }else {
                    System.out.print(i + " ");
                    System.out.print(f / i + " ");
                }
            }
        }
    }
}
