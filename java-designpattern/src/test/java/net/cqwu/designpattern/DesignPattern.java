package net.cqwu.designpattern;

import net.cqwu.factorymethod.abstractfactory.AbstractFactory;
import net.cqwu.factorymethod.abstractfactory.FactoryProducer;
import net.cqwu.factorymethod.abstractfactory.Shape;
import net.cqwu.builder.Person;
import net.cqwu.factorymethod.simple.ShapeFactory;
import net.cqwu.protopyte.Resume;
import net.cqwu.protopyte.ShapeCache;
import net.cqwu.protopyte.WorkExperience;
import net.cqwu.singleton.Singleton;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.designpattern
 *
 * @author： p.z
 * Create Date：  2018-05-04
 * Modified By：   p.z
 * Modified Date:  2018-05-04
 * Why & What is modified
 * Version:        V1.0
 */
public class DesignPattern {
    private Singleton signleton;

    @Before
    public void init() {
        StringBuffer sb = new StringBuffer();
       // this.signleton = Singleton.getInstance();
    }

    @Test
    public void testSingleton() {
        this.signleton = Singleton.getInstance();
        Singleton s = Singleton.getInstance();
        System.out.println(this.signleton == s);
    }

    @Test
    public void testFactoryMethod() {
        ShapeFactory sf = new ShapeFactory();
        Shape shape = sf.getShape("rectangle");
        shape.draw();
    }

    @Test
    public void testAbstractFactory() {
       AbstractFactory af = FactoryProducer.builder("COLOR");
       af.getColor("red").fill();
    }

    @Test
    public void testBuilder() {
        Person p = new Person.Builder("zp",32).address("xinyang").phone("ssss").builder();
        System.out.println(p);
    }

    @Test
    public void testPrototype() throws CloneNotSupportedException{
        ShapeCache.loadShapes();
        net.cqwu.protopyte.Shape shape = ShapeCache.getShape("1");
        shape.draw();
    }

    /**
     * 深度拷贝
     */
    @Test
    public void testDeepCopy() throws CloneNotSupportedException,IOException,ClassNotFoundException{
        Resume resume = new Resume();
        resume.setAge(23);
        resume.setName("zp");
        WorkExperience workExperience = new WorkExperience();
        workExperience.setWorkCompany("cs");
        workExperience.setWorkDate("2017");
        resume.setWorkExperience(workExperience);
        Resume res = resume.clone();
        Resume resdeep = resume.deepClone0();
        workExperience.setWorkCompany("shcs");
        System.out.println(res.getName()+"-->" + res.getWorkExperience().getWorkCompany() + "--->" + resdeep.getWorkExperience().getWorkCompany());
    }
}