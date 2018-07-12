package net.cqwu;

import org.yaml.snakeyaml.Yaml;


import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:  支持MR的工具类
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu
 * Author：             Administrator
 * Create Date：  2017-12-19
 * Modified By：   Administrator
 * Modified Date:  2017-12-19
 * Why & What is modified
 * Version:        V1.0
 */
public class MRUtils {

    public static void main(String[] args) throws FileNotFoundException {
        //loadManyDocuments();
        //test();
       // System.out.println(getResourcePath("mr.yaml"));
   /*     for(Map.Entry<?,?> map : testLoadForMap("any-object-example.yaml").entrySet()) {
            System.out.println(map.getKey() + ":" + map.getValue());
        }*/
   //通过名称传值
        //String data1 = "--- !net.cqwu.bean.Person\nfirstName: Andrey\nage: 99 ";
        //通=通过数组传值
       // String data2 = "--- !net.cqwu.bean.Person [ Andrey, Somov, 99 ]";
        for(Map.Entry<?,?> map : testLoadForMap("mr.yaml").entrySet()) {
            System.out.println(map.getKey() + ":" + map.getValue());
        }
    }

    public static void loadManyDocuments() throws FileNotFoundException {
        InputStream inputStream = MRUtils.class.getClassLoader().getResourceAsStream("example.yaml");
        Yaml yaml = new Yaml();
        for(Object obj : yaml.loadAll(inputStream)) {
           System.out.println(obj);
        }
    }

    public static void test() {
        InputStream inputStream = MRUtils.class.getClassLoader().getResourceAsStream("test.yaml");
        Yaml yaml = new Yaml();
        Map<String,Object> maps = yaml.load(inputStream);
        for (Map.Entry<String,Object> map : maps.entrySet()) {
            System.out.println(map.getKey() + ":" + map.getValue());
        }
    }

    /**
     * 将yaml转为Map
     * @param fileName
     * @return
     */
    public static Map<?,?> testLoadForMap(String fileName) {
         return  newInstance().load(getResourceInputStream(fileName));
    }

    /**
     * 将yaml转为List
     * @param fileName
     * @return
     */
    public static List<?> testLoadForList(String fileName) {
        return newInstance().load(getResourceInputStream(fileName));
    }

    /**
     * 将yaml转为bean
     * @param <T>
     * @return
     */
    public static <T> T testConvertToBean(Class<T> bean,String yamlStr) {
        return newInstance().loadAs(yamlStr,bean);
    }

    /**
     * 根据资源名获取ClassPath下的资源地址
     * @param fileName
     * @return
     */
    private static String getResourcePath(String fileName) {
        return MRUtils.class.getClassLoader().getResource(fileName).getPath();
    }

    /**
     * 返回ClassPath下的资源流
     * @param fileName
     * @return
     */
    private static InputStream getResourceInputStream(String fileName) {
        return MRUtils.class.getClassLoader().getResourceAsStream(fileName);
    }

    /**
     *
     * @return yaml
     */
    private static Yaml newInstance() {
        return  new Yaml();
    }
 }
