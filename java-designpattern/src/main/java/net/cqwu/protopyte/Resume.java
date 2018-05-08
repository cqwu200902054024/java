package net.cqwu.protopyte;

import java.io.*;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.protopyte
 *
 * @author： Administrator
 * Create Date：  2018-05-08
 * Modified By：   Administrator
 * Modified Date:  2018-05-08
 * Why & What is modified
 * Version:        V1.0
 */
public class Resume implements Cloneable,Serializable{
    private String name;
    private int age;
    private WorkExperience workExperience;

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

    public WorkExperience getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(WorkExperience workExperience) {
        this.workExperience = workExperience;
    }

    /**
     * 浅拷贝
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Resume clone() throws CloneNotSupportedException {
        return (Resume)super.clone();
    }

    /**
     * 深copy
     * @return
     */
    public Resume deepClone() throws CloneNotSupportedException{
        Resume resume = this.clone();
        resume.workExperience = this.workExperience.clone();
        return resume;
    }

    /**
     * 通过序列化方式进行深度拷贝
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Resume deepClone0() throws IOException,ClassNotFoundException {
        //将对象写入字节流中
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        //从字节流读取对象
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (Resume)ois.readObject();
    }
}
