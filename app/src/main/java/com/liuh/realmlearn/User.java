package com.liuh.realmlearn;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Date: 2018/3/13 13:54
 * Description:除了直接继承RealmObject来声明Realm数据模型之外,还可以通过实现RealmModel接口并添加@RealmClass修饰符来声明
 */

public class User extends RealmObject {

    @PrimaryKey//主键
    private String id;
    @Required//不能为空
    private String name;

    private int age;
    @Ignore//忽略该字段,存储数据时会忽略该字段
    private int sex;//性别:1,男;2,女

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
