package com.test.study.baseTest;

import java.util.*;

/**
 * Created by xujingrui3 on 2019/4/17.
 */
public class TestKeySort {

    public static void main(String[] args) {

//        test1();
//        test2();
        test3();
    }

    /*
        单数字：写入无序，读取按照key顺序排列
     */
    private static void test3() {

        HashMap<String,String> map = new HashMap<>();
        map.put("3","gopfm3");
        map.put("20","dfkgjdk20");
        map.put("40","xviou40");
        map.put("15","dfiug15");
        map.put("48","gopfm48");
        map.put("27","dfkgjdk27");
        map.put("46","xviou46");
        map.put("12","dfiug12");
        map.put("33","gopfm33");
        map.put("24","dfkgjdk24");
        map.put("48","xviou48");
        map.put("1","dfiug1");
        Set<String> set = map.keySet();
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        for(String key : list){
            System.out.println("获取到的key"+key);
            String value = map.get(key);////集合中的key是有序而且唯一
            System.out.println("获取到的value:"+value);
        }
    }

   /*
        单字符：写入无序，读取按照key顺序排列
     */

    private static void test2() {
        //1.创建一个HashMap集合对象,可以:存储每行文本的序号(1,2,3,..);value:存储每行的文本
        HashMap<String,String> map = new HashMap<>();
        map.put("c","gopfm");
        map.put("a","dfkgjdk");
        map.put("b","xviou");
        map.put("d","dfiug");

        for(String key : map.keySet()){
            System.out.println(key);
            String value = map.get(key);//集合中的key是有序而且唯一
        }
    }

    /*
        显示多字符串：写入，读取，无序
     */
    private static void test1() {
        //1.创建一个HashMap集合对象,可以:存储每行文本的序号(1,2,3,..);value:存储每行的文本
        HashMap<String,String> map = new HashMap<>();
        map.put("casd","gopfm");
        map.put("aas","dfkgjdk");
        map.put("bzxc","xviou");
        map.put("dwqeqw","dfiug");

        for(String key : map.keySet()){
            System.out.println(key);
            String value = map.get(key);//集合中的key是有序而且唯一
        }

    }
}
