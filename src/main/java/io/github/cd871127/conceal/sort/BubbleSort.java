package io.github.cd871127.conceal.sort;

public class BubbleSort implements Sort {
    @Override
    public void sort(int[] array) {
        boolean flag;
        do {
            flag = false;
            for (int idx = 0; idx + 1 < array.length; ++idx) {
                if (array[idx] > array[idx + 1]) {
                    array[idx] = array[idx] ^ array[idx + 1];
                    array[idx + 1] = array[idx] ^ array[idx + 1];
                    array[idx] = array[idx] ^ array[idx + 1];
//                    int tmp=array[idx];
//                    array[idx]=array[idx+1];
//                    array[idx+1]=tmp;
                    flag = true;
                }
            }
        } while (flag);
    }
}
