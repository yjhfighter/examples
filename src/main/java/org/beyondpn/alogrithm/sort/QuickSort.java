package org.beyondpn.alogrithm.sort;

/**
 * 快速排序算法.
 * <p>
 * 通过一趟扫描将要排序的数据分割成独立的两部分,其中一部分的所有数据都比另外一部分的所有数据都要小,
 * 然后再按此方法对这两部分数据分别进行快速排序,整个排序过程可以递归进行,以此达到整个数据变成有序序列.
 * </p>
 * <p>
 * 对于包含n个数的输入数组，最坏情况下运行时间为O(n<sup>2</sup>)。虽然这个最坏情况运行时间比较差，但快速
 * 排序通常是用于排序的最佳选择，这是因为其平均性能相当好：期望的运行时间是O(n lg n)，且O(n lg n)记号中隐
 * 含的常数因子很小。另外，快速排序是就地排序，空间复杂度也非常好。
 * </p>
 * <p>
 * 关于最差时间效率的情况。每次进行partition时出现n个数的数组partition成n-1个数和1个数两组，将导致最差效率。
 * 如已经排好序的数组就会出现这种情况，应对方法是使用随机化的partition方法，即pivot不固定选择low或high，
 * 而是随机选择low和high中的任一个数。
 * </p>
 *
 * @author beyondpn
 *         Create: 14-3-6 上午12:09
 */
public class QuickSort {

    public void sort(int[] source) {
        quickSort(source, 0, source.length - 1);
    }

    private void quickSort(int[] source, int low, int high) {
        if (low < high) {
            int i = partition(source, low, high);
            quickSort(source, low, i - 1);
            quickSort(source, i + 1, high);
        }
    }

    private int partition(int[] unSort, int low, int high) {
        int pivot = unSort[high];//基准
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (unSort[j] < pivot) {
                i = i + 1;
                swap(unSort, i, j);
            }
        }
        swap(unSort, i + 1, high);
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        if (i != j) {
            int v = array[i];
            array[i] = array[j];
            array[j] = v;
        }
    }

}
