package com.shama.misc.math;

public class Power {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0 || x == 1 || n == 1) {
            return x;
        }
        if (n < 0) {
            /**
             * -(n + 1) is done to avoid int overflow.
             */
            return (1 / x) * myPow(1 / x, -(n + 1));
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
