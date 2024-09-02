package com.test.study.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * java8 list链式操作
 * @USER: xujingrui3
 * @DATE: 2019/10/14
 **/
public class Java8ListStream {
    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        stringCollection
                .stream()
                .filter((s) -> {
                    return s.equals("bbb2");
                })
                .forEach(System.out::println);
        stringCollection.stream().sorted().filter((a) -> a.startsWith("a")).forEach(System.out :: println);
        System.out.println(stringCollection);

        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);
}
}
