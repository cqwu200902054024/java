package net.cqwu.classicalproblemalgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.classicalproblemalgorithm
 *
 * @author： Administrator
 * Create Date：  2017-12-28
 * Modified By：   Administrator
 * Modified Date:  2017-12-28
 * Why & What is modified
 * Version:        V1.0
 */
public class BaseTest {
    @Test
    public void testNum() {
       System.out.println(4 << 1);
  /*     int[] array = new int[]{1,2,3,4,5,6,7};
      // array = Arrays.copyOf(array,2);
        System.out.println(array[1]);
        //Object src,  int  srcPos,Object dest, int destPos,int length
        System.arraycopy(array,3,array,2,6-3);
        for(int i = 0;i < array.length;i ++) {
            System.out.println(array[i]);
        }*/
    }

    @Test
    public void testClassLoad() {
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(BaseTest.class.getResource(""));
        System.out.println(BaseTest.class.getResourceAsStream(""));
        System.out.println(BaseTest.class.getClassLoader().getResource(""));
    }
}
