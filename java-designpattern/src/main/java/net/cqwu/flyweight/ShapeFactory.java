package net.cqwu.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.flyweight
 *
 * @author： Administrator
 * Create Date：  2018-05-17
 * Modified By：   Administrator
 * Modified Date:  2018-05-17
 * Why & What is modified
 * Version:        V1.0
 */
public class ShapeFactory {
    private static Map<String,Shape> shapes = new HashMap<>();

    public static Shape getShape(String color) {
        Shape shape = shapes.get(color);
        if(shape == null) {
            shape = new Circle();
            ((Circle)shape).setColor(color);
            shapes.put(color,shape);
        }
        return shape;
    }
}