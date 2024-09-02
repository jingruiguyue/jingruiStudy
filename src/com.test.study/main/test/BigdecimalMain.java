package com.test.study.main.test;

import java.math.BigDecimal;

/**
 * @PACKAGE_NAME: com.test.study.main.test
 * @USER: xujingrui3
 * @DATE: 2020/2/18
 **/
public class BigdecimalMain {
    public static void main(String[] args) {
        BigDecimal SMALL_ONE_RATIO = new BigDecimal("0.9");
        /**
         * 提交OA审批的大于1的比较系数
         */
        BigDecimal BIG_ONE_RATIO = new BigDecimal("1.05");
        BigDecimal sumPlanBudget = new BigDecimal("0.900");
        boolean res = SMALL_ONE_RATIO.compareTo(sumPlanBudget) > 0;
        System.out.println("比较结果："+new BigDecimal(-1));

    }
}
