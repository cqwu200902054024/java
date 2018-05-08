package net.cqwu.protopyte;

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
public abstract class Shape  implements Cloneable{
    private String id;
    private String type;
    public abstract void draw();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    protected Shape clone() throws CloneNotSupportedException {
        return (Shape)super.clone();
    }
}
