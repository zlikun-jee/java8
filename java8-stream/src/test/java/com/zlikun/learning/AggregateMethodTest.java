package com.zlikun.learning;

import org.junit.Test;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * 聚合方法
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/9/7 10:54
 */
public class AggregateMethodTest {

    /**
     * 聚合方法都是终止操作，当流执行终止操作后，就不能再进行其它流操作了
     */
    @Test
    public void test() {

        // 获取最大值，同理min方法用于获取最小值
        Optional<String> optional = Stream.of("java" ,"tomcat" ,"spring" ,"redis").max(String::compareToIgnoreCase) ;
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }

        // 获取元素数量
        System.out.println(Stream.of("java" ,"tomcat" ,"spring" ,"redis").count());

        // findFirst方法会返回非空集合第一个值
        System.out.println(Stream.of("java" ,"tomcat" ,"spring" ,"redis" ,"struts").filter(s -> s.startsWith("s")).findFirst().get());

        // findAny返回任一匹配元素，parallel方法用于实现并行计算
        System.out.println(Stream.of("java" ,"tomcat" ,"spring" ,"redis" ,"jetty").parallel().filter(s -> s.startsWith("j")).findAny().get());

        // anyMatch方法判断流中是否包含匹配的元素，与之相对还有allMatch和noneMatch两个方法，该系方法虽然会检查整个流，但可以通过并行执行加速
        System.out.println(Stream.of("java" ,"tomcat" ,"spring" ,"redis" ,"jetty").parallel().anyMatch(s -> s.startsWith("r")));

    }

}
