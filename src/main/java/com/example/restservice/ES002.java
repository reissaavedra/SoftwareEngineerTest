package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

public class ES002 {
    ArrayList<Integer> parameter;

    public ES002(ArrayList<Integer> parameter) {
        this.parameter = parameter;
    }

    public ArrayList<Integer> solve(){
        HeapSortedArray heapSortedArray = new HeapSortedArray(parameter);
        ArrayList<Integer> arrayInputedValues = CompletedArray.solve((ArrayList<Integer>) heapSortedArray.getArray());
        return arrayInputedValues;
    }
}
