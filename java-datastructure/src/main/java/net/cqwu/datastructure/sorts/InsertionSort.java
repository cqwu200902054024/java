package net.cqwu.datastructure.sorts;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments: 插入排序
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.datastructure
 *
 * @author： Administrator
 * Create Date：  2018-04-17
 * Modified By：   Administrator
 * Modified Date:  2018-04-17
 * Why & What is modified
 * Version:        V1.0
 */
public class InsertionSort<T extends Comparable<T>> {
    private InsertionSort(){};
    public static <T extends Comparable<T>> T[] sort0(T[] unsorted) {
        int j ;
        for(int i = 1;i < unsorted.length; i ++) {
            //被标记的数据
            T temp = unsorted[i];
            //找出被标记数据的插入位置
             j = i;
            while(j > 0 && unsorted[j - 1].compareTo(temp) >= 0) {
                unsorted[j] = unsorted[j - 1];
                --j;
            }
            unsorted[j] = temp;
        }
        return unsorted;
    }

    public static <T extends Comparable<T>> T[] sort(T[] unsorted) {
        for(int i = 1;i < unsorted.length; i ++) {
            sort(i,unsorted);
        }
        return unsorted;
    }

    /**
     * 部分排序（将标记数据插入合适位置）
     * @param i 标记数据
     * @param unsorted
     * @param <T>
     */
    public static <T extends Comparable<T>> void sort(int i,T[] unsorted) {
        for(int j = i;j > 0; j --) {
            //标记数据
            T temp = unsorted[j];
            T insertData = unsorted[j - 1];
            //将标记数据插入合适位置
            if(temp.compareTo(insertData) <= 0) {
                unsorted[j] = insertData;
                unsorted[j - 1] = temp;
            } else {
                break;
            }
        }
    }
}
