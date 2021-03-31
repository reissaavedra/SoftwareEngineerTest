package com.example.restservice;

import java.util.*;

public class CompletedArray {

    private static int getLargest(ArrayList<Integer> arr) {
        int max = 0;
        for (int i = 1, len = arr.size(); i < len; i++){
            if (arr.get(i) > max){
                max = arr.get(i);
            }
        }
        return max;
    }

    public static ArrayList solve(ArrayList<Integer> arr){
        int initialValue = 1;
        for(int i = 0; i < getLargest(arr);i++){
            if(i != 0) {
                if(arr.get(i) - arr.get(i - 1) != 1){
                    arr.add(i, i+1);
                }
            }
            else{
                if (arr.get(i) != 1) {
                    arr.add(i, initialValue);
                }
            }
        }
        return arr;
    }
}
