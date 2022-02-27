package com.shama;

public class Test {

    public static int countSubsequences(String line) {
        // TODO -- write your code here, and remember to return the
        // count
        int l = line.length();
        int cnt=0;
        char c = ' ';

        for(int i =0; i<l; i++)
        {

            if((i+1) >= line.length())
            {
                break;
            }else
            {
                if(c!=line.charAt(i+1))
                {
                    if(line.charAt(i)==line.charAt(i+1))
                    {
                        cnt++;
                        c = line.charAt(i);
                    }
                }
            }

        }


        return cnt;
    }


    public static void main(String[] args) {
        System.out.println(countSubsequences("aabbc"));
    }
}
