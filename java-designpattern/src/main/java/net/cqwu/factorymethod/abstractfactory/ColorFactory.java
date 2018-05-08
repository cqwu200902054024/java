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
public class ColorFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shape) {
        return null;
    }

    @Override
    public Color getColor(String color) {
        switch (color) {
            case "red":
                System.out.println("red======");
               return new Red();
            case "blue":
                return new Blue();
            case "green":
                return  new Green();
            default:
                return null;
        }
    }
}
