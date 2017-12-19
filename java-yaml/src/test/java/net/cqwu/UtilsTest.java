package net.cqwu;

import org.junit.Before;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.util.List;
import java.util.Map;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu
 * @Author：             Administrator
 * Create Date：  2017-12-19
 * Modified By：   Administrator
 * Modified Date:  2017-12-19
 * Why & What is modified
 * Version:        V1.0
 */
public class UtilsTest {
    private Yaml yaml;
    @Before
    public void init() {
        yaml = new Yaml();
    }

    @Test
    public void testLoad() {
        String document = "\n- Hesperiidae\n- Papilionidae\n- Apatelodidae\n- Epiplemidae";
        System.out.println(document);
        List<String> list = yaml.load(document);
        for(String l : list) {
            System.out.println(l);
        }
    }

    @Test
    public void testLoadFromString() {
        String doc = "--- \nname: zp\nage: '24'";
        System.out.println(doc);
        Map<String,String> map = yaml.load(doc);
        for(Map.Entry<String,String> m : map.entrySet()) {
            System.out.println(m.getKey() + ":" + m.getValue());
        }
    }

    @Test
    public void testLoadFromDocuments() {

    }
}
