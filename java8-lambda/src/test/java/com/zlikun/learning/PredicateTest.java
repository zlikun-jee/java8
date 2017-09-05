package com.zlikun.learning;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.Predicate;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/9/5 13:14
 */
public class PredicateTest {

    @Test
    public void test() {
        Predicate<String> predicate = (x) -> x.startsWith("A") ;
        Assert.assertTrue(predicate.test("A001"));
        Assert.assertFalse(predicate.test("B001"));
    }

}
