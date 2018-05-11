package net.cqwu.bridge;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.bridge
 *
 * @author： Administrator
 * Create Date：  2018-05-10
 * Modified By：   Administrator
 * Modified Date:  2018-05-10
 * Why & What is modified
 * Version:        V1.0
 */
public class JPGImage extends Image {
    @Override
    public void parseFile(String filePath) {
        this.imageImp.doPaint(new Matrix());
        System.out.println(filePath + ",格式为jpg");
    }
}
