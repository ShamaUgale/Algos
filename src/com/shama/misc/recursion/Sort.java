package com.shama.misc.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Sort {
        public static void main(String[] args) {
            ArrayList arr = new ArrayList(
                    Arrays.asList(3,2,1,4,5,6,7)
            );
            arr = sort(arr);
            System.out.println(arr);

        }
        public static ArrayList sort(ArrayList arr){
            if(arr.size()==1){
                return arr;
            }
            int temp = (int)arr.get(arr.size()-1);
            arr.remove(arr.size()-1);
            arr = sort(arr);
            arr  = insert(arr,temp);
            return arr;
        }
        public static ArrayList insert(ArrayList arr,int temp){
            if(arr.size()==0 ){//|| (int)arr.get(arr.size()-1)temp){
                arr.add(temp);
                return arr;
            }else if((int)arr.get(0)>=temp){
                arr.add(0,temp);
                return arr;
            }else if((int)arr.get(arr.size()-1)<=temp){
                arr.add(arr.size(),temp);
                return arr;
            }
            int temp1 =(int) arr.get(arr.size()-1);
            arr.remove(arr.size()-1);
            arr = insert(arr,temp);
            arr.add(arr.size(),temp1);
            return arr;
        }
}
