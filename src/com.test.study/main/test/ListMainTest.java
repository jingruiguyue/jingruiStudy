package com.test.study.main.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListMainTest {
    public static void main(String[] args) {
        List<Integer> list = Collections.synchronizedList(new ArrayList());
    }
}
