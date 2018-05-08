package net.cqwu.singleton;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:  单例模式
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.singleton
 *
 * @author： Administrator
 * Create Date：  2018-05-04
 * Modified By：   Administrator
 * Modified Date:  2018-05-04
 * Why & What is modified
 * Version:        V1.0
 */
public class Singleton {
    private Singleton(){}
    private static Singleton singleton;

    public static Singleton getInstance() {
        if(singleton == null) {
            synchronized (Singleton.class) {
                if(singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public void test() {
        System.out.println("创建单例模式。。。。");
    }
}
