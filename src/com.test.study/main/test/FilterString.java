package com.test.study.main.test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @PACKAGE_NAME: com.test.study.main.test
 * @USER: xujingrui3
 * @DATE: 2019/12/12
 **/
public class FilterString {
        /**
         *
         * @Title : filterNumber
         * @Type : FilterStr
         * @date : 2014年3月12日 下午7:23:03
         * @Description : 过滤出数字
         * @return
         */
        public static String filterNumber(String number)
        {
            number = number.replaceAll("[^(0-9)]", "");
            return number;
        }

        /**
         *
         * @Title : filterAlphabet
         * @Type : FilterStr
         * @date : 2014年3月12日 下午7:28:54
         * @Description : 过滤出字母
         * @param alph
         * @return
         */
        public static String filterAlphabet(String alph)
        {
            alph = alph.replaceAll("[^(A-Za-z)]", "");
            return alph;
        }

        /**
         *
         * @Title : filterChinese
         * @Type : FilterStr
         * @date : 2014年3月12日 下午9:12:37
         * @Description : 过滤出中文
         * @param chin
         * @return
         */
        public static String filterChinese(String chin)
        {
            chin = chin.replaceAll("[^(\\u4e00-\\u9fa5)]", "");
            return chin;
        }

        /**
         *
         * @Title : filter
         * @Type : FilterStr
         * @date : 2014年3月12日 下午9:17:22
         * @Description : 过滤出字母、数字和中文
         * @param character
         * @return
         */
        public static String filter(String character)
        {
            character = character.replaceAll("[^(a-zA-Z0-9\\u4e00-\\u9fa5)]", "");
            return character;
        }
        private static final Pattern pattern = Pattern.compile("[^(a-zA-Z0-9\\u4e00-\\u9fa5)]");
        /**
         * @Title : main
         * @Type : FilterStr
         * @date : 2014年3月12日 下午7:18:22
         * @Description :
         * @param args
         */
        public static void main(String[] args)
        {
//            /**
//             * 声明字符串str
//             */
//            String str = "$%$%$张三34584yuojk李四@#￥#%%￥……%&";
//            /**
//             * 调用过滤出字母、数字和中文的方法
//             */
//            Matcher m = pattern.matcher(str);
//            /**
//             * 打印结果
//             */
//            System.out.println("过滤出字母、数字和中文：" + m.replaceAll("^"));

//            int temp = Double.valueOf("5.9").intValue();
//            System.out.println("结果："+temp);

            BigDecimal tem = BigDecimal.ONE;
            tem = tem.add(new BigDecimal("6"));
            System.out.println(tem);
            System.out.println(tem);

        }

}
