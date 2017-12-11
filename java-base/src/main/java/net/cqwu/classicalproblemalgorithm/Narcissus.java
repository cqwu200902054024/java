package net.cqwu.classicalproblemalgorithm;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:   水仙数
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.classicalproblemalgorithm
 * Author：             Administrator
 * Create Date：  2017-12-11
 * Modified By：   Administrator
 * Modified Date:  2017-12-11
 * Why & What is modified
 * Version:        V1.0
 */
public class Narcissus {
    public void findNarcissus() {
        for(int i = 100; i < 1000; i ++) {
           int b = i / 100;
           int s = (i - 100 * b) / 10;
           int g = i - 100 * b - s * 10;
            if(i == b * b * b + s * s *s + g * g * g) {
                System.out.println(i);
            }
        }
    }
}
