package com.zlikun.learning;

import org.junit.Test;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/9/5 10:13
 */
public class PersonTest {

    /**
     * 测试结论：默认方法被所有子类拥有(个人作为这使得接口与抽象类之间的区别变得更小了)
     */
    @Test
    public void walk() {

        YellowPerson yp = new YellowPerson() ;
        // [黄种人]两条腿走路 。。。
        yp.walk();

        WhitePerson wp = new WhitePerson() ;
        // [白种人]两条腿走路 。。。
        wp.walk();

        // 默认方法可以被重写
        BlackPerson bp = new BlackPerson() ;
        // 黑种人也是两条腿走路。。。
        bp.walk();
    }

}
