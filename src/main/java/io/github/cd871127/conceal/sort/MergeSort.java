package io.github.cd871127.conceal.sort;

public class MergeSort implements Sort {
    @Override
    public void sort(int[] array) {
        int[] tmp = new int[array.length];

        mergeSort(array, 0, array.length, tmp);
    }

    public void mergeSort(int[] array, int begin, int end, int[] tmp) {
        if (begin >= end) {
            return;
        }
        int mid = (begin + end) / 2;
//        merge()

    }

//    public int[] merge(int[] arr1, int[] arr2) {
//
//    }

}
