package com.algorithm.sort;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MergeSortTest {

    public void test() {
        MergeSortService sortService = new MergeSortService();
        int[] inputs = {2,3,5,6,1,0};
        int[] resultList = sortService.mergeSort(inputs);
        System.out.print("排序结果：");
        for(int i=0; i < resultList.length; i++) {
            System.out.print(resultList[i]);
        }
        System.out.println();
    }
}
