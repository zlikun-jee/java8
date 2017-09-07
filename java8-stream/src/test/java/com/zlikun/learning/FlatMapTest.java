package com.zlikun.learning;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * 本质上讲，flatMap()方法从字面意思是就把层级扁平化，也就是可以映射更底层的元素
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/9/7 11:29
 */
public class FlatMapTest {

    @Test
    public void test() {

        // Stream#flatMap()

        // Optional#flatMap()
        // 假设有方法 `Optional<T> f()` 和方法 `Optional<U> g()`，其中后者于`T`内
        // 如果通过s.f().g()将其组合，是不可行的，因为f()返回的是Optional<T>而不是T
        // 那么可以通过：`Optional<U> = s.f().flatMap(T::g)`来实现
        // 通过示例可知：第一次flatMap()方法映射的是把Optional封装的数据
        // 下面代码表示：先反转再求平方根
        Optional<Double> optional = Optional.of(-4.0).flatMap(this::inverse).flatMap(this::squareRoot) ;
        optional.ifPresent(v -> Assert.assertTrue(v == 2.0));
    }

    /**
     * 安全的平方根函数
     * @param x
     * @return
     */
    private Optional<Double> squareRoot(double x) {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x)) ;
    }

    /**
     * 安全的反转函数
     * @param x
     * @return
     */
    private Optional<Double> inverse(double x) {
        return Optional.of(0 - x) ;
    }

}
