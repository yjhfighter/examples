package org.beyondpn.alogrithm.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 桶排序.
 * <p>
 * 桶排序适合已知输入区间的排序，如排行榜，所有输入区间为[a,b]。 则可以讲[a,b]划分为若干个区间，保证每个区间的数不多，
 * 先把桶内数据排序，再把桶排序即得到有序的结果。某些特殊情况下，如排行榜所有数为整数，且区间比较小，参与排序的数组
 * 非常大，则可以每个数作为一个桶，此时，桶内无须排序。
 * </p>
 *
 * @author beyondpn
 *         Create: 14-3-6 下午11:06
 */
public class BucketSort {

    public int[] sort(int[] source, int min, int max) {
        //此处假设bucket的区间是1，实际情况当bucket区间是1，且所有需排序数都为整数时，无须记录列表，只需计数即可，此处仅做示例
        List<List<Integer>> list = new ArrayList<>(max - min + 1);
        for (int i = 0; i < max + 1; i++) {
            list.add(null);
        }
        for (int v : source) {
            int idx = v - min;
            List<Integer> bucket = list.get(idx);
            if (bucket == null) {
                bucket = new LinkedList<>();
                list.set(idx, bucket);
            }
            bucket.add(v);
        }
        //如果bucket区间不是1，sort bucket

        int[] sorted = new int[source.length];
        int idx = 0;
        for (List<Integer> bucket : list) {
            if (bucket != null) {
                for (Integer v : bucket) {
                    sorted[idx++] = v;
                }
            }
        }
        return sorted;
    }

    public static void main(String... args) {
        int[] source = new int[100];
        for (int i = 0; i < 100; i++) {
            source[i] = new Random().nextInt(50);
        }

        BucketSort bucketSort = new BucketSort();
        int[] sorted = bucketSort.sort(source, 0, 49);
        System.out.println("ok");
    }
}
