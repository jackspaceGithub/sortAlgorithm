package com.algorithm.sort.ON2;

/**
 * 鸡尾酒排序
 *
 * 原理：属于冒泡排序的一种变种，为了解决大部分有序，为了少部分无序做了很多轮交换的问题
 * 因为冒泡排序一次只能将一个数字沉底到正确位置，就有了如下问题：
 * 数列[2,3,4,5,6,1]， 第一轮后[2,3,4,5,1,6]，第二轮后[2,3,4,1,5,6]
 * 其实除了最后一位1，剩下的序列都有序了，但是我们还要一轮轮的去交换数字。所以我们希望尽快把1放在属于它的位置。
 * 鸡尾酒排序的做法是 左右交换使用冒泡排序算法 过程如下 [2,3,4,5,6,1] 左边到右边开始冒泡-> [2,3,4,5,1,6] 右边到左边开始冒泡-> [1,2,3,4,5,6] 排序完成
 * 正常冒泡需要5轮，鸡尾酒用了3轮完成
 */
public class CocktailSortService {

    public void sort(int[] inputs) {

        // 上一次发生交换的位置
        int lastChangeIndex = inputs.length - 1;
        // 无序区边界 右边界
        int rightDisorderBoundaryIndex = inputs.length - 1;
        // 无序区边界 左边界
        int leftDisorderBoundaryIndex = 0;
        for(int i=0; i < inputs.length; i++) {

            // 是否发生了交换
            boolean isChangeHappend = false;

            if(i%2 == 0) {
                // 偶数轮 从左往右
                for(int i2 = leftDisorderBoundaryIndex; i2 <= rightDisorderBoundaryIndex; i2++) {
                    if(i2+1 <= rightDisorderBoundaryIndex && inputs[i2] > inputs[i2+1]) {
                        int tmp = inputs[i2];
                        inputs[i2] = inputs[i2 + 1];
                        inputs[i2 + 1] = tmp;
                        lastChangeIndex = i2;
                        isChangeHappend = true;
                    }
                }
            } else {
                // 奇数轮 从右往左
                for (int i2 = rightDisorderBoundaryIndex; i2 >= leftDisorderBoundaryIndex; i2--) {
                    if(i2 - 1 >= leftDisorderBoundaryIndex && inputs[i2] < inputs[i2 - 1]) {
                        int tmp = inputs[i2];
                        inputs[i2] = inputs[i2 - 1];
                        inputs[i2 - 1] = tmp;
                        lastChangeIndex = i2;
                        isChangeHappend = true;
                    }
                }
            }

            if(!isChangeHappend) {
                break;
            }

            if(i%2 == 0) {
                rightDisorderBoundaryIndex = lastChangeIndex;
            } else {
                leftDisorderBoundaryIndex = lastChangeIndex;
            }
        }
    }
}
