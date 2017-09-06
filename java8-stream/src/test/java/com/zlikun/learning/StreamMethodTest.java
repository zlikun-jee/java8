package com.zlikun.learning;

import org.junit.Test;

import java.util.Arrays;

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

    }

}
