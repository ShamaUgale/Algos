package com.shama.misc;

public class IntegerToRoman {

    public static void main(String[] args) {
        String roman = intToRoman(0100);
        System.out.println("Roman representative of " + 100 + " is : " + roman);
    }

    public static String intToRoman(int num) {
        String thousands[] = {"", "M", "MM", "MMM"};
        String hundreds[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String tens[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String units[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[num/1000] + hundreds[(num%1000)/100] + tens[(num%100)/10] + units[num%10];
    }
}
