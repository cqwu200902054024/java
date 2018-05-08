package net.cqwu.factorymethod.abstractfactory;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.factorymethod.abstractfactory
 *
 * @author： Administrator
 * Create Date：  2018-05-04
 * Modified By：   Administrator
 * Modified Date:  2018-05-04
 * Why & What is modified
 * Version:        V1.0
 */
public class FactoryProducer {
    public static AbstractFactory builder(String factory) {
        switch (factory) {
            case "COLOR":
                System.out.println("COLOR.....");
                return new ColorFactory();
            case "SHAPE":
                return new ShapeFactory();
            default:
                return null;
        }
    }
}
