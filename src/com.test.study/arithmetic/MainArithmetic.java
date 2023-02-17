package com.test.study.arithmetic;

import java.util.Arrays;

/**
 * @PACKAGE_NAME: com.xu.study.jingruistudy.arithmetic
 * @USER: xujingrui3
 * @DATE: 2019/10/24
 **/
public class MainArithmetic<main> {

    public static void main(String[] args) {
        Integer[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};

        ArithmeticUtil.quickSort(arr,0,arr.length-1);
        Arrays.asList(arr).forEach(a -> System.out.print(" "+a));
        System.out.println("结果是啥" +Arrays.toString(arr));
    }
}
