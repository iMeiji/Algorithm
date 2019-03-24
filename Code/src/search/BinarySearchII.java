package search;

import java.util.Arrays;

/**
 * 二分查找变种问题
 */
public class BinarySearchII {
    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 2, 9, 11};
        // 注意二分法查找要求数组是升序的
        Arrays.sort(arr);
        int search_1 = binarySearch_1(arr, arr.length, 2);
        System.out.println(search_1);

        int search_2 = binarySearch_2(arr, arr.length, 2);
        System.out.println(search_2);

        int search_3 = binarySearch_3(arr, arr.length, 2);
        System.out.println(search_3);

        int search_4 = binarySearch_4(arr, arr.length, 2);
        System.out.println(search_4);
    }

    /**
     * 变体一：查找第一个值等于给定值的元素
     * <p>
     * 当 arr[mid] == value 时，我们要确认下这个 arr[mid] 是不是第一个值等于给定值的元素
     */
    private static int binarySearch_1(int[] arr, int n, int value) {

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < value) {
                low = mid + 1;
            } else if (arr[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == 0 || arr[mid - 1] != value) {
                    return mid;
                } else {// arr[mid - 1] == value)
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    /**
     * 变体二：查找最后一个值等于给定值的元素
     * <p>
     * 当 arr[mid] == value 时，我们要确认下这个 arr[mid] 是不是最后一个值等于给定值的元素
     */
    private static int binarySearch_2(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < value) {
                low = mid + 1;
            } else if (arr[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == n - 1 || arr[mid + 1] != value) {
                    return mid;
                } else {// (arr[mid+1] == value)
                    low = mid + 1;
                }
            }
        }

        return -1;
    }

    /**
     * 变体三：查找第一个大于等于给定值的元素
     * <p>
     * 当 arr[mid] >= value，我们要确认下这个 arr[mid] 是不是第一个大于等于给定值的元素
     */
    private static int binarySearch_3(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < value) {
                low = mid + 1;
            } else if (arr[mid] >= value) {
                if (mid == 0 || arr[mid - 1] < value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }


    /**
     * 变体四：查找最后一个小于等于给定值的元素
     * <p>
     * 当 arr[mid] > value，我们要确认下这个 arr[mid] 是不是最后一个小于等于给定值的元素
     */
    static int binarySearch_4(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] <= value) {
                if (mid == n - 1 || arr[mid + 1] > value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }
}