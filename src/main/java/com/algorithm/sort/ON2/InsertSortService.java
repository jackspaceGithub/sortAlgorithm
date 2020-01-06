package com.algorithm.sort.ON2;

/**
 * 插入排序
 * 原理：设置一个有序区间，不断的将无序区间的数字加入进来，以此类推，类似平时玩扑克牌我们整理自己手牌的时候的排序
 *
 * 但是写法上还是值得推敲的。
 * 当把无序区数据加入有序区的时候，怎么做是最好的写法呢，
 * 方法一：把无序区间的第一个数字，也就是即将加入有序区的数字a，以冒泡的方式去进行交换位置，直到碰到a不能再冒的位置
 * 方法二：针对方法一进行优化，其实在a找自己位置的时候，不必进行叫唤，因为这是个有序区间，a找到比自己小的那个数字时候，
 * 他就确定属于这个位置了，那些比a大的数字肯定是要后移一位的，所以当a冒泡的时候，把a暂存，发现比自己大的数字就直接让大数字赋值给
 * a当前的坐标即可，然后a的坐标减一，以此类推，省去了一步交换
 *
 * 时间复杂度： O(n2)
 * 复杂度分析：n轮，每轮遍历次数是1,2,3..n，跟冒泡一样复杂度应该是 (1+n)*n/2
 *
 * 稳定排序
 */
public class InsertSortService {

    public void sort(int[] inputs, int start, int end) {

        for(int i = start; i <= end; i++) {
            int tmp = inputs[i];
            int pre;
            for(pre = i - 1; pre>=start && inputs[pre] > tmp; pre--) {
                inputs[pre+1] = inputs[pre];
            }
            inputs[pre+1] = tmp;
        }
    }
}
