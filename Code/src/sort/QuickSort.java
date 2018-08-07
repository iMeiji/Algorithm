package sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author Meiji
 */
public class QuickSort {

    public static void main(String[] args) {
        Integer[] object = new Integer[]{26, 19, 7, 37, 27, 57, 67, 99, 87, 17};
        System.out.println("init = " + Arrays.toString(object));
        quickSort(object, 0, object.length - 1);
        System.out.println(Arrays.toString(object));
    }

    /**
     * 该方法的基本思想是：
     * <p>
     * 1．先从数列中取出一个数作为基准数。
     * <p>
     * 2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
     * <p>
     * 3．再对左右区间重复第二步，直到各区间只有一个数。
     * <p>
     * init = [26, 19, 7, 37, 27, 57, 67, 99, 87, 17]
     * 第一趟 基准为 26
     * 从后往前找，找到 17 比 26 小，把 17 复制放到基准位置
     * [17, 19, 7, 37, 27, 57, 67, 99, 87, 17]
     * 从前往后找，找到 37 比 26 大，把 37 放到 17 位置
     * [17, 19, 7, 37, 27, 57, 67, 99, 87, 37]
     * 将基准填到这个坑中
     * [17, 19, 7, 26, 27, 57, 67, 99, 87, 37]
     * <p>
     * 开始递归左边[17, 19, 7] ，右边 [27, 57, 67, 99, 87, 37]
     * 左边：
     * [7, 17, 19]
     * 右边：
     * [57, 67, 99, 87, 37]
     * [37, 57, 99, 87, 67]
     * [99, 87, 67]
     * [67, 87]
     *
     * @param arr
     * @param low
     * @param high
     * @param <T>
     */
    public static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
        if (arr.length <= 0)
            return;
        if (low >= high)
            return;

        int left = low;
        int right = high;
        T temp = arr[left]; //挖坑1：保存基准的值
        System.out.print("before = ");
        for (int i = low, j = 0; i <= high; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
        while (left < right) {
            while (left < right && arr[right].compareTo(temp) >= 0) { //坑2：从后向前找到比基准小的元素，插入到基准位置坑1中
                right--;
            }
            arr[left] = arr[right];

            while (left < right && arr[left].compareTo(temp) <= 0) { //坑3：从前往后找到比基准大的元素，放到刚才挖的坑2中
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp; //退出时，left等于right。将基准填到这个坑中
        System.out.println("Sorting = " + Arrays.toString(arr) + " temp = " + temp + " left = " + left + " right = " + right);
        quickSort(arr, low, left - 1);
        quickSort(arr, left + 1, high);
    }
}
