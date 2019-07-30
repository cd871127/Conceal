package io.github.cd871127.conceal.sort;

public class HeapSort implements Sort {
    @Override
    public void sort(int[] array) {

        for (int i = (array.length - 1) / 2; i >= 0; --i) {
            adjust(array, i, array.length);
        }

        for (int i = array.length - 1; i >= 0; --i) {
            swap(array, 0, i);
            adjust(array, 0, i);
        }

    }

    private void adjust(int[] array, int root, int length) {
        if (root >= length) {
            return;
        }
        int left = root * 2 + 1;
        int right = root * 2 + 2;

        int max = root;

        if (left < length && array[max] < array[left]) {
            max = left;
        }
        if (right < length && array[max] < array[right]) {
            max = right;
        }

        if (max != root) {
            swap(array, root, max);
            adjust(array, max, length);
        }

    }


    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
