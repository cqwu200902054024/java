package net.cqwu.classicalproblemalgorithm;

import net.cqwu.datastructure.sorts.BubbleSort;
import net.cqwu.datastructure.sorts.InsertionSort;
import net.cqwu.datastructure.sorts.SelectSort;
import org.junit.Test;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.classicalproblemalgorithm
 *
 * @author： Administrator
 * Create Date：  2018-04-17
 * Modified By：   Administrator
 * Modified Date:  2018-04-17
 * Why & What is modified
 * Version:        V1.0
 */
public class SortTest {
    @Test
    public void testBubbleSort() {
        Integer[] values = new Integer[]{12,34,11,33,23};
        BubbleSort.sort0(values);
        for(Integer value : values) {
            System.out.println(value);
        }
    }

    @Test
    public void testSelectSort() {
        Integer[] values = new Integer[]{12,34,11,33,23};
        SelectSort.sort0(values);
        for(Integer value : values) {
            System.out.println(value);
        }
    }

    @Test
    public void testInsertionSort() {
        Integer[] values = new Integer[]{12,34,11,33,23};
        InsertionSort.sort(values);
        for(Integer value : values) {
            System.out.println(value);
        }
    }

}
