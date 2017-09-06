package com.zlikun.learning;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/9/6 9:58
 */
public class StreamTest {

    @Test
    public void collection() {
        Collection<String> colls = Arrays.asList("张三丰" ,"李煜" ,"张无忌") ;
        long count = colls.stream().filter(s -> s.startsWith("张")).count() ;
        System.out.println("姓`张`的姓名数量：" + count);
    }

    @Test
    public void array() {
        String [] array = {"张三丰" ,"李煜" ,"张无忌"} ;
        long count = Stream.of(array).filter(s -> s.startsWith("张")).count() ;
        // 下面方式也能实现数组转换为Stream
        // long count = Arrays.stream(array).filter(s -> s.startsWith("张")).count() ;
        System.out.println("姓`张`的姓名数量：" + count);
    }

    @Test
    public void empty() {
        // 创建一个不包含任何元素的Stream
        Stream<String> stream = Stream.empty() ;
        Assert.assertEquals(0 ,stream.count());
    }

    @Test
    public void usage() throws IOException {
        // 接收一个Supplier<T>接口实例(函数式接口)
        {
            Stream<String> stream = Stream.generate(() -> "Echo") ;
        }
        // 生成一个随机数Stream
        {
            Stream<Double> stream = Stream.generate(Math::random) ;
        }
        // 生成一个无限序列，接收一个seed(种子)和一个UnaryOperator<T>接口实例
        {
            Stream<BigInteger> stream = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
            // 打印前4个元素
            stream.limit(4).forEach(System.out::println);
        }
        // 正则表达式
        {
            // 语句单词拆分
            Pattern.compile("\\s+").splitAsStream("I have a dream !").forEach(System.out::println);
        }
        // 返回文件中所有行的Stream
        {
            Files.lines(Paths.get("pom.xml")).forEach(System.out::println);
        }

    }
}
