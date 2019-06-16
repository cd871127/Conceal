package io.github.cd871127.conceal.sort;

public class InsertionSort implements Sort {
    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            //pos从i开始 下面的循环没有进去,就不动
            int tmp = array[i], pos = i;
            for (int j = i - 1; j >= 0 && tmp < array[j]; --j) {
                array[j + 1] = array[j];
                pos = j;
            }

            array[pos] = tmp;
        }
    }

}
