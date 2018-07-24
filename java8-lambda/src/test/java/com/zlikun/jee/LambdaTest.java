package com.zlikun.jee;

import org.junit.Test;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Lambda 基本示例
 *
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018/7/24 17:09
 */
public class LambdaTest {

    @Test
    public void test() throws InterruptedException {

        // 无参Lambda表达式
        // 这里我们在表达式中并未指定返回值类型，而javac会根据程序的上下文自动推断出表达式返回值类型
        // 这里根据声明的Runnable参数，可以推断出表达式是Runnable的实例
        Runnable noArgs = () -> System.out.println("Hello !");
        // 我们可以启动一个线程来执行这个Runnable
        new Thread(noArgs).start();
        // 上述代码等同于
        new Thread(() -> System.out.println("Hello !!")).start();

        // 一个参数的Lambda表达式
//        Function<Integer, Integer> oneArg = x -> x * x;
        OneArgLambda<Integer> oneArg = x -> x * x;
        System.out.println(oneArg.apply(4));      // 16

        // 多个参数的Lambda表达式，javac根据上下文自动推断参数(x, y)的类型为Integer
        BinaryOperator<Integer> add = (x, y) -> x + y;
        System.out.println(add.apply(4, 5));    // 9

        // 另外Lambda除了是一个表达式还可以是一个代码块(这里用于生成一个斐波那契数列)
        new Thread(() -> {
            List<Integer> list = Stream.of(0, 1).collect(Collectors.toList());
            for (int i = 2; i < 9; i++) {
                list.add(list.get(i - 1) + list.get(i - 2));
            }
            // [0, 1, 1, 2, 3, 5, 8, 13, 21]
            System.out.println(list);
        }).start();


        // 与测试无关，仅为了使个子线程可以正常运行完成
        Thread.currentThread().join(200L);

    }

}
