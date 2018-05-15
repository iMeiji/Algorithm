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
        Integer[] arr = new Integer[]{22, 33, 11, 25, 1, -2, 66};
        System.out.println("init = " + Arrays.toString(arr));
        Integer[] result = bubbleSort.bubbleSort(arr);
        System.out.println("result = " + Arrays.toString(result));
    }

    /**
     * 冒泡排序
     * 冒泡排序可以算最经典的排序算法，实现方法也是非常简单，两层 for 循环，内层循环中判断相邻两个元素是否逆序，是的话交换两个元素
     * 外层循环执行一次，就能将数组中剩下的元素中最小的元素“浮”到最前面，所以称之为冒泡排序
     * <p>
     * init = [22, 33, 11, 25, 1, -2, 66]
     * 内层第一遍循环
     * i = 0, j = 2 [11, 33, 22, 25, 1, -2, 66] (22 <-> 11)
     * i = 0, j = 4 [1, 33, 22, 25, 11, -2, 66] (11 <-> 1)
     * i = 0, j = 5 [-2, 33, 22, 25, 11, 1, 66] (1 <-> -2)
     * 内层第二遍循环
     * i = 1, j = 2 [-2, 22, 33, 25, 11, 1, 66] (33 <-> 22)
     * i = 1, j = 4 [-2, 11, 33, 25, 22, 1, 66] (22 <-> 11)
     * i = 1, j = 5 [-2, 1, 33, 25, 22, 11, 66] (11 <-> 1)
     * 内层第三遍循环
     * i = 2, j = 3 [-2, 1, 25, 33, 22, 11, 66] (33 <-> 25)
     * i = 2, j = 4 [-2, 1, 22, 33, 25, 11, 66] (25 <-> 22)
     * i = 2, j = 5 [-2, 1, 11, 33, 25, 22, 66] (22 <-> 11)
     * 内层第四遍循环
     * i = 3, j = 4 [-2, 1, 11, 25, 33, 22, 66] (33 <-> 25)
     * i = 3, j = 5 [-2, 1, 11, 22, 33, 25, 66] (25 <-> 22)
     * 内层第五遍循环
     * i = 4, j = 5 [-2, 1, 11, 22, 25, 33, 66] (33 <-> 25)
     * 内层第六遍循环(省略 已经排好序了)
     * </p>
     * 时间复杂度
     * O(n^2)
     *
     * @param arr
     * @param <T>
     * @return
     */
    private <T extends Comparable<? super T>> T[] bubbleSort(T[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                /**
                 * 比较后者（j）与前者（i）的关系
                 * 如果后者比前者小就交换
                 */
                int compare = arr[j].compareTo(arr[i]);
                if (compare < 0) {
                    T temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    System.out.print("i = " + i + ", j = " + j + " " + Arrays.toString(arr));
                    System.out.println(" (" + arr[j] + " <-> " + temp + ")");
                }
            }
        }

        return arr;
    }
}