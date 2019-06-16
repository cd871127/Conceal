package io.github.cd871127.conceal.sort;

public class SortFactory {


    static public Sort getSort(SortType sortType) {
        Sort sort;
        switch (sortType) {
            case QUICK_SORT:
                sort = new QuickSort();
                break;
            case BUBBLE_SORT:
                sort = new BubbleSort();
                break;
            case SELECTION_SORT:
                sort = new SelectionSort();
                break;
            case INSERTION_SORT:
                sort = new InsertionSort();
                break;
            default:
                sort = new QuickSort();
        }
        return sort;
    }

    static public Sort getSort() {
        return getSort(SortType.QUICK_SORT);
    }

    public enum SortType {
        QUICK_SORT, BUBBLE_SORT, SELECTION_SORT, INSERTION_SORT
    }
}
