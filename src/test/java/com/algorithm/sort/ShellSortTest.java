package com.algorithm.sort;

import com.algorithm.sort.ONLogN.ShellSortService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShellSortTest {

    @Test
    public void test2() {
        ShellSortService shellSortService = new ShellSortService();
        int[] inputs = {2,3,5,6,1,0};
        shellSortService.sortv2(inputs);
        for(int i=0; i < inputs.length; i++) {
            System.out.print(inputs[i]);
        }
        System.out.println();
    }
}
