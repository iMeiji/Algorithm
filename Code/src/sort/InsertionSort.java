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
        Integer[] arr = new Integer[]{22, 33, 11, 25, 1, -2, 66};
        System.out.println("init = " + Arrays.toString(arr));
        Integer[] result = is.insertionSort(arr);
        System.out.println("result = " + Arrays.toString(result));
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
     * init = [22, 33, 11, 25, 1, -2, 66]
     * 内层第一遍循环[22, 33]
     * break : j = 1 [22, 33, 11, 25, 1, -2, 66]（插入完毕）
     * 内层第二遍循环[22, 33, 11]
     * j = 2 [22, 11, 33, 25, 1, -2, 66]（11向前挪）
     * j = 1 [11, 22, 33, 25, 1, -2, 66]（11向前挪）
     * 内层第三遍循环[11, 22, 33, 25]
     * j = 3 [11, 22, 25, 33, 1, -2, 66]（25向前挪）
     * break : j = 2 [11, 22, 25, 33, 1, -2, 66]（插入完毕）
     * 内层第四遍循环[11, 22, 25, 33, 1]
     * j = 4 [11, 22, 25, 1, 33, -2, 66]（1向前挪）
     * j = 3 [11, 22, 1, 25, 33, -2, 66]（1向前挪）
     * j = 2 [11, 1, 22, 25, 33, -2, 66]（1向前挪）
     * j = 1 [1, 11, 22, 25, 33, -2, 66]（1向前挪）
     * 内层第五遍循环[1, 11, 22, 25, 33, -2]
     * j = 5 [1, 11, 22, 25, -2, 33, 66]（-2向前挪）
     * j = 4 [1, 11, 22, -2, 25, 33, 66]（-2向前挪）
     * j = 3 [1, 11, -2, 22, 25, 33, 66]（-2向前挪）
     * j = 2 [1, -2, 11, 22, 25, 33, 66]（-2向前挪）
     * j = 1 [-2, 1, 11, 22, 25, 33, 66]（-2向前挪）
     * 内层第六遍循环[-2, 1, 11, 22, 25, 33, 66]
     * break : j = 6 [-2, 1, 11, 22, 25, 33, 66]（插入完毕）
     * <p>
     * 时间复杂度
     * O(n^2)
     *
     * @param arr
     * @param <T>
     * @return
     */
    private <T extends Comparable<? super T>> T[] insertionSort(T[] arr) {
        int len = arr.length;
        // 注意判断条件 i < len - 1，因为要取出下一个元素与已经排序数组比较
        for (int i = 0; i < len - 1; i++) {
            // 从后向前扫描，j = i + 1 是取出下一个元素的下角标
            for (int j = i + 1; j > 0; j--) {
                // arr[j] 为要插入的元素
                int compare = arr[j - 1].compareTo(arr[j]);
                // 原来排序数组里从最大的数开始 和 要插入的元素 作比较
                // 如果最大的数 <= 要插入的元素，则跳出循环
                if (compare <= 0) {
                    System.out.println("break : " + "j = " + j + " " + Arrays.toString(arr));
                    break;
                }
                // 如果最大的数 > 要插入的元素，交换位置
                T temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                System.out.println("j = " + j + " " + Arrays.toString(arr));
            }
            System.out.println();
        }
        return arr;
    }
}
