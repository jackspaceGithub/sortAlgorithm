package com.algorithm.sort;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FastSortTest {

    @Test
    public void test() {
        FastSortService service = new FastSortService();
        int[] inputs = {2,3,5,6,1,0};
        service.fastSortRecursion(inputs, 0, inputs.length - 1);
        for(int i=0; i < inputs.length; i++) {
            System.out.println(inputs[i]);
        }
    }
}
