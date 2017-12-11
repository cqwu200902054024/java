package net.cqwu.classicalproblemalgorithm;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:  找两个数之间的素数
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.classicalproblemalgorithm
 * Author：             Administrator
 * Create Date：  2017-12-11
 * Modified By：   Administrator
 * Modified Date:  2017-12-11
 * Why & What is modified
 * Version:        V1.0
 */

public class Prime {

    public long findPrime(long start,long end) {
        long sum = 0L;
        for(long i = start; i <= end; i ++) {
           boolean isFind = true;
           for(long j = 2; j <= Math.sqrt(i); j ++) {
               if(i % j == 0) {
                   isFind = false;
                   break;
               }
           }
           if(isFind) {
               System.out.println(i);
               sum ++;
           }
        }
        return sum;
    }
}
