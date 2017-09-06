package com.zlikun.learning;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * 单词统计测试
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/9/6 9:37
 */
public class WordCountTest {

    private List<String> words ;

    @Before
    public void init() throws IOException {
        // 读取当前工程的pom.xml文件
        String contents = new String(Files.readAllBytes(Paths.get("pom.xml")) , StandardCharsets.UTF_8) ;

        // 拆分出其全部单词(这里以空格、非字母、数字、点、中横线字符为单词分隔符)，仅用于演示，请勿深究是否准确
        words = Arrays.asList(contents.split("(\\s|[^0-9a-zA-Z-\\.])+")) ;
    }

    @Test
    public void test() throws IOException {

        // 使用迭代方式计算长度超过7个字符的单词次数
        int count = 0 ;
        for (String word : words) {
            if (word.length() > 7) count ++ ;
        }

        System.out.println(count);  // 16

        // 使用stream实现上述需求，与之区别在于，前者很难并发计算，而后者可以(具体怎么做？)
        // Java8在Collection接口中添加的stream方法，可以将任意子类集合转化为一个tream，如果是数组的话可以使用静态Stream.of方法转换为一个Stream
        long count2 = words.stream().filter(w -> w.length() > 7).count() ;
        System.out.println(count2); // 16

    }

}
