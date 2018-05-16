package net.cqwu.facade;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.facade
 *
 * @author： Administrator
 * Create Date：  2018-05-16
 * Modified By：   Administrator
 * Modified Date:  2018-05-16
 * Why & What is modified
 * Version:        V1.0
 */
public class Facade {
    private ServiceA serviceA;
    private ServiceB serviceB;
    private ServiceC serviceC;

    public Facade() {
        this.serviceA = new ServiceAImpl();
        this.serviceB = new ServiceBImpl();
        this.serviceC = new ServiceCImpl();
    }

    public void methodA() {
        this.serviceA.methodA();
    }

    public void methodB() {
        this.serviceB.methodB();
    }

    public void methodC() {
        this.serviceC.methodC();
    }

    public void op() {
        this.serviceB.methodB();
        this.serviceA.methodA();
        this.serviceC.methodC();
    }
}
