package net.cqwu.adapter;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:
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
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
