package org.beyondpn.alogrithm.sort;

/**
 * 冒泡排序.
 * <p>
 * 冒泡排序临近的数字两两进行比较,按照从小到大或者从大到小的顺序进行交换,这样一趟过去后,最大或最小的数字被交换到了最
 * 后一位, 然后再从头开始进行两两比较交换,直到倒数第二位时结束。
 * </p>
 * <p>
 * 冒泡排序的平均时间复杂度是O(n<sup>2</sup>),最差时间复杂度是O(n<sup>2</sup>)。
 * </p>
 *
 * @author beyondpn
 *         Create: 14-3-9 下午4:32
 */
public class BubbleSort {

    public void sort(int[] source) {
        bubbleSort(source);
    }

    private void bubbleSort(int[] source) {
        for (int i = source.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (source[j] > source[j + 1]) {
                    int temp = source[j];
                    source[j] = source[j + 1];
                    source[j + 1] = temp;
                }
            }
        }
    }

}
