package com.zlikun.learning;

import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/9/7 11:07
 */
public class OptionalTest {

    /**
     * Optional<T>对象或者是对T类型对象的封装，或者表示不是任何对象。但它比T类型的引用更安全，因为它不会返回null
     */
    @Test
    public void test() {

        // 当Stream空时，取得Optional对象中的值为空，通过#isPresent()判断
        Optional<Object> optional0 = Stream.empty().findFirst() ;
        Assert.assertFalse(optional0.isPresent());

        // #get()封装的值
        Optional<String> optional2 = Stream.of("java" ,"tomcat" ,"spring" ,"redis").max(String::compareToIgnoreCase) ;
        if (optional2.isPresent()) {
            Assert.assertEquals("tomcat" ,optional2.get());
        }

        // #ifPresent()方法可以接收一个函数，如果存在可选值，就将值传递给函数，否则不进行任何操作
        optional2.ifPresent(System.out::println);

        // 当没有任何匹配项时，可以指定一个默认值
        Assert.assertEquals("kafka" ,optional0.orElse("kafka")) ;
        Assert.assertEquals("tomcat" ,optional2.orElse("kafka")) ;

        // 也可以通过一个Lambda表达式来计算默认值
        System.out.println(optional0.orElseGet(() -> System.getenv("JAVA_HOME")));

        // 如果希望没有值的时候抛出一个异常
        try {
            optional0.orElseThrow(NoSuchElementException::new) ;
            Assert.fail();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        // Optional也包含一些静态方法
        Optional<String> optional3 = Optional.of("zlikun") ;        // 返回一个包含值的Optional实例
        Optional<String> optional4 = Optional.ofNullable(null) ;    // 如果值为空，返回#empty()，否则返回#of()
        Optional<String> optional5 = Optional.empty() ;             // 返回一个不包含值的Optional实例

    }

}
