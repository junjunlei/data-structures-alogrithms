package e.recursion;
/**
 * 数组合并
 *
 * @author junjun.lei
 * @create 2020-11-23 15:49
 */
public class MergeArray {
    public static void main(String[] args) {
        int[] arrA = {23, 47, 81, 95};
        int[] arrB = {7, 14, 39, 55, 62, 74};
        int[] arrC = new int[10];
        merge(arrA, arrB, arrC);
    }

    /**
     * 合并有序数组
     *
     * 思路：
     *
     *  三个循环
     *
     *   第一个循环把数组a和b中较小的数复制到数组c(必然有一个数组还会剩余一些数)
     *
     *   第二个循环就是假设数组a不为空，数组b为空，则把a中剩下的数复制到数组c
     *
     *   第三个循环就是假设数组b不为空，数组a为空，则把b中剩下的数复制到数组c
     *
     * @param arrA
     * @param arrB
     * @param arrC
     */
    public static void merge(int[] arrA, int[] arrB, int[] arrC) {
        int aSize = arrA.length;
        int bSize = arrB.length;
        int aIndex = 0;
        int bIndex = 0;
        int cIndex = 0;
        //排序复制arrA和arrB中的数据到arrC,必然有一个先走完
        while (aIndex < aSize && bIndex < bSize) {
            if (arrA[aIndex] < arrB[bIndex]) {
                arrC[cIndex++] = arrA[aIndex++];
            } else {
                arrC[cIndex++] = arrB[bIndex++];
            }
            // 7 14 23 39 47 55 62 74

            //81和95没走完
        }
        //当没走完的为arrA
        while (aIndex<aSize){
            arrC[cIndex++]=arrA[aIndex++];
        }
        //当没走完的为arrB
        while (bIndex<bSize){
            arrC[cIndex++]=arrB[bIndex++];
        }
    }
}
