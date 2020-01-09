package com.algorithm.sort.ON2;

/**
 * 冒泡排序
 * 原理：把最大（最小）的那个数字冒上来，冒泡的泡（数字）在冒的过程中是会变的，遇到比自己大（小）的就接着冒那个数字。
 *
 * 时间复杂度：O(n2)
 * 复杂度解析：n轮遍历，从当前轮的最大最小数字开始，每轮进行n次比较。更详细点就是一个等差数列求和公式 n*(1+n)/2
 *
 * 稳定排序
 *
 * 优化方案：
 * 主要是针对有序数列的优化
 * 1，针对第一层循环的优化：标记无交换发生的情况，说明数列已经有序，不必再进行下去， 如[3,2,4,5,6] 进行排序1轮为[2,3,4,5,6]
 * 此时“已完成游标”位于下角标5的位置，也就是值为6的地方，接着第二轮进行，序列仍然是[2,3,4,5,6]，角标位于4，其实没有任何变化，完全不需要进行接下来的轮。
 *
 * 2，针对第二层循环的优化：数列[3,2,1,5,6,7,8] 当进行了第一轮后它是[2,1,3,5,6,7,8]，此时“已完成游标”位于下角标6的位置
 * ，也就是值8的位置了。其实这是区间值3-7都是有序区，8属于完成区，后续的遍历没有必要在去对有序区进行比较，因为根本不可能在这个区间发生交换，只会在2-1的无序区发生交换
 * 做法是记录无序区边界，冒泡二层循环只进行到无序区边界就可以了, 记录最后一次交换发生的位置，用它去更新无序区边界
 */
public class BubblingSortService {

    /**
     * 正经版本的冒泡
     * @param inputList
     */
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

    /**
     * 优化版本的冒泡1
     * @param inputList
     */
    public void sortBetter1(int inputList[], int start, int end) {

        for(int i = start; i <= end; i++) {
            int end2 = end - i;
            // 记录交换发生与否
            boolean change = false;
            for(int i2 = 0; i2 <= end2; i2++) {
                if(i2 + 1 > end2) continue;
                if(inputList[i2] > inputList[i2 + 1]) {
                    int tmp = inputList[i2];
                    inputList[i2] = inputList[i2 + 1];
                    inputList[i2 + 1] = tmp;
                    change = true;
                }
            }

            if(!change) break;
        }
    }

    /**
     * 优化版本的冒泡2
     * @param inputList
     */
    public void sortBetter2(int inputList[], int start, int end) {
        // 上一轮最后一次交换的位置，也就是无序区边界
        int changePlace = end;
        for(int i = start; i <= end; i++) {
            int end2 = end - i;
            // 当前轮最后一次交换的位置
            int changePlaceTmp = end2;
            // 记录交换发生与否
            boolean change = false;
            for(int i2 = 0; i2 <= end2; i2++) {
                if(i2 + 1 > end2) continue;
                // 如果遍历到上一轮最后一次交换的位置，跳出
                if(i2 >= changePlace) break;
                if(inputList[i2] > inputList[i2 + 1]) {
                    int tmp = inputList[i2];
                    inputList[i2] = inputList[i2 + 1];
                    inputList[i2 + 1] = tmp;
                    changePlaceTmp = i2 + 1;
                    change = true;
                }
            }
            changePlace = changePlaceTmp;
            if(!change) break;
        }
    }

    /**
     * 把 优化版本的冒泡2 美化一下
     */
    public void sortBetter2Beautiful(int[] inputs) {

        // 上一次发生交换的位置
        int lastChangeIndex = inputs.length - 1;
        // 无序区边界值
        int disorderBoundaryIndex = inputs.length - 1;
        for(int i=0; i < inputs.length; i++) {

            // 是否发生了交换
            boolean isChangeHappend = false;
            // 从左到右侧
            for(int i2=0; i2 <= disorderBoundaryIndex; i2++) {
                if(i2+1 <= disorderBoundaryIndex && inputs[i2] > inputs[i2+1]) {
                    int tmp = inputs[i2];
                    inputs[i2] = inputs[i2 + 1];
                    inputs[i2 + 1] = tmp;
                    lastChangeIndex = i2;
                    isChangeHappend = true;
                }
            }

            disorderBoundaryIndex = lastChangeIndex;

            if(!isChangeHappend) {
                break;
            }
        }
    }


}
