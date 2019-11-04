package com.test.study.java8;

/**
 * @PACKAGE_NAME: Lambda表达访问成员变量和静态变量
 * @USER: xujingrui3
 * @DATE: 2019/10/14
 **/
public class LambdaBaseAccess {
    static int outerStaticNum;
    int outerNum;

    Converter<Integer, String> stringConverter1 = (from) -> {
        outerNum = 23;
        return String.valueOf(from);
    };

    void testScopes() {

        //Predicate
        //Function
        //Optional
        int temp =10;
        Converter<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };

        String tempStr = stringConverter1.convert(temp);
        System.out.println(tempStr);
        Converter<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };

    }
}
