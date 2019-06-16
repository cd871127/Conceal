package io.github.cd871127.conceal.sort;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        testSingleSort();
//        testPerformance();
    }

    private static int[] data() {
        int min = 1;
        int max = 1000000;
        int arrayLength = 50000;

        Set<Integer> numSet = new HashSet<>();
        while (numSet.size() < arrayLength) {
            numSet.add((int) (min + Math.random() * (max - min + 1)));
        }
        int[] arr = new int[arrayLength];
        ArrayList<Integer> list = new ArrayList<>(numSet);
        for (int i = 0; i != arrayLength; ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private static void testSingleSort() {
        Sort sort = SortFactory.getSort(SortFactory.SortType.QUICK_SORT);
        int[] arr = {5, 2, 7, 9, 1, 0, 11, 3, 1};
//        arr = data();
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(check(arr, arr));
    }

    private static void testPerformance() {
        int[] arr = data();
        for (SortFactory.SortType sortType : SortFactory.SortType.values()) {
            Sort sort = SortFactory.getSort(sortType);

            int[] tmp = new int[arr.length];
            System.arraycopy(arr, 0, tmp, 0, arr.length);

            long start = System.currentTimeMillis();
            sort.sort(tmp);
            long end = System.currentTimeMillis();
            System.out.println(sortType + " " + check(tmp, arr) + " " + (end - start));
        }
    }

    private static boolean check(int[] arr, int[] ori) {
        for (int i = 0; i != arr.length - 1; ++i) {
            if (arr[i] > arr[i + 1])
                return false;
        }
        if (new HashSet<>(Collections.singletonList(arr)).size() != new HashSet<>(Collections.singletonList(ori)).size()) {
            return false;
        }

        return true;
    }
}
