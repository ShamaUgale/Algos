package com.shama.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*

Sort Names by their Last Names.
May 8, 2015 by Sumit Jain
Objective: Given a list of names ( first name and last name), sort the list by their last names.

Example:

List [] = {"Daenerys Targaryen", "Jon Snow", " Tyrion Lannister", " Joffrey Baratheon"}

Output: [Joffrey Baratheon, Tyrion Lannister, Jon Show, Daenerys Targaryen]
Approach:

We have sort() and Collections.sort() but we cannot do the normal sorting because we need to sort it using the Last Names.
These sort() methods uses compare method of Comparator class to sort the data so we need to override the compare().
Inside the compare(), we need to split the name (First Name and Last Name) and compare the last names.

 */
public class SortUsingLastNames {

    public void sortLast(ArrayList<String> al) {
        Collections.sort(al, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] split1 = o1.split(" ");
                String[] split2 = o2.split(" ");
                String lastName1 = split1[1];
                String lastName2 = split2[1];
                if (lastName1.compareTo(lastName2) > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        System.out.println(al);
    }

    public void sortLast(String[] arr) {
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] split1 = o1.split(" ");
                String[] split2 = o2.split(" ");
                String lastName1 = split1[1];
                String lastName2 = split2[1];
                if (lastName1.compareTo(lastName2) > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
       for(String s : arr){
           System.out.print(s + "    ");
       }
    }

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("Daenerys Targaryen");
        al.add("Jon Show");
        al.add("Tyrion Lannister");
        al.add("Joffrey Baratheon");
        SortUsingLastNames sorting = new SortUsingLastNames();
        System.out.println("Sorted using Last Name");
        sorting.sortLast(al);

        System.out.println();

        String arr[] = {"Shama Ugale", "Aarush Ugale", "Akhil Gore", "Ash Desai", "Sharad desai"};
        sorting.sortLast(arr);
    }

}
