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
public class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shape) {
        switch (shape) {
            case "rectangle":
                return new Rectangle();
            case "square":
                return new Square();
            case "circle":
                return new Circle();
             default:
                 return null;
        }
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
