package com.algorithm.sort;

import java.util.Stack;

/**
 * 归并排序
 * 原理：先分后并
 * 第一步（分）：先把数字序列分组成2个序列，再接着往下分，分到一组只有1-2个元素为止。
 * 第二歩（并）：把已经分好的n个序列，分别进行组内排序，排好后，进行合并，第1小组和第2小组合并，把这两个小组合并为一个新的有序小组，以此类推
 *
 * 时间复杂度：N*LogN
 *
 * 时间复杂度解析：
 * 分只需要O(n)，或者不需要遍历，直接取两两一组即可；
 * 并要分logN 轮，每轮O(n)，所以总时间复杂度N*LogN
 *
 * 归并排序是稳定排序，时间复杂度恒定
 */
public class MergeSortService {

    public void mergeSort(int[] inputs, int start, int end) {
        if(start < end) {
            int middle = (start + end)/2;
            mergeSort(inputs, start, middle);
            mergeSort(inputs, middle + 1, end);
            merge(inputs, start, end, middle);
        }
    }

    private void merge(int[] inputs, int start, int end, int middle) {
        int[] tmpList = new int[10];
        for(int i = 0; i < end - start; i++) {
            if(i + middle > end) {
                tmpList[i + start] = inputs[i + start];
            }

            if(inputs[i + start] < inputs[i + middle]) {
                tmpList[i + start] = inputs[i + start];
            } else {
                tmpList[i + start] = inputs[i + middle];
            }
        }
    }
}
