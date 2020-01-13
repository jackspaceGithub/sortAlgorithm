package com.algorithm.sort.ON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 桶排序
 * 解决计数排序不能对付浮点类型的问题
 *
 * 原理：设置n个桶，一个桶表示一个区间，负责存储数字
 * 这里我们声明跟数组长度相同的桶个数，每个桶里用链表存贮，最后一个桶只存最大值，区间是[,)类型的
 *
 * 不稳定排序：最佳时间复杂度3n + n*(logn - logm)， 分布均匀的情况，一个桶一个数字
 * 最坏时间复杂度：n*logN ，当数字分布极度不均匀，都在一个桶的时候会退化至此
 */
public class BucketSortService {

    public void sort(double[] inputs) {
        // 1,找到最大值最小值 (时间复杂度+n = n)
        double max = inputs[0];
        double min = inputs[0];
        for(int i = 0; i < inputs.length; i++) {
            if(max < inputs[i]) {
                max = inputs[i];
            }
            if(min > inputs[i]) {
                min = inputs[i];
            }
        }

        // 2,获得区间间隔大小 (时间复杂度1，无视)
        double interval = (max - min)/(inputs.length - 1);

        // 3,声明桶列表，把原始数据分到桶里 (
        // 时间复杂度+n = n + n)
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(inputs.length);
        for(int i = 0; i < inputs.length; i++) {
            bucketList.add(new LinkedList<Double>());
        }

        // 时间复杂度+n = n +n +n
        for(int i = 0; i < inputs.length; i++) {
            if(inputs[i] == max) {
                bucketList.get(inputs.length - 1).add(inputs[i]);
                continue;
            }
            // 获得当前数字所属桶号
            int bucketNum = (int)((inputs[i] - min)/interval);
            bucketList.get(bucketNum).add(inputs[i]);
        }

        // 4，给桶内元素排序 m为桶个数
        // 时间复杂度+ m*(n/m)*log(n/m) = n +n +n + m*(n/m)*log(n/m) = 3n + n*(logn - logm)
        for(LinkedList<Double> bucket : bucketList) {
            Collections.sort(bucket);
        }

        // 5,输出
        for(LinkedList<Double> bucket : bucketList) {
            for(Double bucketMem : bucket) {
                System.out.print(bucketMem);
                System.out.print("  ");
            }
        }
        System.out.println();
    }

    /**
     * 不用java.util.Collection处理数组
     * @param inputs
     */
    public void sortv2(double[] inputs) {
        // 1,找到最大值最小值
        double max = inputs[0];
        double min = inputs[0];
        for(int i = 0; i < inputs.length; i++) {
            if(max < inputs[i]) {
                max = inputs[i];
            }
            if(min > inputs[i]) {
                min = inputs[i];
            }
        }

        // 2,获得区间间隔大小
        double interval = (max - min)/(inputs.length - 1);

        // 3,声明桶列表，把原始数据分到桶里
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(inputs.length);
        for(int i = 0; i < inputs.length; i++) {
            bucketList.add(new LinkedList<Double>());
        }

        for(int i = 0; i < inputs.length; i++) {
            if(inputs[i] == max) {
                bucketList.get(inputs.length - 1).add(inputs[i]);
                continue;
            }
            // 获得当前数字所属桶号
            int bucketNum = (int)((inputs[i] - min)/interval);
            if(bucketList.get(bucketNum).size() == 0) {
                bucketList.get(bucketNum).add(inputs[i]);
                continue;
            }
                // 4，在这里插入链表的时候顺便排序
            for(int i2 = 0; i2 < bucketList.get(bucketNum).size(); i2++) {
                if (inputs[i] >= bucketList.get(bucketNum).get(i2) && i2 == bucketList.get(bucketNum).size() - 1){
                    bucketList.get(bucketNum).add(i2 + 1, inputs[i]);
                    break;
                }
                if (inputs[i] < bucketList.get(bucketNum).get(i2)) {
                    bucketList.get(bucketNum).add(i2, inputs[i]);
                    break;
                }
            }
        }

        // 5,输出
        for(LinkedList<Double> bucket : bucketList) {
            for(Double bucketMem : bucket) {
                System.out.print(bucketMem);
                System.out.print("  ");
            }
        }
        System.out.println();
    }

}
