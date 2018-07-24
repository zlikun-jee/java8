package com.zlikun.jee;

import org.junit.Test;

import java.util.Arrays;

/**
 * 使用 map-reduce 实现最大、最小、求和等操作
 *
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018/7/24 17:49
 */
public class ReduceTest {

    @Test
    public void max() {
        int[] array = {1, 7, 5, 4, 2, 3};

        // 使用Stream内置max()函数实现取最大值
        System.out.println(Arrays.stream(array).max().getAsInt());  // 7

        // 使用reduce()函数自行实现
        System.out.println(Arrays.stream(array)
                .reduce(Math::max)
                .getAsInt()
        );
    }

    @Test
    public void sum() {
        int[] array = {1, 7, 5, 4, 2, 3};

        System.out.println(Arrays.stream(array).sum());             // 22

        System.out.println(Arrays.stream(array)
                .reduce((x, y) -> x + y)
                .getAsInt()
        );

    }

}
