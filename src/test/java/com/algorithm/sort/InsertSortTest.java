package com.algorithm.sort;

import com.algorithm.sort.ON2.InsertSortService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertSortTest {

    @Test
    public void test() {
        InsertSortService sortService = new InsertSortService();
        int[] inputs = {2,3,5,6,1,0};
        sortService.sort(inputs, 0, 5);
        for(int i=0; i < inputs.length; i++) {
            System.out.print(inputs[i]);
        }
        System.out.println();
    }
}
