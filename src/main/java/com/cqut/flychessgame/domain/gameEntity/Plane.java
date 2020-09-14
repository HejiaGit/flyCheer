package com.cqut.flychessgame.domain.gameEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Create with IntelliJ IDEA.
 * 对应飞机类
 * @author hj
 */
public class Plane {
    /**
     * 飞机类型：b蓝色 r红色 g绿色 y黄色
     */
    private String planeType = "r" ;

    /**
     * 飞机的航向
     * direction 1，下 2，左 3，右 4，上
     */
    private int planeDirection ;

    /**
     * 是不是玩家控制的棋子
     */
    private boolean isPlayer ;

    /**
     * 飞机是否在家
     */
    private boolean isAtHome = true ;

    /**
     * 飞机在航线上的位置
     */
    private int loc = -2 ;

    /**
     * 飞机在老家的序号
     */
    private int index = -1 ;

//    private GameData data ;

    public Plane(){
    }

    public Plane(String type ,int direction,boolean isPlayer,int index,GameData data){
//        this.setData(data) ;
        this.setIndex(index) ;
        this.setPlaneType(type);
        this.setPlayer(isPlayer) ;
        this.setPlaneDirection(direction);
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public String getPlaneType() {
        return planeType;
    }

    public int getPlaneDirection() {
        return planeDirection;
    }

    public void setPlaneDirection(int planeDirection) {
        this.planeDirection = planeDirection;
    }

    public boolean isPlayer() {
        return isPlayer;
    }

    public void setPlayer(boolean player) {
        isPlayer = player;
    }

    public boolean isAtHome() {
        return isAtHome;
    }

    public void setAtHome(boolean atHome) {
        isAtHome = atHome;
    }

    public int getLoc() {
        return loc;
    }

    public void setLoc(int loc) {
        this.loc = loc;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

//    public GameData getData() {
//        return data;
//    }
//
//    public void setData(GameData data) {
//        this.data = data;
//    }

}
