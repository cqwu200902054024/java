package net.cqwu.datastructure.sorts;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:    冒泡排序
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.datastructure
 *
 * @author： p.z
 * Create Date：  2018-04-17
 * Modified By：   p.z
 * Modified Date:  2018-04-17
 * Why & What is modified
 * Version:        V1.0
 */
public class BubbleSort<T extends Comparable<T>> {
    private BubbleSort() {};

    /**
     * 冒泡排序
     * @param unsorted
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> T[] sort(T[] unsorted) {
         boolean swaped = true;
         long length = unsorted.length;
         while (swaped) {
             swaped = false;
             for(int i = 1;i < length; i ++) {
                 if(unsorted[i].compareTo(unsorted[i - 1]) < 0) {
                     swap(i - 1,i,unsorted);
                      swaped = true;
                 }
             }
             length --;
         }
         return unsorted;
    }
    public static <T extends  Comparable<T>> T[] sort0(T[] unsorted) {
        for(int l = unsorted.length - 1;l > 0; l --) {
            for(int i = 1; i < l; i ++) {
                if(unsorted[i].compareTo(unsorted[i - 1]) < 0) {
                    swap(i - 1,i,unsorted);
                }
            }
        }
        return unsorted;
    }

    /**
     * 交换数组中两个数据的位置
     * @param index1
     * @param index2
     * @param unsorted
     * @param <T>
     */
    public static <T extends Comparable<T>> void swap(int index1,int index2,T[] unsorted) {
       T temp = unsorted[index1];
       unsorted[index1] = unsorted[index2];
       unsorted[index2] = temp;
    }
}
