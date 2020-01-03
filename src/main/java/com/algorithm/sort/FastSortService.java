package com.algorithm.sort;


import java.util.List;
import java.util.Stack;

/**
 * 快速排序
 * 原理： 选取数列中任意一个数字做为分界点a，比a小的放在a左边，比a大的放在a右边，形成两个数列，
 * 再将两个数列继续如此排列直到数列中只有两个元素为止
 *
 * 时间复杂度：n*LogN
 * 复杂度解析：分LogN轮去拆分成小数列，每轮需要n次遍历
 *
 * 最坏时间复杂度：O(n2)
 * 复杂度解析：如果要把一个逆序数列排成正序，中间值又选取的是第一个值，这回导致并没有分成几堆数列，每次都只有一堆数列，即预计的logN轮计算变成了N轮
 * 避免办法：随机选取其中一个数作为基准数，但是同样可能产生最坏时间复杂度，万一你随机选的每次都是最大或者最小数呢，这也是有可能的
 *
 * 写法解析：最简单的想法当然是另外声明一个数组，把小于中间值的放左边，大于的放右边；
 * 如果要求不声明新数组，则要考虑怎么去交换位置，如果无脑从第一位到最后一位遍历去考虑是做不到排列后不乱序的，
 * 最优解是首尾对比互换，即[0]直接跟[n]比较，如果[0] > [n] 则互换，现在[n]的值变成了原来的[0]，现在再比较[n]和[1]的值，如果[1] > [n]则互换再比较[1]和[n-1]的值
 * 这样做只需n次交换即可完成找到a应该在的位置，这样做巧妙的是每一次交换保证了比a小的数字被放在了一个一定不会再被打扰的位置，有点像进栈放进了栈底
 */
public class FastSortService {

    /**
     * 递归写法
     * @param inputList
     * @param left
     * @param right
     */
    public void fastSortRecursion(int[] inputList, int left, int right) {
        if(left >= right) return;
        // 首先我们需要两个游标用来标记左侧和右侧的栈顶坐标，当left >= right时候，说明排序完成
        int leftY = left;
        int rightY = right;
        // 记录现在游标在哪里
        int now = left;
        while (left < right) {
            if(inputList[left] > inputList[right]) {
                int tmp = inputList[left];
                inputList[left] = inputList[right];
                inputList[right] = tmp;
                if(now == left) {
                    now = right;
                    left++;
                } else if(now == right) {
                    now = left;
                    right--;
                }
            } else {
                if(now == left) {
                    right--;
                } else if(now == right) {
                    left++;
                }
            }
        }
        fastSort(inputList, leftY, now - 1);
        fastSort(inputList, now + 1, rightY);
    }


    /**
     * 非递归写法
     * 基本所有的递归都能通过栈或者队列模拟哦
     * @param inputList
     * @param left
     * @param right
     */
    public void fastSort(int[] inputList, int left, int right) {

        Stack<Integer> stack = new Stack<>();
        stack.push(left);
        stack.push(right);
        while(!stack.empty()) {
            int rightNow = stack.peek();
            stack.pop();
            int leftNow = stack.peek();
            stack.pop();

            if(leftNow >= rightNow) continue;
            int now = leftNow;
            int leftOrigin = leftNow;
            int rightOrigin = rightNow;

            while (leftNow < rightNow) {
                if(inputList[leftNow] > inputList[rightNow]) {
                    int tmp = inputList[leftNow];
                    inputList[leftNow] = inputList[rightNow];
                    inputList[rightNow] = tmp;
                    if(now == leftNow) {
                        now = rightNow;
                        leftNow++;
                    } else if(now == rightNow) {
                        now = leftNow;
                        rightNow--;
                    }
                } else {
                    if(now == leftNow) {
                        rightNow--;
                    } else if(now == rightNow) {
                        leftNow++;
                    }
                }
            }
            stack.push(leftOrigin);
            stack.push(now - 1);

            stack.push(now + 1);
            stack.push(rightOrigin);
        }
    }
}
