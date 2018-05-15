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
        int r2 = binarySearch_iterative(0, arr.length - 1, 2, arr);
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
     * @param start
     * @param end
     * @param key
     * @param arr
     * @return
     */
    static int binarySearch_recursive(int start, int end, int key, int[] arr) {
        // 终止循环
        if (start > end) {
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
        int mid = start + (end - start) / 2;
        if (arr[mid] > key) {
            // [start,...,key,...,mid,...,end] 说明 key 在 mid 左侧 [start,...,mid-1]
            return binarySearch_recursive(start, mid - 1, key, arr);
        } else if (arr[mid] < key) {
            // [start,...,mid,...,key,...,end] 说明 key 在 mid 右侧 [mid+1,...,end]
            return binarySearch_recursive(mid + 1, end, key, arr);
        } else {
            // 找到 key 的下标
            return mid;
        }
    }

    /**
     * 二分法查找迭代版
     *
     * @param start
     * @param end
     * @param key
     * @param arr
     * @return
     */
    static int binarySearch_iterative(int start, int end, int key, int[] arr) {
        int result = -1;
        int mid;
        // 注意条件
        while (start <= end) {
            // 计算二分查找中的中值
            mid = start + (end - start) / 2;
            if (arr[mid] < key) {
                // key 在右侧
                start = mid + 1;
            } else if (arr[mid] > key) {
                // key 在左侧
                end = mid - 1;
            } else {
                // key 在中间,跳出循环
                result = mid;
                break;
            }
        }
        return result;
    }
}