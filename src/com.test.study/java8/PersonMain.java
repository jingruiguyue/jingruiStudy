package com.test.study.java8;

/**
 * @PACKAGE_NAME: com.jing.rui.study.java8
 * @USER: xujingrui3
 * @DATE: 2019/10/14
 **/
public class PersonMain {
    public static void main(String[] args) {
        PersonFactory<Person> personMethod = Person::new;
        Person tempPerson = personMethod.createPerson("大兵","xiaowu");
        System.out.println("jieguo:"+tempPerson.firstName);
    }
}
