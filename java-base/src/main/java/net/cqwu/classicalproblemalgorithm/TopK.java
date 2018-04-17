package net.cqwu.classicalproblemalgorithm;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.classicalproblemalgorithm
 *
 * @author： p.z
 * Create Date：  2018-03-26
 * Modified By：   p.z
 * Modified Date:  2018-03-26
 * Why & What is modified
 * Version:        V1.0
 */
public class TopK {
    public static void main(String[] args) {

    }

    public int[] getTopK(int[] topks, int element) {
        int[] tops = topks;
        if(element > topks[0]) {

        }
        return tops;
    }

    /**
     * 维护一个K长度的数组a[]，先读取源数据中的前K个放入数组，对该数组进行升序排序，
     * 再依次读取源数据第K个以后的数据，和数组中最小的元素（a[0]）比较，如果小于a[0]直接pass，大于的话，就丢弃最小的元素a[0]，
     * 利用二分法找到其位置，然后该位置前的数组元素整体向前移位，直到源数据读取结束。
     * @param top
     * @param temp
     */
    private static void add(int[] top, int temp) {//实现插入
        if (temp > top[0]) {
            top[0] = temp;
            int i = 0;
            for (; i < 99 && temp > top[i + 1]; i++) {
                top[i] = top[i + 1];
            }
            top[i] = temp;
        }
    }//
}