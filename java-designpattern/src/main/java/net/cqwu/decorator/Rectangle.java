package net.cqwu.decorator;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.decorator
 *
 * @author： Administrator
 * Create Date：  2018-05-15
 * Modified By：   Administrator
 * Modified Date:  2018-05-15
 * Why & What is modified
 * Version:        V1.0
 */
public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("draw Rectangle .....");
    }
}
