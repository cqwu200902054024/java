package net.cqwu.composite;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.composite
 *
 * @author： Administrator
 * Create Date：  2018-05-14
 * Modified By：   Administrator
 * Modified Date:  2018-05-14
 * Why & What is modified
 * Version:        V1.0
 */
public abstract class Component {
    public abstract void add(Component c);
    public abstract void remove(Component c);
    public abstract Component getChild(int i);
    public abstract void operation();
}
