package com.algorithm.sort;

import com.algorithm.sort.ON.RadixSortService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RadixSortTest {

    @Test
    public void test() {
        RadixSortService sortService = new RadixSortService();
        String[] strList = {"525482", "24545", "98345", "4", "124"};
        System.out.println(Arrays.toString(sortService.sort(strList, 6)));
    }
}
