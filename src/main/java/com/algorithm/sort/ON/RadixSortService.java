package com.algorithm.sort.ON;

/**
 * 基数排序
 *
 * 原理：
 * 计数排序无法解决字符串排序和手机号这种长字符串的排序
 * 基数排序是计数排序的增强版本，用于解决这种问题，
 * ['kdf', 'akd', 'addff', 'ffd']
 * 先取最后一个字符进行排序，以此类推排序到第一个
 * 1，利用了稳定版计数排序的优势，即数值相同时，
 * 2，从后往前排序，就保证了最后排序完，字符串第一个开头的字符是符合排序的
 *
 * 时间复杂度仍然算是O(n)，因为k是字符串长度，是固定的，所以代码看起来是O(n2)，其实是O(k*4*n)，由于k很小，仍是O(n)
 */
public class RadixSortService {

    public String[] sort(String[] inputs, int maxLength) {

        for(int k = maxLength - 1; k >= 0; k--) {
            // 1，find 最大值最小值
            int max = getCharAscii(inputs[0], k);
            int min = getCharAscii(inputs[0], k);
            for(int i = 0; i < inputs.length; i++) {
                int per = getCharAscii(inputs[i], k);
                if(per > max) {
                    max = per;
                }
                if(per < min) {
                    min = per;
                }
            }

            // 2，定义一个合适大小的数组用于计数
            int[] countList = new int[max - min + 1];
            for(int i = 0; i < inputs.length; i++) {
                countList[getCharAscii(inputs[i], k) - min]++;
            }

            // 3，处理计数数组变形为累计的那种计数
            for(int i = 1; i < countList.length; i++) {
                countList[i] += countList[i - 1];
            }

            // 4，从后开始遍历inputs数组，根据变形后的计数数组把inputs元素放在相关位置，定义一个数组sortArray用于输出
            String[] sortArray = new String[inputs.length];
            for(int i = inputs.length - 1; i >=0; i--) {
                int per = getCharAscii(inputs[i], k);
                sortArray[countList[per - min] - 1] = inputs[i];
                countList[per - min]--;
            }
            inputs = sortArray;
        }
        return inputs;
    }


    /**
     * 遍历到第k位，返回其ascii码
     * @param str
     * @param k
     * @return
     */
    public int getCharAscii(String str, int k) {
        if(str.length() <= k) {
            return '0';
        }
        return str.charAt(k);
    }


}
