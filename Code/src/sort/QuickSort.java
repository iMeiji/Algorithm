package sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author Meiji
 */
public class QuickSort {

    public static void main(String[] args) {
        Integer[] object = new Integer[]{5, 7, 1, 9, 1, -2};
        System.out.println("init = " + Arrays.toString(object));
        quickSortInternally(object, 0, object.length - 1);
        System.out.println(Arrays.toString(object));
    }

    // 快速排序递归函数，p,r 为下标
    public static <T extends Comparable<T>> void quickSortInternally(T[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        // 获取分区点
        int q = partition(arr, p, r);
        // q 为分区点，把数组分为 [p, q - 1] ,[q + 1, r] 两部分
        quickSortInternally(arr, p, q - 1);
        quickSortInternally(arr, q + 1, r);
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
     * 第一趟 [5, 7, 1, 9, 1, -2]，基准为 -2
     * 分区后
     * 左边 [-2]，递归结束
     * 右边 [7, 1, 9, 1, 5]
     * <p>
     * 第二趟 [7, 1, 9, 1, 5]，基准为 5
     * 分区后
     * 左边 [1, 1]
     * 右边 [7, 9]
     * <p>
     * 第三趟
     * 左边 [1,1]
     * 右边 [7,9]
     */
    public static <T extends Comparable<T>> int partition(T[] arr, int p, int r) {
        // 选取最后一项为基准
        T pivot = arr[r];
        int i = p;
        // 把小于基准的数放在左边
        for (int j = p; j < r; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                if (i == j) {
                    i++;
                } else {
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                }
            }
        }
        // 基准与大于基准的第一项互换，如果 i == r ，说明数值的顺序已排好
        if (i != r) {
            T temp = arr[i];
            arr[i] = arr[r];
            arr[r] = temp;
        }

        System.out.println("i=" + i);
        return i;
    }
}
