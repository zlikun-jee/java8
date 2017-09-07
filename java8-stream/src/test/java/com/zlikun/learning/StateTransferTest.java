package com.zlikun.learning;

import org.junit.Test;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Stream的状态转换
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/9/7 10:46
 */
public class StateTransferTest {

    @Test
    public void test() {

        // distinct() 方法会根据原始流中的元素返回一个与原始流相同顺序但抑制重复元素的新流(去重)，该操作是有状态的，它需要记住之前流的顺序
        Stream.of("zlikun" ,"john" ,"zlikun" ,"kevin").distinct().forEach(System.out::println);

        // 对一个流元素排序(这里按长度倒序)，该流不能是无限流
        Stream.of("java" ,"nginx" ,"tomcat" ,"shell").sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);

    }

}
