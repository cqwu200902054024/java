package net.cqwu.classicalproblemalgorithm;

import org.junit.Test;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.classicalproblemalgorithm
 *
 * @author： p.z
 * Create Date：  2017-12-26
 * Modified By：   Administrator
 * Modified Date:  2017-12-26
 * Why & What is modified
 * Version:        V1.0
 */
public class LineSeparator {

    @Test
    public void testLineSeparator() {
        //获取操作系统文件的换行符
        System.out.println("windows换行符：" +System.lineSeparator().equals("\r\n"));
       // (key.hashCode() & Integer.MAX_VALUE) % numReduceTasks
        System.out.println(7 % 5);
        System.out.println((7 & Integer.MAX_VALUE));
        System.out.println((7 & 8));
        System.out.println((7 & 2) % 5);
        String radix2 = "0000000000000000000000000000" + Integer.toBinaryString(7);
        System.out.println(radix2);
        System.out.println(Integer.parseInt(radix2,2));
        System.out.println(Long.toBinaryString(Long.MAX_VALUE));
        long start = System.nanoTime();
        int res = 712121212 % 232323;
        System.out.println(System.nanoTime() - start);
        long s = System.nanoTime();
        int ress = (712121212 & Integer.MAX_VALUE) % 232323;
        System.out.println(System.nanoTime() - s);
        System.out.println();
    }
}