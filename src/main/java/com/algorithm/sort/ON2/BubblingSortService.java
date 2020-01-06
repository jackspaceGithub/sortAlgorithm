package com.algorithm.sort.ON2;

/**
 * 冒泡排序
 * 原理：把最大（最小）的那个数字冒上来，冒泡的泡（数字）在冒的过程中是会变的，遇到比自己大（小）的就接着冒那个数字。
 *
 * 时间复杂度：O(n2)
 * 复杂度解析：n轮遍历，从当前轮的最大最小数字开始，每轮进行n次比较。更详细点就是一个等差数列求和公式 n*(1+n)/2
 *
 * 稳定排序
 */
public class BubblingSortService {

    public void sort(int inputList[], int start, int end) {

        for(int i = start; i <= end; i++) {
            int end2 = end - i;
            for(int i2 = 0; i2 <= end2; i2++) {
                if(i2 + 1 > end2) continue;
                if(inputList[i2] > inputList[i2 + 1]) {
                    int tmp = inputList[i2];
                    inputList[i2] = inputList[i2 + 1];
                    inputList[i2 + 1] = tmp;
                }
            }
        }
    }

}
