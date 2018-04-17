package net.cqwu.io;

import java.io.Serializable;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments: javabean - person
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.io
 *
 * @author： Administrator
 * Create Date：  2017-12-22
 * Modified By：   Administrator
 * Modified Date:  2017-12-22
 * Why & What is modified
 * Version:        V1.0
 */
public class Person implements Serializable {
    //设置序列化版本值
    private static final long serialVerisionUID = 1L ;
    private String name;
    private int age;
    private String sex;
    //忽略不序列化的属性，通过transient关键字
    private transient String idcard;

    public Person(String name, int age, String sex, String idcard) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.idcard = idcard;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", idcard='" + idcard + '\'' +
                '}';
    }
}