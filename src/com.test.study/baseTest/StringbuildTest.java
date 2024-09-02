package com.test.study.baseTest;

/**
 * Created by xujingrui3 on 2019/4/27.
 */
public class StringbuildTest {
    public static void main(String[] args) {
        StringBuffer bu = new StringBuffer();
        bu.append("abd");
        bu.append("sdwd");
        System.out.println(bu);
        System.out.println("buffer"+ bu);

        StringBuilder builder = new StringBuilder();
        builder.append("abc");
        builder.append("welsdf");
        System.out.println(builder);
        System.out.println("build"+ builder);
    }
}
