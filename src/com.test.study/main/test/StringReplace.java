package com.test.study.main.test;

import java.math.BigDecimal;

/**
 * @PACKAGE_NAME: com.test.study.main.test
 * @USER: xujingrui3
 * @DATE: 2019/12/13
 **/
public class StringReplace {
    public static void main(String[] args) {
        String cycle = "asdf一水电费水七电费二dfs三四五";
        if(cycle.contains("七")){
            cycle = cycle.replace("七","日");
        }
        String[] week = new String[]{"一","二","三","四","五","六","日"};
        StringBuilder tempBuilder = new StringBuilder();
        for (String s : week) {
            if(cycle.contains(s)){
                tempBuilder.append(s);
            }
        }
        System.out.println("字符_的："+'_');
        System.out.println("字符.的："+'.');
        int aaa = '_';
        System.out.println("字符_的："+aaa);
        int bbb = '.';
        System.out.println("字符.的："+bbb);
        System.out.println("打印结果是："+tempBuilder.toString());
        int tempSecond = 88;
        int oldSecond = tempSecond;
        System.out.println("oldSecond="+oldSecond);
        tempSecond = 60;
        double dou = 60.0;
        System.out.println("tempSecond="+tempSecond);
        BigDecimal ddd = new BigDecimal("88");
        BigDecimal edaf = ddd.divide(BigDecimal.valueOf(60), 2, BigDecimal.ROUND_HALF_UP);
        BigDecimal dig = new BigDecimal(oldSecond*(1/dou));
        System.out.println("超长广告系数："+edaf);

    }
}
