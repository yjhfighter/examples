package org.beyondpn.alogrithm.sort;

/**
 * 插入排序.
 * <p>
 * 每一步都将一个待排数据按其大小插入到已经排序的数据中的适当位置，直到全部插入完毕。
 * 从输入数组的第二个元素开始检测，如果前面的元素，则插入到前面，比这个元素大的元素依次后移。
 * 插入排序的平均时间复杂度是O(n<sup>2</sup>)。
 * 最优时间复杂度O(n)，对应已排序好的数组的情况。
 * 插入排序最差时间复杂度是 O(n<sup>2</sup>)。
 * </p>
 *
 * @author beyondpn
 *         Create: 14-3-7 下午11:41
 */
public class InsertionSort {

    public void sort(int[] source) {
        for (int i = 1; i < source.length; i++) {
            if (source[i] < source[i - 1]) {
                int v = source[i];
                int j = i - 1;
                for (; j >= 0 && source[j] > v; j--) {
                    source[j + 1] = source[j];
                }
                source[j + 1] = v;
            }
        }
    }

}
