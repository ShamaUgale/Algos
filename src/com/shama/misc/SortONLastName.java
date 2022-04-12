package com.shama.misc;

import java.util.Arrays;

public class SortONLastName {

    public static void main(String[] args) {
        String[] str = { "Sam Foster",
                "Jack White",
                "John Abner",
                "Mike Briggs",
                "Sarah Mills" };

        Arrays.sort(str, (a,b) -> {
            return b.split("\\s+")[1].compareTo(a.split("\\s+")[1]);
        });

        System.out.println( Arrays.toString(str));
    }
}
