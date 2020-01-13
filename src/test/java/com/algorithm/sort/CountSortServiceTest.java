package com.algorithm.sort;

import com.algorithm.sort.ON.CountSortService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountSortServiceTest {

    @Test
    public void test() {
        CountSortService countSortService = new CountSortService();
        int[] inputs = new int[]{2,3,5,1,9,6};
        countSortService.sort(inputs);
    }
}
