package com.cqut.flychessgame.util;

import javafx.scene.image.Image;

import javax.swing.*;
import java.io.File;

/**
 * Create with IntelliJ IDEA.
 * 游戏资源类
 *
 * @author hj
 */
public class GameResource {

    /**
     * 游戏背景
     */
////	public static final Image GAME_MAP ;

    public static final Image[] redPlaneImgArray;

    public static final Image[] bluePlaneImgArray;

    public static final Image[] greenPlaneImgArray;

    public static final Image[] yellowPlaneImgArray;

    public static final Image[] DICE;

    public static final Image RED_CROWN;

    public static final Image YELLOW_CROWN;

    public static final Image GREEN_CROWN;

    public static final Image BLUE_CROWN;

    public static final Image SOURCE_ICON;

    static {
        SOURCE_ICON = new Image(Constant.SOURCE_INCO_URL);

        RED_CROWN = new Image(Constant.RED_CROWN);
        YELLOW_CROWN = new Image(Constant.YELLOW_CROWN);
        GREEN_CROWN = new Image(Constant.GREEN_CROWN);
        BLUE_CROWN = new Image(Constant.BLUE_CROWN);

        //初始化游戏飞机数
        int planeNum = Constant.PLANE_NUMBER;
        //初始化游戏背景
//		GAME_MAP = new Image(Constant.GAME_MAP_URL).getImage();

        //初始化飞机图片数组
        redPlaneImgArray = new Image[4];
        bluePlaneImgArray = new Image[4];
        greenPlaneImgArray = new Image[4];
        yellowPlaneImgArray = new Image[4];
        for (int i = 0; i < planeNum; i++) {
            redPlaneImgArray[i] = new Image(Constant.PLANE_IMG_URL + "r" + (i + 1) + ".png");
            bluePlaneImgArray[i] = new Image(Constant.PLANE_IMG_URL + "b" + (i + 1) + ".png");
            greenPlaneImgArray[i] = new Image(Constant.PLANE_IMG_URL + "g" + (i + 1) + ".png");
            yellowPlaneImgArray[i] = new Image(Constant.PLANE_IMG_URL + "y" + (i + 1) + ".png");
        }
        DICE = new Image[11];
        for (int i = 1; i <= 10; i++) {
            DICE[i] = new Image(Constant.DICE_ICON_URL + "dice_" + i + ".png");
        }
    }
}
