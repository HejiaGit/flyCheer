package com.cqut.flychessgame.domain.resource;

import com.cqut.flychessgame.domain.gameEntity.GameData;
import com.cqut.flychessgame.util.MusicResource;

import java.io.File;

/**
 * Create with IntelliJ IDEA.
 * 音效播放类
 * @author hj
 */
public class Sounds implements Runnable {

    private MusicResource musicResource = new MusicResource() ;

    private GameData gameData;

    private int playTimes  = 0 ;

    private String soundsURL = null ;

    public Sounds(GameData gameData,int playTimes,String soundsURL){
        this.gameData = gameData;
        this.playTimes = playTimes ;
        this.soundsURL = soundsURL ;
    }
//
//    public int getPlayTimes() {
//        return playTimes;
//    }
//
//    public void setPlayTimes(int playTimes) {
//        this.playTimes = playTimes;
//    }
//
//    public String getSoundsURL() {
//        return soundsURL;
//    }
//
//    public void setSoundsURL(String soundsURL) {
//        this.soundsURL = soundsURL;
//    }

    @Override
    public void run() {
        if(gameData.isPlayBGM()){
            this.playBGM();
        }
    }

    private void playBGM(){
        File file = new File(this.soundsURL) ;
        musicResource.play(file,this.playTimes) ;
    }

    public void stop(){
        musicResource.stop() ;
    }
}
