package org.beyondpn.alogrithm.sort;

/**
 * 归并排序.
 * <p>
 * 归并排序采用分治的思想，将需要排序的数组分为两个或多个，分别排序，之后再合并两个有序数组为一个数组。当要排序的数组大
 * 小超过内存大小时，必须采用这种分治的思路。实际使用时，归并排序仅用于归并，而每个分组可以采用效率更高的内部排序算法。
 * 归并的过程需要使用大量的额外空间。
 * </p>
 *
 * @author beyondpn
 *         Create: 14-3-9 下午4:08
 */
public class MergeSort {

    public int[] sort(int[] unSorted) {
        if (unSorted.length == 1) {
            return unSorted;
        }
        int half = unSorted.length / 2;
        int[] a = new int[half];
        int[] b = new int[unSorted.length - half];
        System.arraycopy(unSorted, 0, a, 0, a.length);
        System.arraycopy(unSorted, half, b, 0, b.length);
        a = sort(a);
        b = sort(b);
        return merge(a, b);
    }

    private int[] merge(int[] a, int[] b) {
        int[] merge = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (true) {
            if (i >= a.length || j >= b.length) {
                break;
            }
            if (a[i] < b[j]) {
                merge[k++] = a[i++];
            } else {
                merge[k++] = b[j++];
            }
        }
        while (i < a.length) {
            merge[k++] = a[i++];
        }
        while (j < b.length) {
            merge[k++] = b[j++];
        }
        return merge;
    }
}
