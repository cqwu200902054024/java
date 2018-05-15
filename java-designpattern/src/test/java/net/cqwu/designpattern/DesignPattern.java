package net.cqwu.designpattern;

import net.cqwu.adapter.*;
import net.cqwu.bridge.Image;
import net.cqwu.bridge.JPGImage;
import net.cqwu.bridge.WindowsImp;
import net.cqwu.composite.Component;
import net.cqwu.composite.Composite;
import net.cqwu.composite.Leaf;
import net.cqwu.criteria.*;
import net.cqwu.decorator.RedShapeDecorator;
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
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void testAdapter() {
       Ps2 ps2 = new Adapter();
       ps2.isPs2();
    }

    @Test
    public void testAdapter1() {
        Ps2 ps2 = new Adapter1(new Usber());
        ps2.isPs2();
    }

    @Test
    public void testMediaPlayer() {
        MediaPlayer mediaPlayer = new AdapterPlayer("mp4");
        mediaPlayer.play("mp4","test.file");
    }

    @Test
    public void testBriage() {
        Image image = new JPGImage();
        image.set(new WindowsImp());
        image.parseFile("test");
    }

    @Test
    public void testCriteria() {
        List<net.cqwu.criteria.Person> persons = new ArrayList<net.cqwu.criteria.Person>();
        persons.add(new net.cqwu.criteria.Person("Robert",23,"Male", "Single"));
        persons.add(new net.cqwu.criteria.Person("John", 32,"Male", "Married"));
        persons.add(new net.cqwu.criteria.Person("Laura",34, "Female", "Married"));
        persons.add(new net.cqwu.criteria.Person("Diana", 35,"Female", "Single"));
        persons.add(new net.cqwu.criteria.Person("Mike", 67,"Male", "Single"));
        persons.add(new net.cqwu.criteria.Person("Bobby",12, "Male", "Single"));

        Criteria males = new CriteriaMale();
        Criteria female = new CriteriaFemale();
        Criteria single = new CriteriaSingle();
        Criteria maleAndSingleCriteria = new AndCriteria(males,single);
        Criteria orCriteria = new OrCriteria(female,single);
        List<net.cqwu.criteria.Person> maleAndSingle = maleAndSingleCriteria.meetCriteria(persons);
        for(net.cqwu.criteria.Person p : maleAndSingle) {
            System.out.println(p);
        }
        System.out.println("=====================");
        List<net.cqwu.criteria.Person> femaleOrSingle = orCriteria.meetCriteria(persons);
        for(net.cqwu.criteria.Person p : femaleOrSingle) {
            System.out.println(p);
        }
    }

    @Test
    public void testComposite() {
        Component leaf1 = new Leaf();
        Component leaf2 = new Leaf();
        Component leaf3 = new Leaf();
        Component composite = new Composite();
        Component composite2 = new Composite();
        composite2.add(leaf3);
        composite.add(composite2);
        composite.add(leaf1);
        composite.add(leaf2);
        composite.operation();
    }

    @Test
    public void testDecorator() {
          net.cqwu.decorator.Shape shapeCircle = new net.cqwu.decorator.Circle();
          net.cqwu.decorator.ShapeDecorator shapeDecorator = new RedShapeDecorator(shapeCircle);
          shapeDecorator.draw();
    }
}