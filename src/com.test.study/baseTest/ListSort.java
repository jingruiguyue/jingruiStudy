package com.test.study.baseTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xujingrui3 on 2019/4/28.
 */
public class ListSort {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<Student>();

        //创建3个学生对象，年龄分别是20、19、21，并将他们依次放入List中
        Student s1 = new Student();
        s1.setAge(20);
        s1.setName("葛大");
        Student s2 = new Student();
        s2.setAge(19);
        s2.setName("张杰");
        Student s3 = new Student();
        s3.setAge(21);
        s3.setName("宝爷");
        list.add(s1);
        list.add(s2);
        list.add(s3);

       // System.out.println("排序前：" + list);

        Collections.sort(list, new Comparator<Student>() {

            /*
             * int compare(Student o1, Student o2) 返回一个基本类型的整型，
             * 返回负数表示：o1 小于o2，
             * 返回0 表示：o1和o2相等，
             * 返回正数表示：o1大于o2。
             */
            public int compare(Student o1, Student o2) {

                //按照学生的年龄进行升序排列  ;<是降序
//                    /*if(o1.getAge() > o2.getAge()){
//                        return 1;
//                    }
//                    if(o1.getAge() == o2.getAge()){
//                        return 0;
//                    }
//                    return -1;  */
//                    return o1.getAge()-o2.getAge();//升序
//                    return o2.getAge()-o1.getAge();//降序
                return o1.getName().compareTo(o2.getName());// 按照姓名升序
//                    return o2.getName().compareTo(o1.getName()) ;// 按照姓名降序
            }
        });
        List<Student> temp = new ArrayList<>();
        int sortNo = -1;
        for (int i = 0; i < list.size(); i++) {
            temp.add(list.get(i));
            System.out.println("跑了第"+i+"次");
            if(temp.size() == 2 && i != list.size()-1){
                sortNo = i++;
                System.out.println("if结束了+"+sortNo);
                break;
            }else{
                sortNo = 0;
                System.out.println("else结束了+"+sortNo);
                break;
            }
        }
        //System.out.println("排序后："+list);
    }
}
