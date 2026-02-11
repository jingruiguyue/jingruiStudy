package com.test.study.arithmetic;

/**
 * @ClassName StringFanZhuan
 * @Description
 * @Author xujingrui
 * @Date 2026/1/6 16:48
 */
public class StringFanZhuan {
    public static void main(String[] args) {
        String name = "123456789";
        char[] arr = name.toCharArray();
        for (int i = 0; i < arr.length/2; i++) {

            char ch = arr[i];
            System.out.println("过程:"+ch);
            arr[i] = arr[arr.length - 1 - i];
            System.out.println("arr[i]:"+arr[i]);
            arr[arr.length - 1 - i] = ch;

        }

        System.out.println("最终结果:"+String.valueOf(arr));
    }
}
