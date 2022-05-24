package com.shama.misc.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateBalancedParenthesis {

    public static void main(String[] args) {
        System.out.println(generateValidParenthesis(5));
    }

    public static List<String> generateValidParenthesis(int n) {
        // Write your code here,
        List<String> res = new ArrayList<>();
        solve("",n,n,res);
        return res;
    }

    static void solve(String str, int openBracket, int closingBracket, List<String> res)
    {
        if(openBracket == 0 && closingBracket == 0) {
            res.add(str);
            return;
        }

        if(openBracket == closingBracket) {
            solve(str+"(",openBracket-1, closingBracket, res);
        }
        else {
            if(openBracket > 0) {
                solve(str+"(",openBracket-1,closingBracket,res);
            }
            if(closingBracket>0) {
                solve(str+")",openBracket,closingBracket-1,res);
            }
        }
    }
}
