package net.cqwu.protopyte;

import java.util.Hashtable;
import java.util.Map;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:   从缓存的对象中返回一个clone对象
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
public class ShapeCache {
    private static Map<String,Shape> shaps = new Hashtable<String,Shape>(3);

    /**
     * 缓存需要缓存的对象
     */
    public static void loadShapes() {
        shaps.put("1",new Circle());
        shaps.put("2",new Rectangle());
        shaps.put("3",new Square());
    }

    /**
     * 从缓存的对象中获取一个copy对象
     * @param type
     * @return
     * @throws CloneNotSupportedException
     */
    public static Shape getShape(String type) throws CloneNotSupportedException{
        return shaps.get(type).clone();
    }
}
