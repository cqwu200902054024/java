package net.cqwu.datastructure.sorts;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:  选择排序
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.datastructure
 *
 * @author： p.z
 * Create Date：  2018-04-17
 * Modified By：   Administrator
 * Modified Date:  2018-04-17
 * Why & What is modified
 * Version:        V1.0
 */
public class SelectSort <T extends Comparable<T>>{
    private SelectSort(){};
    public static <T extends Comparable<T>> T[] sort(T[] unsorted) {
        int length = 0;
        while (length < unsorted.length - 1) {
            int  minIndex = length;
            for(int i = length + 1; i < unsorted.length; i ++) {
                if(unsorted[i].compareTo(unsorted[minIndex]) < 0) {
                    minIndex = i;
                }
            }
            swaped(length,minIndex,unsorted);
            length ++;
        }
        return unsorted;
    }

    public static <T extends Comparable<T>> T[] sort0(T[] unsorted) {
        for(int i = 0; i < unsorted.length -1; i ++) {
            int minIndex = i;
            for(int j = i + 1; j < unsorted.length;j ++) {
                if(unsorted[j].compareTo(unsorted[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swaped(i,minIndex,unsorted);
        }
        return unsorted;
    }

    public static <T extends Comparable<T>> void swaped(int index1,int index2,T[] unsorted) {
        T temp = unsorted[index1];
        unsorted[index1] = unsorted[index2];
        unsorted[index2] = temp;
    }
}
