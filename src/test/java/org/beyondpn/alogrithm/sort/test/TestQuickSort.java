package org.beyondpn.alogrithm.sort.test;

import org.beyondpn.alogrithm.sort.QuickSort;

import java.util.Random;

/**
 * Sort Test.
 *
 * @author beyondpn
 *         Create: 14-3-6 上午1:27
 */
public class TestQuickSort {

    public static void main(String... args) {

        int[] source = new int[100];
        for (int i = 0; i < 100; i++) {
            source[i] = new Random().nextInt(50);
        }

        QuickSort quickSort = new QuickSort();
        quickSort.sort(source);

        System.out.println("ok");
    }

}
