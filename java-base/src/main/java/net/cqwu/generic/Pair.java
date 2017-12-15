package net.cqwu.generic;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:  泛型学习
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.generic
 * Author：             Administrator
 * Create Date：  2017-12-15
 * Modified By：   Administrator
 * Modified Date:  2017-12-15
 * Why & What is modified
 * Version:        V1.0
 */
public class Pair<K,V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
