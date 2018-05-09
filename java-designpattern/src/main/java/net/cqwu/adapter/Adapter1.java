package net.cqwu.adapter;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:采用组合方式，将Ps2接口转为USB接口
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.adapter
 *
 * @author： Administrator
 * Create Date：  2018-05-09
 * Modified By：   Administrator
 * Modified Date:  2018-05-09
 * Why & What is modified
 * Version:        V1.0
 */
public class Adapter1 implements Ps2{
    private Usb usb;

    public Adapter1(Usb usb) {
        this.usb = usb;
    }
    @Override
    public void isPs2() {
        usb.isUsb();
    }
}
