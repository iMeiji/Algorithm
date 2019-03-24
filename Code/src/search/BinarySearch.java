package search;

import java.util.Arrays;

/**
 * 二分法查找
 *
 * @author Meiji
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {2, 4, -2, 66, 233, 6};
        // 注意二分法查找要求数组是升序的
        Arrays.sort(arr);
        System.out.println("init = " + Arrays.toString(arr));
        int r1 = binarySearch_recursive(0, arr.length - 1, 2, arr);
        int r2 = binarySearch_iterative(arr, arr.length, 2);
        System.out.println("key 的下角标 = " + r1);
        System.out.println("key 的下角标 = " + r2);
    }

    /**
     * 二分法查找递归版
     * <p>
     * 算法：当数据量很大适宜采用该方法。采用二分法查找时，数据需是排好序的。
     * 基本思想：假设数据是按升序排序的，对于给定值key，从序列的中间位置k开始比较，
     * 如果当前位置arr[k]值等于key，则查找成功；
     * 若key小于当前位置值arr[k]，则在数列的前半段中查找,arr[low,mid-1]；
     * 若key大于当前位置值arr[k]，则在数列的后半段中继续查找arr[mid+1,high]，
     * 直到找到为止,时间复杂度:O(log(n))。
     *
     * @param low
     * @param high
     * @param value
     * @param arr
     * @return
     */
    static int binarySearch_recursive(int low, int high, int value, int[] arr) {
        // 终止循环
        if (low > high) {
            return -1;
        }
        /**
         * 计算二分查找中的中值
         *
         * 算法一： mid = (low + high) / 2
         * 算法二： mid = low + (high – low)/2
         * 乍看起来，算法一简洁，算法二提取之后，跟算法一没有什么区别。
         * 但是实际上，区别是存在的。
         * 算法一的做法，在极端情况下，(low + high)存在着溢出的风险，进而得到错误的mid结果，导致程序错误。
         * 而算法二能够保证计算出来的mid，一定大于low，小于high，不存在溢出的问题。
         *
         * 所以，正确的写法应该是mid = low + (high – low)/2或 mid = low + (high – low)>>1
         */
        int mid = low + (high - low) / 2;
        if (arr[mid] > value) {
            // [low,...,value,...,mid,...,high] 说明 value 在 mid 左侧 [low,...,mid-1]
            return binarySearch_recursive(low, mid - 1, value, arr);
        } else if (arr[mid] < value) {
            // [low,...,mid,...,value,...,high] 说明 value 在 mid 右侧 [mid+1,...,high]
            return binarySearch_recursive(mid + 1, high, value, arr);
        } else {
            // 找到 value 的下标
            return mid;
        }
    }

    /**
     * 二分法查找迭代版
     */
    static int binarySearch_iterative(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;

        // 注意条件
        while (low <= high) {
            // 计算二分查找中的中值
            int mid = low + (high - low) / 2;
            if (arr[mid] == value) {
                // key 在中间,跳出循环
                return mid;
            } else if (arr[mid] > value) {
                // key 在左侧
                high = mid - 1;
            } else {
                // key 在右侧
                low = mid + 1;
            }
        }
        return -1;
    }
}