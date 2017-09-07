package com.zlikun.learning;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/9/6 11:34
 */
public class StreamMethodTest {

    @Test
    public void test() {

        String [] array  = {"A" ,"B" ,"C"} ;

        // 过滤出首字母大于A的
        Arrays.stream(array).filter(w -> w.charAt(0) > 'A').forEach(System.out::println);

        // 将字母转换为小写 [方法表达式 / Lambda表达式]
        Arrays.stream(array).map(String::toLowerCase).forEach(System.out::println);
        Arrays.stream(array).map(s -> s.toLowerCase()).forEach(System.out::println);

        // 转换为数字列表，使用map方法时，会对每一个元素应用函数，并将值写入到一个新的Stream中
        Arrays.stream(array).map(s -> (int) s.charAt(0)).forEach(System.out::println);

        // 提取子流，类似截取，从一个无限长度的随机数字流中提取前4个值
        Stream.generate(Math::random).limit(4).forEach(System.out::println);

        // skip操作与limit操作相反，为丢弃前N个元素
        Arrays.stream(array).skip(2).forEach(System.out::println);

        // 合并两个Stream，其中第一个Stream不能是无限的，否则第二个Stream永远无法添加到第一个Stream后面
        Stream.concat(Arrays.stream(array) ,Stream.generate(Math::random).limit(4)).forEach(System.out::println);

        // peek方法会产生另一个与原始流具有相同元素的流，但在每次获取一个元素时，都会调用一个函数，便于调试
        Object [] powers = Stream.iterate(1.0 ,p -> p * 2).peek(e -> System.out.println("Fetching " + e)).limit(7).toArray() ;

    }

}
