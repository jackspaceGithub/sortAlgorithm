package com.algorithm.sort;

import com.algorithm.sort.ON2.BubblingSortService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BubblingSortTest {

    @Test
    public void test() {
        int[] inputs = {2,3,5,6,1,0};
        BubblingSortService sortService = new BubblingSortService();
        sortService.sort(inputs, 0, 5);
        for(int i=0; i < inputs.length; i++) {
            System.out.print(inputs[i]);
        }
        System.out.println();
    }
}
