package b.sort;

import java.util.Arrays;

/**
 * 插入排序
 * <p>
 * 思路：把所有元素分为两组（可以分为第一个和其他元素），一组排好序，一组未排序
 * 把未排序数组的第一个元素，插入到排好序的数组，倒叙遍历已排好序的数组进行插入
 * <p>
 * 稳定排序
 * <p>
 * 时间复杂度O（n²）
 *
 * @author junjun.lei
 * @create 2020-11-10 10:12
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 2, 7, 4, 9, 5};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        int in, out;
        for (out = 1; out < arr.length; out++) {
            int temp = arr[out];
            in = out;
            //倒叙遍历已排序数组，进行插入，这里in是未排序数组被标记的位置
            while (in > 0 && arr[in - 1] >= temp) {
                //向后移动
                arr[in] = arr[in - 1];
                --in;
            }
            arr[in] = temp;
        }
    }
}
