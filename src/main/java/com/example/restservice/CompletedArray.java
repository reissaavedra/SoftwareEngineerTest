package com.example.restservice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CompletedArray {
    
    static ArrayList solve(ArrayList<Integer> arr){
        int n = arr.size();
        Set<Integer> unfilled_indices = new HashSet<>();
        Set<Integer> missing = new HashSet<>();

        for (int i = 1; i < n; i++){
            missing.add(i);
        }
        for (int i = 1; i < n; i++) {
            if (arr.get(i) == 0){
                unfilled_indices.add(i);
            }
            else{
                missing.remove(arr.get(i));
            }
        }
        int[] mi = new int[missing.size()];
        int l = 0;
        for(int x:missing){
            mi[l++] = x;
        }
        int m = missing.size();
        
        for(int it:unfilled_indices){
            arr.set(it, mi[m - 1]);
            m--;
        }
        int pos = 0;
        
        for (int i = 1; i < n; i++){
            if (arr.get(i) == i){
                pos = i;
            }
        }
        int x;
        
        if (pos != 0){
            for (int i = 1; i < n; i++){
                if (pos != i){
                    if(unfilled_indices.contains(i)){
                        x = arr.get(i);
                        arr.set(i, pos);
                        arr.set(pos, x);
                        break;
                    }
                }
            }
        }
        return arr;
    }

    public static int getMayor(ArrayList<Integer> arr) {
        int max = 0;
        for (int i = 1; i < arr.size(); i++){
            if (arr.get(i) > max){
                max = arr.get(i);
            }
        }
        return max;
    }

    public static ArrayList fill0(ArrayList arr, int max) {
        int len = arr.size();
        if(len < max){
            for (int i = len; i < max; i++){
                arr.add(0);
            }
        }
        return arr;
    }
}
