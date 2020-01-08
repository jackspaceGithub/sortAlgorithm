package com.algorithm.sort;

import com.algorithm.sort.ON2.ChoiceSortService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ChoiceSortTest {

    @Test
    public void test() {
        ChoiceSortService sortService = new ChoiceSortService();
        int[] inputs = {2,3,5,6,1,0};
        sortService.sort(inputs);
        for(int i=0; i < inputs.length; i++) {
            System.out.print(inputs[i]);
        }
        System.out.println();
    }
}
