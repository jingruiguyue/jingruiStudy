package com.test.study.java8;

import java.util.HashMap;
import java.util.Map;

/**
 * @PACKAGE_NAME: com.jing.rui.study.java8
 * @USER: xujingrui3
 * @DATE: 2019/10/15
 **/
public class Java8MapMain {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        map.forEach((id, val) -> {
            val = val+"HHHH";
            System.out.println(val);
        });

    }
}
