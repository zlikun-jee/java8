package com.zlikun.learning;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/9/5 10:06
 */
public interface Person {

    String color() ;

    default void walk() {
        System.out.println(String.format("[%s]两条腿走路 。。。" ,color()));
    }

}
