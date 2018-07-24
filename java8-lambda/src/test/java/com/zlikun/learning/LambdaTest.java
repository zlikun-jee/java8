package com.zlikun.learning;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Lambda表达式基本使用示例
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/9/5 9:04
 */
public class LambdaTest {

    private void doWorker() {
        // TODO
    }

    @Test
    public void runnable() {

        // 声明一个实现Runnable接口的Worker，用于异步处理一段逻辑
        class Worker implements Runnable {
            @Override
            public void run() {
                doWorker();
            }
        }

        // 启动该Worker的一个实例，这是java8以前的写法
        new Thread(new Worker()).start();

        // 下面使用Lambda表达式实现相同功能
        new Thread(() -> doWorker()).start();

    }

    @Test
    public void sort() {

        List<String> list = Arrays.asList("A" ,"C" ,"B") ;
        // [A, C, B]
        System.out.println(list);

        // 使用Lambda表达式实现排序操作
        Collections.sort(list , String::compareTo);

        // [A, B, C]
        System.out.println(list);

        // 不区分大小写的排序
        list = Arrays.asList("D" ,"f" ,"E") ;
        // String::compareToIgnoreCase 方法引用，实际执行的是`x.compareToIgnoreCase(y)`，第一个参数会成为执行方法的对象，对应第三种方法引用规则
        Collections.sort(list ,String::compareToIgnoreCase);
        // [D, E, f]
        System.out.println(list);

    }

    @Test
    public void sleep() throws InterruptedException {
        // 由于run()方法不能抛出异常，因此需要处理该异常
        Runnable sleeper = () -> {
            try {
                System.out.println(System.currentTimeMillis());
                Thread.sleep(500L);
                System.out.println(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } ;
        Thread t = new Thread(sleeper) ;
        t.start();
        t.join();
    }

    @Test
    public void forEach() {
        Iterable<String> iterable = Arrays.asList("A" ,"B" ,"C") ;
        // A
        // B
        // C
        iterable.forEach(System.out::println);
    }

}
