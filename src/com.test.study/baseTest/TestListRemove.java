package com.test.study.baseTest;

import java.util.Date;

/**
 * Created by xujingrui3 on 2019/4/18.
 */
public class TestListRemove {
    public static void main(String[] args) {


        Date date = new Date(1559631059809L);
        System.out.println("时间是："+date);

//        List<Person> list = new ArrayList<Person>();
//        for (int i = 1; i < 100; i++) {
//            Person person = new Person(i,"name+i"+i);
//            list.add(person);
//        }
//        System.out.println("addAll前总记录条数："+list.size());
//        list.addAll(list);
//        System.out.println("addAll后总记录条数："+list.size());
//        List<Person> resultList = new ArrayList<Person>(list);
//        System.out.println("移除前resultList记录条数："+resultList.size());
//        int length = resultList.size();
//        for (int i = 0; i < length; i++) {
//           resultList.remove(0);
//        }
//        System.out.println("原List的记录数："+list.size());
//
//        System.out.println("移除后resultList记录条数："+resultList.size());
    }
    static class Person{
        private int age;
        private String name;

        public Person(int age,String name){
            this.age = age;
            this.name = name;
        }
        public void setAge(int age){
            this.age = age;
        }
        public int getAge(){
            return this.age;
        }
        public void setName(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }
    }
}
