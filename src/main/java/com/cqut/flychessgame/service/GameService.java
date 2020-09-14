package com.cqut.flychessgame.service;

import com.cqut.flychessgame.domain.gameEntity.*;

import java.util.ArrayList;
import java.util.Map;
//import com.cqut.flychessgame.ui.GameFrame;

/**
 * Create with IntelliJ IDEA.
 * 游戏过程服务类
 * @author hj
 */
public interface GameService {
    /**
     * 初始化游戏
     */
//    void initGame(GameFrame frame) ;


    /**
     * 掷色子，返回随机生成的点数
     */
    int throwDice(int bound) ;

    /**
     * 判断玩家掷色子结果并移动飞机
     * @param gameData 对象数据
     */
    ArrayList<Checker> judgePlayerThrowResult(GameData gameData) ;

    /**
     * 判断电脑掷色子结果移动飞机
     */
    ArrayList<Checker> judgeCompThrowResult(GameData gameData) ;


    /**
     * 飞机移动,返回移动过程中的所有走过的位置，方向，音效等信息
     * @param gameData 数据
     * @param diceNumber 色子数（移动步数）
     */
    ArrayList<Checker> movePlane(GameData gameData, int diceNumber);

    /**
     * 获得角色飞机起飞数
     * @param planes 该角色所对应飞机
     */
    int getOutPlane(Plane[] planes);
}
