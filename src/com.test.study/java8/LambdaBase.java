package com.test.study.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @PACKAGE_NAME: com.jing.rui.study.java8
 * @USER: xujingrui3
 * @DATE: 2019/10/14
 **/
public class LambdaBase {
    public static void main(String[] args) {
        List<String> namesList = Arrays.asList("zhangsan","lisi","wangwu");
        namesList.forEach(a -> System.out.println("集合中的名字：" + a));

        Collections.sort(namesList,(String a,String b) -> a.compareTo(b));

        namesList.forEach(str -> System.out.print(str + "_"));

        Collections.sort(namesList,(a,b) -> {
            return b.compareTo(a);
        });
    }
}
