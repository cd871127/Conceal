package io.github.cd871127.conceal.sort;

public class SelectionSort implements Sort {
    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            int minPos = i;
            for (int j = i + 1; j < array.length; ++j) {
                if (array[j] < array[minPos]) {
                    minPos = j;
                }
            }
            if (minPos != i) {
                array[i] = array[i] ^ array[minPos];
                array[minPos] = array[i] ^ array[minPos];
                array[i] = array[i] ^ array[minPos];
            }
        }
    }

}
