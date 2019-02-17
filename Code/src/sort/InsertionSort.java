package sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author Meiji
 */
public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        Integer[] arr = new Integer[]{5, 7, 1, 9, 1, -2};
        System.out.println("init = " + Arrays.toString(arr));
        is.insertionSort(arr);
        System.out.println("result = " + Arrays.toString(arr));
    }

    /**
     * 插入排序（英语：Insertion Sort）是一种简单直观的排序算法。
     * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     * 从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
     * <p>
     * 具体算法描述如下：
     * <p>
     * 1.从第一个元素开始，该元素可以认为已经被排序
     * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 5.将新元素插入到该位置后
     * 6.重复步骤2~5
     * <p>
     * init = [5, 7, 1, 9, 1, -2]
     * [5, 7, 1, 9, 1, -2]
     * [1, 5, 7, 9, 1, -2]
     * [1, 5, 7, 9, 1, -2]
     * [1, 1, 5, 7, 9, -2]
     * [-2, 1, 1, 5, 7, 9]
     * result = [-2, 1, 1, 5, 7, 9]
     * <p>
     * 时间复杂度
     * O(n^2)
     *
     * @param arr
     * @param <T>
     * @return
     */
    private <T extends Comparable<? super T>> void insertionSort(T[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return;
        }

        for (int i = 1; i < len; i++) {
            T value = arr[i];
            int j = i - 1;
            // 查找要插入的位置并移动数据
            for (; j >= 0; j--) {
                int compare = arr[j].compareTo(value);
                if (compare > 0) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
            System.out.println(Arrays.toString(arr));
        }
    }
}
