package com.liuh.realmlearn;

import io.realm.RealmModel;
import io.realm.annotations.RealmClass;

/**
 * Date: 2018/3/13 13:55
 * Description:
 */
@RealmClass
public class User2 implements RealmModel {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
