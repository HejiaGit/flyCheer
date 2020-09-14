package com.cqut.flychessgame.domain.gameEntity;


import com.cqut.flychessgame.util.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Create with IntelliJ IDEA.
 * 游戏角色实体
 * @author hj
 */
public class Role {

    /**
     * 角色身份
     */
    private boolean isPlayer;

    /**
     * 角色代表的颜色
     */
    private String roleColor;

    /**
     * 该角色拥有的飞机
     */
    private Plane[] planes = new Plane[4];

    /**
     * 该角色拥有的航线
     */
    private List<Checker> line = new ArrayList<Checker>(
            Constant.PATH_CAPACITANCE);

    /**
     * 玩家的色子
     */
    private Dice dice;

    /**
     * 飞机数据
     */
//    private GameData gameData;

    public Role(boolean isPlayer, String roleColor) {

//        this.setGamePanel(gamePanel);
//        this.setPlanes(gameData.getPlane(roleColor));
//        this.setLine(this.gamePanel.getGameConrol().getGameServiceImpl()
//                .getGameData().getLine(roleColor));
        this.setPlayer(isPlayer);
        this.setRoleColor(roleColor);

    }

    public boolean isPlayer() {
        return isPlayer;
    }

    public void setPlayer(boolean player) {
        isPlayer = player;
    }

    public String getRoleColor() {
        return roleColor;
    }

    public void setRoleColor(String roleColor) {
        this.roleColor = roleColor;
    }

    public Plane[] getPlanes() {
        return planes;
    }

    public void setPlanes(Plane[] planes) {
        this.planes = planes;
    }

    public List<Checker> getLine() {
        return line;
    }

    public void setLine(List<Checker> line) {
        this.line = line;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }
}
