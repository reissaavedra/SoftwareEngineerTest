package com.example.restservice;

import java.util.List;

public class HeapSortedArray {
    List<Integer> array;

    public HeapSortedArray(List<Integer> array) {
        this.array = heapSort(array);
    }

    private List<Integer> heapSort(List<Integer> unsortedArray){
        int n = unsortedArray.size();
        // Construir heap (reorganizar array)
        for (int i = n/2 - 1; i >= 0; i--)
            heapify(unsortedArray, n, i);
        // Extraer un elemento desde heap uno por uno
        for (int i = n - 1; i > 0; i--) {
            // Mover actual nodo al final
            int temp = unsortedArray.get(0);
            unsortedArray.set(0, unsortedArray.get(i));
            unsortedArray.set(i, temp);
            // Llamar a máximo heapify sobre el reducido heap
            heapify(unsortedArray, i, 0);
        }
        return unsortedArray;
    }

    private void heapify(List<Integer> list, int n, int i){
        int largest = i; // Inicializamos número más alto como raíz
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Si el nodo hijo de la izquierda es más grande que el número más alto
        if (left < n && list.get(left) > list.get(largest)) largest = left;

        // Si el nodo hijo de la derecha es más grande que el número más alto
        if (right < n && list.get(right) > list.get(largest)) largest = right;

        // Si el número más grande no es nodo raíz
        if (largest != i) {
            int swap = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, swap);
            // Llamamos al método recursivamente
            heapify(list, n, largest);
        }
    }

    public List<Integer> getArray() {
        return array;
    }
}
