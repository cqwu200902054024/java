package net.cqwu.trywithresources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments: Java SE7新特性之try-with-resources语句
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.net.cqwu.trywithresources
 * Author：             Administrator
 * Create Date：  2017-12-14
 * Modified By：   Administrator
 * Modified Date:  2017-12-14
 * Why & What is modified
 * Version:        V1.0
 */
public class TryTest {
    public static void  main(String[] args) {
    }

    public static String readFristLineFromFile(String path){
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
