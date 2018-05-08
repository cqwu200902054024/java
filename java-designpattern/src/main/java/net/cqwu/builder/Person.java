package net.cqwu.builder;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:    构造器模式
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.factorymethod.builder
 *
 * @author： p.z
 * Create Date：  2018-05-07
 * Modified By：   p.z
 * Modified Date:  2018-05-07
 * Why & What is modified
 * Version:        V1.0
 */
public class Person {
    private final String name;
    private final int age;
    private final String address;
    private final String phone;

    public static class Builder {
        private  String name;
        private  int age;
        private  String address;
        private  String phone;

        public Builder(String name,int age) {
            this.name = name;
            this.age = age;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        /**
         * 必须有个方法返回构造实体
         * @return
         */
        public Person builder() {
           return new Person(this);
        }
    }

    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
        this.phone = builder.phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
