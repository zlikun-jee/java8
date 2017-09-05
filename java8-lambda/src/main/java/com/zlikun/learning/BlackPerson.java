package com.zlikun.learning;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/9/5 10:21
 */
public class BlackPerson implements Person {
    @Override
    public String color() {
        return "黑种人";
    }

    @Override
    public void walk() {
        System.out.println("黑种人也是两条腿走路。。。");
    }
}
