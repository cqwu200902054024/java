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
public class AdapterPlayer implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;
    public AdapterPlayer(String audioType) {
        if("vlc".equalsIgnoreCase(audioType)) {
            this.advancedMediaPlayer = new VlcPlayer();
        } else if("mp4".equalsIgnoreCase(audioType)) {
            this.advancedMediaPlayer = new Mp4Player();
        }

    }

    @Override
    public void play(String audioType, String fileName) {
        switch (audioType) {
            case "vlc":
                advancedMediaPlayer.playVlc(fileName);
                break;
            case "mp4":
                advancedMediaPlayer.playMp4(fileName);
                break;
        }
    }
}
