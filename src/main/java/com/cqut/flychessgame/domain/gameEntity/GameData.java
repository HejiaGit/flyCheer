package com.cqut.flychessgame.domain.gameEntity;

import com.cqut.flychessgame.util.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Create with IntelliJ IDEA.
 * 游戏实时数据实体
 * @author hj
 */
public class GameData {

    /**
     * 玩家是否本轮已经录入语音
     */
    private boolean isRecord = false;

    /**
     * 玩家是否已选择飞机
     */
    private boolean isChoice = false;

    /**
     * 是否播放背景音乐
     */
    private boolean isPlayBGM = false;


    /**
     * 幸运数字使用次数
     */

    private int chance = 3;

    /**
     * 赢得胜利的角色编号
     **/
    private int winRole = -1;

    /**
     * 外环线路
     */
    private List<Checker> pathList = new ArrayList<Checker>(
            Constant.LIST_PATN_CAPACITANCE);

    /**
     * 十字架线路
     */
    private List<Checker> crossList = new ArrayList<Checker>(
            Constant.CROSS_PATH_CAPACITANCE);

    /**
     * 游戏玩家数组 0为红色 1为黄色 2为绿色 3为蓝色
     */
    private Role[] players = new Role[4];


    /**
     * 当前角色编号 0为红色 1为黄色 2为绿色 3为蓝色
     */
    private int currentRole = 0;


    /**
     * 玩家是否投掷色子
     */
    private boolean isClick = false;

    /**
     * 当前选择的飞机编号
     */
    private int NumberOfCurrentPlane = -1;

    /**
     * 背景音乐是否已经改变
     */
    private boolean isChangeBGM = false ;

    public int getWinRole() {
        return winRole;
    }

    public void setWinRole(int winRole) {
        this.winRole = winRole;
    }

    public boolean isRecord() {
        return isRecord;
    }

    public void setRecord(boolean record) {
        isRecord = record;
    }

    public boolean isChoice() {
        return isChoice;
    }

    public void setChoice(boolean choice) {
        isChoice = choice;
    }

    public boolean isPlayBGM() {
        return isPlayBGM;
    }

    public void setPlayBGM(boolean playBGM) {
        isPlayBGM = playBGM;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public List<Checker> getPathList() {
        return pathList;
    }

    public void setPathList(List<Checker> pathList) {
        this.pathList = pathList;
    }

    public List<Checker> getCrossList() {
        return crossList;
    }

    public void setCrossList(List<Checker> crossList) {
        this.crossList = crossList;
    }

    public Role[] getPlayers() {
        return players;
    }

    public void setPlayers(Role[] players) {
        this.players = players;
    }

    public int getCurrentRole() {
        return currentRole;
    }

    public void setCurrentRole(int currentRole) {
        this.currentRole = currentRole;
    }

    public boolean isClick() {
        return isClick;
    }

    public void setClick(boolean click) {
        isClick = click;
    }

    public int getNumberOfCurrentPlane() {
        return NumberOfCurrentPlane;
    }

    public void setNumberOfCurrentPlane(int numberOfCurrentPlane) {
        NumberOfCurrentPlane = numberOfCurrentPlane;
    }

    public boolean isChangeBGM() {
        return isChangeBGM;
    }

    public void setChangeBGM(boolean changeBGM) {
        isChangeBGM = changeBGM;
    }


}
