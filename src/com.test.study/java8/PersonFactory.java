package com.test.study.java8;

public interface PersonFactory<P extends Person> {
    P createPerson(String a, String b);
}
