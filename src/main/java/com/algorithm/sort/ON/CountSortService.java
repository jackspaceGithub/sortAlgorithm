package com.algorithm.sort.ON;

/**
 * 计数排序，O(n)排序家族里最简单的一种排序
 *
 * 原理：只能用于给范围很小的整数进行排序，利用自己的下标跟排序数字本身进行映射，记录数字个数，然后顺序输出即可
 *
 * 优化：可以对空间进行优化，如果，数列为 91,92,93,99 声明100大小的数组，则0-90的数组空间都被浪费了，
 * 解决办法就是记录最大值和最小值的差值，建立差值长度的数组，按照偏移量进行计数即可。
 *
 * 不稳定排序，因为无法确认值相同的元素的先后输出顺序
 * 解决办法：
 * 1，针对朴素版本的计数排序，朴素处理后的数组定义为countArray，对countArray进行处理，将元素跟下标-1位置的元素进行累加获得新数组 countNewArray，定义一个输出数组sortArray用来存贮输出元素
 * 2，countNewArray 存的，就相当于是下标这个值（也就是统计值）应该所在的输出位置
 * 3，从后往前遍历原始数列，输出到对应的位置后，countNewArray的值-1，继续迭代即可
 * 这样处理后，计数排序为稳定排序
 *
 */
public class CountSortService {

    /**
     * 朴素版本
     * @param inputs
     */
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

    /**
     * 稳定排序版本
     * @param inputs
     */
    public void sortStable(int inputs[]) {
        // 1，find 最大值最小值
        int max = inputs[0];
        int min = inputs[0];
        for(int i = 0; i < inputs.length; i++) {
            if(inputs[i] > max) {
                max = inputs[i];
            }
            if(inputs[i] < min) {
                min = inputs[i];
            }
        }

        // 2，定义一个合适大小的数组用于计数
        int[] countList = new int[max - min + 1];
        for(int i = 0; i < inputs.length; i++) {
            countList[inputs[i] - min]++;
        }

        // 3，处理计数数组变形为累计的那种计数
        for(int i = 1; i < countList.length; i++) {
            countList[i] += countList[i - 1];
        }

        // 4，从后开始遍历inputs数组，根据变形后的计数数组把inputs元素放在相关位置，定义一个数组sortArray用于输出
        int[] sortArray = new int[inputs.length + 1];
        for(int i = inputs.length - 1; i >=0; i--) {
            sortArray[countList[inputs[i] - min]] = inputs[i];
            countList[inputs[i] - min]--;
        }

        // 5，可以输出了
        for(int i = 1; i < sortArray.length; i++) {
            System.out.print(sortArray[i]);
        }
        System.out.println();
    }
}
