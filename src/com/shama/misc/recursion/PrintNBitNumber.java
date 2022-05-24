package com.shama.misc.recursion;

import java.util.ArrayList;

public class PrintNBitNumber {

    public static void main(String[] args) {
        System.out.println(NBitBinary(4)); // [111, 110, 101]
    }

    static ArrayList<String> NBitBinary(int n) {
        ArrayList<String> res=new ArrayList<>();
        solve(res,"",n,0,0);
        return res;
    }

    static void solve(ArrayList<String> res, String output, int n, int ones, int zeros) {
        if(n == 0) {
            res.add(output);
            return;
        }
        solve(res,output+"1",n-1,ones+1, zeros);
        if(ones > zeros)
            solve(res,output+"0",n-1, ones,zeros+1);
    }
}
