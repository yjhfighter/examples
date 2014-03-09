package org.beyondpn.alogrithm.sort.test;

import org.beyondpn.alogrithm.sort.InsertionSort;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author beyondpn
 *         Create: 14-3-7 下午11:51
 */
public class TestInsertionSort {

    public static void main(String... args) {

        int[] source = new int[100];
        for (int i = 0; i < 100; i++) {
            source[i] = new Random().nextInt(50);
        }

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(source);

        System.out.println("ok");
    }

}
