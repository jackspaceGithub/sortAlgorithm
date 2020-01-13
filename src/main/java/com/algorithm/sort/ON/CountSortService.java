package com.algorithm.sort.ON;

/**
 * 计数排序，O(n)排序家族里最简单的一种排序
 *
 * 原理：只能用于给范围很小的整数进行排序，利用自己的下标跟排序数字本身进行映射，记录数字个数，然后顺序输出即可
 *
 * 优化：可以对空间进行优化，如果，数列为 91,92,93,99 声明100大小的数组，则0-90的数组空间都被浪费了，
 * 解决办法就是记录最大值和最小值的差值，建立差值长度的数组，按照偏移量进行计数即可。
 *
 */
public class CountSortService {

    public void sort(int inputs[]) {
        int max = 0;
        for(int i = 0; i < inputs.length; i++) {
            if(inputs[i] > max) {
                max = inputs[i];
            }
        }

        int[] tmpList = new int[max+1];
        for(int i = 0; i < inputs.length; i++) {
            tmpList[inputs[i]]++;
        }

        for(int i = 0; i < tmpList.length; i++) {
            if(tmpList[i] == 0) {
                continue;
            }
            for(int i2 = 0; i2 < tmpList[i]; i2++){
                System.out.print(i);
            }
        }
        System.out.println();
    }
}
