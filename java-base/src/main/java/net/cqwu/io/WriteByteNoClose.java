package net.cqwu.io;

import java.io.*;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments: 使用字节流写文件，但不关闭流，验证，使用字节流操作文件是对文件的直接操作。
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.io
 *
 * @author： p.z
 * Create Date：  2017-12-21
 * Modified By：   Administrator
 * Modified Date:  2017-12-21
 * Why & What is modified
 * Version:        V1.0
 */
public class WriteByteNoClose {
    public static void main(String[] args) throws IOException {
         File file = new File("D:\\data\\out\\test.txt");
/*        OutputStream outputStream = new FileOutputStream(file);
        byte[] byteData = "test byte".getBytes();
        writeByBytes(outputStream,byteData);
        Writer writer = new FileWriter(file);
        String data = "word data";
        writeByWriter(writer,data);
        writer.flush();
        writer.close();
        byte[] testdata = "你".getBytes();
        //UTF-8编码，一个汉字占3个字节
        System.out.println("字节长度" + testdata.length);
        byte[] b = new byte[3];
        b[0] = testdata[0];
        b[1] = testdata[1];
        b[2] = testdata[2];

        System.out.println(new String(b,"utf-8"));

        writeByWriterAndClose(file,"hello word!\n我们写一个检测文件长度的小程序，别看这个程序挺长的");*/
        System.out.println("hello word!\n我们写一个检测文件长度的小程序，别看这个程序挺长的".getBytes().length);
        System.out.println("===========以字节流形式读文件：");
        System.out.println(readByInputStream(file));
    }

    /**
     * 通过字节流往文件中写数据，但最后不关闭字符流
     * @param os
     * @param data
     */
    public static void writeByBytes(OutputStream os,byte[] data) {
        try {
            OutputStream o = os;
            o.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *通过字符流写数据
     * @param writer
     * @param data
     */
    public static void writeByWriter(Writer writer,String data) {
         Writer wr = writer;
         try {
             wr.write(data);
         } catch (IOException e) {
             e.printStackTrace();
         }
    }

    public static void writeByWriterAndClose(File file,String data) throws IOException{
        try(Writer writer = new FileWriter(file)) {
            writer.write(data);
        }
    }

    /**
     * read()每次读取一个字节，读到文件末尾返回-1，否则返回读到的字节
     * 通过字节流读取文件
     * @param file
     */
    public static int readByInputStream(File file) throws IOException{
        try(InputStream in = new FileInputStream(file)) {
            int count = 0;
            int r = 0;
            while( (r = in.read()) != -1) {
                System.out.print(new String(new byte[]{(byte)r},"utf-8"));
                count ++;
            }
            System.out.println();
            return count;
        }
    }

}


