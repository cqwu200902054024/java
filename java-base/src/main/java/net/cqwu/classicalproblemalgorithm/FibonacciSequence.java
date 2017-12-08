package net.cqwu.classicalproblemalgorithm;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:   斐波那契数列:1,1,2,3,5,8,13,21
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.classicalproblemalgorithm
 * Author：             p.z
 * Create Date：  2017-12-08
 * Modified By：   Administrator
 * Modified Date:  2017-12-08
 * Why & What is modified
 * Version:        V1.0
 */
public class FibonacciSequence {
    private static final long FIRST = 1L;
    private static final long SECOND = 2L;
    public static void main(String[] args) {
        System.out.println(noRecurve(8) +"--" + recurve(8));
    }

    /**
     * 递归方式
     * @param num
     * @return
     */
    public static long recurve(long num) {
        if (num == FIRST || num == SECOND) {
            return 1;
        } else {
            return recurve(num - 1) + recurve(num - 2);
        }
    }

    /**
     * 非递归方式
     * @param num
     * @return
     */
    public static long noRecurve(long num) {
        long f1 = 1L;
        long f2 = 1L;
        long f = 0L;
        //1,1,2,3,5,8,13,21
        for(long i = 3;i <= num; i ++) {
             f = f1 + f2;
             f1 = f2;
             f2 = f;
        }
        return f;
    }
}
