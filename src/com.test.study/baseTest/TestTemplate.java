package com.test.study.baseTest;

/**
 * @PACKAGE_NAME: com.jing.rui.study
 * @USER: xujingrui3
 * @DATE: 2019/6/10
 **/
public class TestTemplate {

    public static void main(String[] args) {
        String paramInfo ="";
        StringBuilder builder = new StringBuilder();
        String[] strA = {"A","M","N","O"};
        for (String str:strA) {
            builder.append(" skuInfo:").append(str)
                    .append("&").append(2);
        }
        paramInfo = builder.toString();
        System.out.println("拼接结果:"+paramInfo);
    }
}
