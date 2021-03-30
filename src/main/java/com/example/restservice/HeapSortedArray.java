package com.example.restservice;

import java.util.List;

public class HeapSortedArray {
    List<Integer> array;

    public HeapSortedArray(List<Integer> array) {
        this.array = sort(array);
    }

    private List<Integer> sort(List<Integer> arr){
        int n = arr.size();

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
        return arr;
    }

    void heapify(List<Integer> arr, int n, int i){
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr.get(l) > arr.get(largest)) largest = l;

        // If right child is larger than largest so far
        if (r < n && arr.get(r) > arr.get(largest)) largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, swap);
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public List<Integer> getArray() {
        return array;
    }
}
