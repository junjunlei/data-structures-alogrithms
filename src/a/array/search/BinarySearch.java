package a.array.search;

/**
 * 二分查找算法
 * <p>
 * 思路：while循环或者递归
 *
 * 效率 log(n)
 *
 * @author junjun.lei
 * @create 2020-11-09 16:15
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int i = binarySearchWhile(arr, 8);
        int i2 = binarySearchRecursion(arr, 0, arr.length - 1, 7);
        System.out.println(i);
        System.out.println(i2);
    }

    /**
     * while循环二分查找
     *
     * @param source 源数组
     * @param target 查找目标值
     * @return
     */
    private static int binarySearchWhile(int[] source, int target) {
        int mid;
        int low = 0;
        int high = source.length - 1;
        while (true) {
            mid = (high + low) / 2;
            if (source[mid] == target) {
                return source[mid];
            } else if (low > high) {
                return -1;
            } else {
                if (target > source[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
    }

    /**
     * 递归二分查找
     *
     * @param source 源数组
     * @param low    最小坐标
     * @param high   最大坐标
     * @param target 目标值
     * @return
     */
    private static int binarySearchRecursion(int[] source, int low, int high, int target) {
        int mid = (low + high) / 2;
        if (source[mid] == target) {
            return source[mid];
        } else if (low > high) {
            return -1;
        } else {
            if (source[mid] > target) {
                return binarySearchRecursion(source, low, mid - 1, target);
            } else {
                return binarySearchRecursion(source, mid + 1, high, target);
            }
        }
    }
}
