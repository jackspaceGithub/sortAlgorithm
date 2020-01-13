package com.algorithm.sort;


import com.algorithm.sort.ON.BucketSortService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BucketSortTest {

    @Test
    public void test() {
        BucketSortService sortService = new BucketSortService();
        double[] list = new double[]{4.5, 0.84, 3.25, 2.18, 0.5, 0.1, 3.49};
        sortService.sort(list);
        sortService.sortv2(list);
    }
}
