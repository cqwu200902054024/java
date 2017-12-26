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
public class JavaIOTest {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
         File src = new File("D:\\data\\out\\test.txt");
         File dist = new File("D:\\data\\out\\dist.txt");
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
       // System.out.println("hello word!\n我们写一个检测文件长度的小程序，别看这个程序挺长的".getBytes().length);
       // System.out.println("===========以字节流形式读文件：");
       // System.out.println(readByInputStream(file));
       // System.out.println(new String(readBytesByInputStream(file),"utf-8"));
       // copyFile(src,dist);
       // copyFile2(src,dist);
       // copyByBuffer(src,dist);
        //File outobj = new File("D:\\data\\out\\person");
       // objectSer(outobj,outobj);
       // byteTocharBuffer(src);
       // String data = "我们写一个检测文件长度的小程序，别看这个程序挺长";
      //  writeByChar(data,src);
       // randomReadAndWriteFile(src,dist);
        System.out.println(new String(readBytesByInputStreamNoLoop(src),"utf-8"));

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

    public static byte[] readBytesByInputStream(File file) throws IOException{
        byte[] bytes = new byte[25];
        int i = 0;
        try(InputStream in = new FileInputStream(file)) {
            //Reads up to <code>b.length</code> bytes of data from this input
            //stream into an array of bytes,读到结尾（没有数据可读），返回-1
            //循环调用read()
            while(in.read(bytes) != -1) {
                i ++;
            }
            System.out.println(i + "读取次数");
        }
        return bytes;
    }

    public static byte[] readBytesByInputStreamNoLoop(File file) throws IOException{
        byte[] bytes = new byte[25];
        int i = 0;
        try(InputStream in = new FileInputStream(file)) {
            //Reads up to <code>b.length</code> bytes of data from this input
            //stream into an array of bytes,读到结尾（没有数据可读），返回-1
            //循环调用read()
        /*    while(in.read(bytes) != -1) {
                i ++;
            }*/
        in.read(bytes);
        }
        return bytes;
    }

    /**
     * 通过字节流copy文件(调用read方法)
     * @param src
     * @param dist
     */
    public static void copyFile(File src,File dist) throws IOException{
        try(InputStream in = new FileInputStream(src);OutputStream os = new FileOutputStream(dist)) {
            int temp = -1;
            while ((temp = in.read()) != -1) {
                os.write(temp);
            }
        }
    }

    /**
     * 通过缓冲流copy文件
     * @param src
     * @param dist
     * @throws IOException
     */
    public static void copyFile2(File src,File dist) throws IOException {
        try(InputStream in = new FileInputStream(src);OutputStream os = new FileOutputStream(dist)) {
            byte[] buffer = new byte[(int)src.length()];
            while(in.read(buffer) !=- 1) {
                os.write(buffer);
                System.out.println("====");
            }
        }
    }

    public static void copyByBuffer(File src,File dist) throws IOException{
        //分别创建一个输入输出缓冲流并指定缓冲大小
        //该流会尽可能多的一次性读取若干字节并存入缓冲区，然后逐一的将字节返回，直到缓冲区中的数据全部读取完毕，
        // 会再次读取若干字节从而反复。这样就减少了读取的次数。
        try(InputStream in = new FileInputStream(src);BufferedInputStream bis = new BufferedInputStream(in,1024);
        OutputStream os = new FileOutputStream(dist);BufferedOutputStream bos = new BufferedOutputStream(os,1024)) {
               byte[] buffer = new byte[1024 *4];
               while(bis.read(buffer) != -1) {
                   System.out.println(buffer.toString());
                   bos.write(buffer);
               }
        }
    }

    /**
     * 对象的序列化与反序列化
     * @param outObj
     * @param inObj
     */
    public static void objectSer(File outObj,File inObj) throws IOException,ClassNotFoundException{
       try(OutputStream out = new FileOutputStream(outObj);ObjectOutputStream oos = new ObjectOutputStream(out);
       InputStream in = new FileInputStream(inObj);ObjectInputStream ois = new ObjectInputStream(in)) {
          Person person = new Person("zp",28,"M","123456");
           oos.writeObject(person);
           Person p = (Person)ois.readObject();
           System.out.println(p);
       }
    }

    /**
     * 将字节输入流转为缓冲字符输入流:
     * 将字节输入流转为字符输入流，然后在将字符输入流转为字符缓冲流
     * @param src
     */
    public static void byteTocharBuffer(File src) throws IOException{
        try(InputStream in = new FileInputStream(src);InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr,4)) {
            //一次读取一行数据
        /*    String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }*/
            //读取最多sc.length个字符，并放入字符数组中
            System.out.println("===============");
            char[] cs = new char[100];
            while (br.read(cs) != -1) {
                System.out.println(new String(cs));
            }
        }
    }

    /**
     * 结合字节输出流，字符输出流，字符缓冲流将数据写入文件：
     * 将字节输出流转为字符输出流，然后在将字符输入流转为字符缓冲流
     * @param data
     * @param file
     */
    public static void writeByChar(String data,File file) throws IOException{
         try(OutputStream os = new FileOutputStream(file);OutputStreamWriter osw = new OutputStreamWriter(os);
         BufferedWriter bw = new BufferedWriter(osw)) {
             bw.write(data);
         }
    }

    /**
     * 随机读写文件
     * @param src
     * @param dist
     */
    public static void randomReadAndWriteFile(File src,File dist) throws IOException{
        try(RandomAccessFile rf = new RandomAccessFile(src,"r");RandomAccessFile wf = new RandomAccessFile(dist,"rw")) {
            //定位开始读的位置
            rf.seek(9);
            System.out.println("开始读取位置：" + rf.getFilePointer());
            byte[] buffer = new byte[5];
            rf.read(buffer);
            System.out.println("结束读取位置：" + rf.getFilePointer());
            System.out.println("读取内容：" + new String(buffer,"utf-8"));
            //定位开始写的位置
            wf.seek(10);
            System.out.println("写数据的位置：" + wf.getFilePointer());
            //写数据
            wf.write("hello".getBytes());
            System.out.println("写数据的结束位置：" + wf.getFilePointer());
        }
    }
}

