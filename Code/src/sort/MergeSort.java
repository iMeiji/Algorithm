package sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author Meiji
 */
public class MergeSort {

    public static void main(String[] args) {
        Integer[] object = new Integer[]{5, 7, 1, 9, 1, -2};
        System.out.println("init = " + Arrays.toString(object));
        mergeSortInternally(object, 0, object.length - 1);
        System.out.println(Arrays.toString(object));
    }

    // 递归调用函数
    private static <T extends Comparable<T>> void mergeSortInternally(T[] arr, int p, int r) {

        // 递归终止条件
        if (p >= r) {
            return;
        }

        // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
        int q = p + (r - p) / 2;
        mergeSortInternally(arr, p, q);
        mergeSortInternally(arr, q + 1, r);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(arr, p, q, r);
    }

    private static <T extends Comparable<T>> void merge(T[] arr, int p, int q, int r) {

        int i = p;
        int j = q + 1;
        int k = 0;// 初始化变量i, j, k

        int length = r - p + 1;
        T[] temp = (T[]) new Comparable[length];// 申请一个大小跟a[p...r]一样的临时数组

        while (i <= q && j <= r) {
            if (arr[i].compareTo(arr[j]) < 0) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            temp[k++] = arr[start++];
        }

        // 将tmp中的数组拷贝回a[p...r]
        for (int l = 0; l < length; l++) {
            arr[p + l] = temp[l];
        }
    }
}
