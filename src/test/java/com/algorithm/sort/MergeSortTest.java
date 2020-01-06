package com.algorithm.sort;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MergeSortTest {

    @Test
    public void test() {
        MergeSortService sortService = new MergeSortService();
        int[] inputs = {2,3,5,6,1,0};
        sortService.mergeSort(inputs, 0, 5);
        System.out.print("排序结果：");
        for(int i=0; i < inputs.length; i++) {
            System.out.print(inputs[i]);
        }
        System.out.println();
    }


}
