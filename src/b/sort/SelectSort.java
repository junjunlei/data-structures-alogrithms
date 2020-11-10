package b.sort;

import java.util.Arrays;

/**
 * 选择排序
 * <p>
 * 思路：最小数向左移动
 * <p>
 * 外循环从第一个数开始向高位增长，循环从外循环的下一个位置开始增长
 * <p>
 * 每次都假定外循环的值为最小值，和内循环的值进行比较，找到最小值所在
 * <p>
 * 交换外循环值与最小值
 * <p>
 * 不稳定排序
 * 时间复杂度O(n²)
 *
 * @author junjun.lei
 * @create 2020-11-10 9:35
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 2, 7, 4, 9, 5};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
        int in, out, min;
        for (out = 0; out < arr.length; out++) {
            min = out;
            for (in = out + 1; in < arr.length; in++) {
                if (arr[min] > arr[in]) {
                    min = in;
                }
            }
            if (min != out) {
                int temp = arr[out];
                arr[out] = arr[min];
                arr[min] = temp;
            }
        }

    }
}
