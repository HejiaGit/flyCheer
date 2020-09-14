package com.cqut.flychessgame.domain.gameEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Create with IntelliJ IDEA.
 * 色子实体类
 * @author hj
 */
public class Dice {
    /**
     * 是否玩家的色子
     */
    private boolean isPlayerDice = false ;

    /**
     * 当前色子点数
     */
    private int number = 6;

//    private GameControl gameControl ;


    public boolean isPlayerDice() {
        return isPlayerDice;
    }

    public void setPlayerDice(boolean playerDice) {
        isPlayerDice = playerDice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
