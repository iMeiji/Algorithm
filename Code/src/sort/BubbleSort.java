package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author Meiji
 */
public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        Integer[] arr = new Integer[]{5, 7, 1, 9, 1, -2};
        System.out.println("init = " + Arrays.toString(arr));
        bubbleSort.bubbleSort(arr);
        System.out.println("result = " + Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * 冒泡排序可以算最经典的排序算法，实现方法也是非常简单，两层 for 循环，内层循环中判断相邻两个元素是否逆序，是的话交换两个元素
     * 外层循环执行一次，就能将数组中剩下的元素中最小的元素“浮”到最前面，所以称之为冒泡排序
     * <p>
     * init = [5, 7, 1, 9, 1, -2]
     * <p>
     * [5, 1, 7, 9, 1, -2]
     * [5, 1, 7, 1, 9, -2]
     * [5, 1, 7, 1, -2, 9]
     * <p>
     * [1, 5, 7, 1, -2, 9]
     * [1, 5, 1, 7, -2, 9]
     * [1, 5, 1, -2, 7, 9]
     * <p>
     * [1, 1, 5, -2, 7, 9]
     * [1, 1, -2, 5, 7, 9]
     * <p>
     * [1, -2, 1, 5, 7, 9]
     * <p>
     * [-2, 1, 1, 5, 7, 9]
     * result = [-2, 1, 1, 5, 7, 9]
     * </p>
     * 时间复杂度
     * O(n^2)
     *
     * @param arr
     * @param <T>
     * @return
     */
    private <T extends Comparable<? super T>> void bubbleSort(T[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return;
        }

        for (int i = 0; i < len; i++) {
            // 提前退出标志位
            boolean flag = false;
            for (int j = 0; j < len - i - 1; j++) {
                /**
                 * 比较后者（j+1）与前者（j）的关系
                 * 如果后者比前者小就交换
                 */
                int compare = arr[j].compareTo(arr[j + 1]);
                if (compare > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    // 此次冒泡有数据交换
                    flag = true;
                    System.out.println(Arrays.toString(arr));
                }
            }
            // 没有数据交换，提前退出
            if (!flag) {
                break;
            }
        }
    }
}