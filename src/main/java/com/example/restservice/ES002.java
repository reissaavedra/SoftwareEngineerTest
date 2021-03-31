package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

public class ES002 {
    ArrayList<Integer> parameter;

    public ES002(ArrayList<Integer> parameter) {
        this.parameter = parameter;
    }

    public ArrayList<Integer> solve(){
//        ArrayList<Integer> arrayInputedValues = CompletedArray.solve(CompletedArray.fill0(parameter, CompletedArray.getLargest(parameter)));
        HeapSortedArray heapSortedArray = new HeapSortedArray(parameter);
        ArrayList<Integer> arrayInputedValues = CompletedArray.solve((ArrayList<Integer>) heapSortedArray.getArray());

//        HeapSortedArray heapSortedArray = new HeapSortedArray(parameter);
        return arrayInputedValues;
    }
}
