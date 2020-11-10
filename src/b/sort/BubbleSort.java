package b.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * <p>
 * 思路：
 * <p>
 * 每一次从左边选出最大的数移到最右边
 * 也就是说从左到右两两比较，最大的右移
 * <p>
 * 外循环比较趟数
 * <p>
 * 内循环比较次数
 * <p>
 * 时间复杂度O(n²)
 *
 * @author junjun.lei
 * @create 2020-11-10 9:22
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 2, 7, 4, 9, 5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        int in, out;
        for (out = 1; out < arr.length; out++) {
            for (in = 0; in < arr.length - out; in++) {
                if (arr[in] > arr[in + 1]) {
                    int temp = arr[in];
                    arr[in] = arr[in + 1];
                    arr[in + 1] = temp;
                }
            }
        }
    }
}
