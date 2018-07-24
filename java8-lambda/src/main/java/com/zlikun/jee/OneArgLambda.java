package com.zlikun.jee;

/**
 * 定义一个只有一个参数的Lambda表达式接口（只是为了测试，没有实际意义），
 * 使用 @FunctionalInterface 注解修饰（非必要，只是为了能使IDE检查语法正确性），
 * 使用该注解标识的接口是一个Lambda表达式接口，只能有一个抽象方法，default方法不算在内
 *
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018/7/24 17:17
 * @see java.util.function.Function
 */
@FunctionalInterface
public interface OneArgLambda<T> {

    T apply(T t);

}
