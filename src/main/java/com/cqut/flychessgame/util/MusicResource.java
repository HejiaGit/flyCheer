package com.cqut.flychessgame.util;

import javax.sound.sampled.*;
import java.io.File;

/**
 * Create with IntelliJ IDEA.
 * 播放音频文件组件
 * @author hj
 */
public class MusicResource {
    private SourceDataLine sdl = null;

    /**
     * @param file      要播放的音频文件
     * @param playTimes 播放时长
     */
    public void play(File file, int playTimes) {
        while (playTimes > 0) {
            playTimes--;
            try {
                AudioInputStream ais = AudioSystem.getAudioInputStream(file);
                AudioFormat af = ais.getFormat();
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, af);
                sdl = (SourceDataLine) AudioSystem.getLine(info);
                sdl.open(af);
                sdl.start();
                int nByte = 0;
                byte[] buffer = new byte[128];
                while (nByte != -1) {
                    nByte = ais.read(buffer, 0, 128);
                    if (nByte >= 0) {
                        sdl.write(buffer, 0, nByte);
                    }
                }
            } catch (Exception e) {
                return;
            }
        }

    }

    public void stop() {
        sdl = null;
    }
}
