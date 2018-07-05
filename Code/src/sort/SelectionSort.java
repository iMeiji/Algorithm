package sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author Meiji
 */
public class SelectionSort {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{22, 33, 11, 25, 1, -2, 66};
        System.out.println("Init = " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("Result = " + Arrays.toString(arr));
    }

    /**
     * 选择排序
     * 选择排序的基本思想是遍历数组的过程中，以 i 代表当前需要排序的序号
     * 则需要在剩余的 [i...n-1] 中找出其中的最小值，然后将找到的最小值与 i 指向的值进行交换。
     * 因为每一趟确定元素的过程中都会有一个选择最大值的子流程，所以人们形象地称之为选择排序
     * <p>
     * Init = [22, 33, 11, 25, 1, -2, 66]
     * Sorting : i = 0 [-2, 33, 11, 25, 1, 22, 66] (22 <-> -2)
     * Sorting : i = 1 [-2, 1, 11, 25, 33, 22, 66] (33 <-> 1)
     * Sorting : i = 2 [-2, 1, 11, 25, 33, 22, 66] (无需交换)
     * Sorting : i = 3 [-2, 1, 11, 22, 33, 25, 66] (25 <-> 22)
     * Sorting : i = 4 [-2, 1, 11, 22, 25, 33, 66] (无需交换)
     * Sorting : i = 5 [-2, 1, 11, 22, 25, 33, 66] (无需交换)
     * Sorting : i = 6 [-2, 1, 11, 22, 25, 33, 66] (无需交换)
     * </p>
     * 选择排序的简单和直观名副其实，这也造就了它”出了名的慢性子”，
     * 无论是哪种情况，哪怕原数组已排序完成，它也将花费将近 n²/2 次遍历来确认一遍。
     * 其实选择排序可以看成冒泡排序的优化，因为其目的相同，
     * 只是选择排序只有在确定了最小数的前提下才进行交换，大大减少了交换的次数。
     * <p>
     * 选择排序的时间复杂度和空间复杂度分别为 O(n2 ) 和 O(1)
     * </p>
     *
     * @param arr
     * @param <T>
     */
    static <T extends Comparable<T>> void selectionSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {

            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                int compare = arr[j].compareTo(arr[min]);
                if (compare < 0) {
                    min = j;
                }
            }
            if (min != i) {
                T temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
            System.out.println("Sorting : i = " + i + " " + Arrays.toString(arr));
        }
    }
}
