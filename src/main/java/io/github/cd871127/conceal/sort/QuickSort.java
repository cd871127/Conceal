package io.github.cd871127.conceal.sort;


public class QuickSort implements Sort {


    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int idx = partition(array, begin, end);

        quickSort(array, begin, idx - 1);
        quickSort(array, idx + 1, end);
    }

    private int partition(int[] array, int begin, int end) {
        int tmp = array[begin];

        while (begin < end) {
            while (end > begin && tmp <= array[end]) {
                --end;
            }
            if (begin < end) {
                array[begin] = array[begin] ^ array[end];
                array[end] = array[begin] ^ array[end];
                array[begin] = array[begin] ^ array[end];
            }
            while (end > begin && tmp >= array[begin]) {
                ++begin;
            }
            if (begin < end) {
                array[begin] = array[begin] ^ array[end];
                array[end] = array[begin] ^ array[end];
                array[begin] = array[begin] ^ array[end];
            }
        }
        return begin;
    }

}
