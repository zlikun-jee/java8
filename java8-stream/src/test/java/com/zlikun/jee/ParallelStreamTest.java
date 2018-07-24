package com.zlikun.jee;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * 并行流，不能用于排序操作，出来仍是乱序，但可以用来计数等
 *
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018/7/24 18:36
 */
public class ParallelStreamTest {

    @Test
    public void test() {

        // 1000万条数据，硬件：i7-4790 CPU @ 3.6GHz，16GB内存
        int count = 10_000_000;
        List<Double> list = Stream.generate(Math::random)
                .limit(count)
                .collect(Collectors.toList());

        long begin = System.currentTimeMillis();
        long m = list.stream()
                .filter(x -> x > 0.5)
                .count();
        // 程序执行耗时：81 毫秒!
        System.out.println(String.format("程序执行耗时：%d 毫秒!", System.currentTimeMillis() - begin));

        begin = System.currentTimeMillis();
        long n = list.parallelStream()
                .filter(x -> x > 0.5)
                .count();
        // 程序执行耗时：38 毫秒!
        System.out.println(String.format("程序执行耗时：%d 毫秒!", System.currentTimeMillis() - begin));

        assertEquals(m, n);
    }

}
