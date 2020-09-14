package com.cqut.flychessgame.domain.gameEntity;

import java.awt.*;

/**
 * Create with IntelliJ IDEA.
 * 棋盘格对象
 * @author hj
 */
public class Checker {

    private Point location ;

//    private List<Plane> planeList = new ArrayList<Plane>();

    private String cellColor = null ;

    //方向 1，下 2，左 3，右 4，上
    private int direction ;

    //当前经过飞机序号数
    private int planeNum;

    public Checker(){

    }

    public Checker(Point point,String colorStr,int planeNum){
        this.location = point ;
        this.cellColor = colorStr ;
        this.planeNum = planeNum;
    }

    public int getPlaneNum() {
        return planeNum;
    }

    public void setPlaneNum(int planeNum) {
        this.planeNum = planeNum;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public String getCellColor() {
        return cellColor;
    }

    public void setCellColor(String cellColor) {
        this.cellColor = cellColor;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
