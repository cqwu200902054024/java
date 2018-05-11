package net.cqwu.bridge;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:  桥接模式。抽象部分
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
public abstract class Image {
    protected ImageImp imageImp;

    public void set(ImageImp imageImp) {
        this.imageImp = imageImp;
    }

    public abstract void parseFile(String filePath);
}
