package com.algorithm.sort.ON2;

/**
 * 选择排序
 *
 * 原理：选出最大（小）的直接跟队尾元素交换，每轮不进行像冒泡那样的多次交换
 *
 * 时间复杂度：N*LogN
 * 复杂度分析：进行N轮，每轮进行比较次数递减，从N减少到1，每轮一次交换
 *
 * 不稳定排序：可能会改变同样大小的值的次序，所以算不稳定排序
 */
public class ChoiceSortService {

    public void sort(int[] inputs) {

        for(int i = 0; i < inputs.length; i++) {

            int minNum = 9999;
            // 最小值所在坐标
            int place = i;
            for(int i2 = i; i2 < inputs.length; i2++) {
                if(inputs[i2] < minNum) {
                    minNum = inputs[i2];
                    place = i2;
                }
            }

            int tmp = inputs[i];
            inputs[i] = minNum;
            inputs[place] = tmp;
        }
    }
}
