package net.cqwu.classicalproblemalgorithm;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.classicalproblemalgorithm
 *
 * @author： Administrator
 * Create Date：  2018-07-09
 * Modified By：   Administrator
 * Modified Date:  2018-07-09
 * Why & What is modified
 * Version:        V1.0
 */
public class Offer100 {
    public static void main(String[] args) {
        int[][] test = new int[][]{{1,2,3},{2,3,4},{4,5,6},{7,8,9}};
        System.out.println(test[0].length);
        //二分查找
        int[] array = {1,2,3,4,5,6,6,7,9};
        int res = recursionBinarySearch(array,7,0,array.length - 1);
        System.out.println(res);
    }


    public static int recursionBinarySearch(int[] array,int key,int low,int high) {
        //注意程序的鲁棒性
        if(key > array[high] || key < array[low] || low > high) {
            return -1;
        }
        int middle = (low + high) / 2;
          if(key > array[middle]) {
              return recursionBinarySearch(array,key,middle + 1,high);
          } else if(key < array[middle]) {
              return recursionBinarySearch(array,key,low,middle - 1);
          } else {
              return middle;
          }
    }

}
