package net.cqwu.composite;

import java.io.IOException;

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
 * Modified By：   p.z
 * Modified Date:  2018-05-14
 * Why & What is modified
 * Version:        V1.0
 */
public class Leaf extends Component {
    @Override
    public void add(Component c) {
        throw new RuntimeException("叶子节点无法添加");
    }

    @Override
    public void remove(Component c) {
        throw new RuntimeException("无法删除元素");
    }

    @Override
    public Component getChild(int i) {
        throw new RuntimeException("没有子节点");
    }

    @Override
    public void operation() {
        System.out.println("查看文件内容。。。。。。");
    }
}
