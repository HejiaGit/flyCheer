package com.cqut.flychessgame.util;

import com.cqut.flychessgame.domain.gameEntity.Checker;
import com.cqut.flychessgame.domain.gameEntity.GameData;
import com.cqut.flychessgame.domain.gameEntity.Plane;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;

/**
 * Create with IntelliJ IDEA.
 * 游戏线路初始化
 * @author hj
 */
@Component
public class GameDataUtil {


    public void GameDataInit(GameData gameData){

            // 初始化所有飞机
            for (int i = 0; i < 4; i++) {
                getPlane(Constant.TYPE_BLUE,gameData)[i] = new Plane(Constant.TYPE_BLUE,
                        Constant.UP, false,i,gameData);
                getPlane(Constant.TYPE_RED,gameData)[i] = new Plane(Constant.TYPE_RED,
                        Constant.RIGHT, true,i,gameData);
                getPlane(Constant.TYPE_GREEN,gameData)[i] = new Plane(Constant.TYPE_GREEN,
                        Constant.LEFT, false,i,gameData);
                getPlane(Constant.TYPE_YELLOW,gameData)[i] = new Plane(Constant.TYPE_YELLOW,
                        Constant.DOWN, false,i,gameData);
            }

            // 初始化当前角色编号
            gameData.setCurrentRole(0);

            // 初始化外环线路
            for (int i = 0; i < Constant.LIST_PATN_CAPACITANCE; i++) {
                if (i < 1) {
                    Checker Checker = new Checker(getPiontByRC(14, 3), null,-1);
                    gameData.getPathList().add(Checker);
                } else if (i < 5) {
                    Checker Checker = new Checker(getPiontByRC(15 - i, 4),
                            Constant.COLORARRAY[(i - 1) % 4],-1);
                    Checker.setDirection(Constant.UP);
                    gameData.getPathList().add(Checker);

                } else if (i < 8) {
                    Checker Checker = new Checker(getPiontByRC(10, 8 - i),
                            Constant.COLORARRAY[(i - 1) % 4],-1);
                    Checker.setDirection(Constant.LEFT);
                    gameData.getPathList().add(Checker);
                } else if (i < 14) {
                    Checker Checker = new Checker(getPiontByRC(18 - i, 0),
                            Constant.COLORARRAY[(i - 1) % 4],-1);
                    Checker.setDirection(Constant.UP);
                    gameData.getPathList().add(Checker);
                } else if (i < 18) {

                    Checker Checker = new Checker(getPiontByRC(4, i - 14),
                            Constant.COLORARRAY[(i - 1) % 4],-1);
                    Checker.setDirection(Constant.RIGHT);
                    gameData.getPathList().add(Checker);
                } else if (i < 21) {
                    Checker Checker = new Checker(getPiontByRC(21 - i, 4),
                            Constant.COLORARRAY[(i - 1) % 4],-1);
                    Checker.setDirection(Constant.UP);
                    gameData.getPathList().add(Checker);
                } else if (i < 27) {
                    Checker Checker = new Checker(getPiontByRC(0, i - 17),
                            Constant.COLORARRAY[(i - 1) % 4],-1);
                    Checker.setDirection(Constant.RIGHT);
                    gameData.getPathList().add(Checker);
                } else if (i < 31) {
                    Checker Checker = new Checker(getPiontByRC(i - 27, 10),
                            Constant.COLORARRAY[(i - 1) % 4],-1);
                    Checker.setDirection(Constant.DOWN);
                    gameData.getPathList().add(Checker);
                } else if (i < 34) {
                    Checker Checker = new Checker(getPiontByRC(4, i - 20),
                            Constant.COLORARRAY[(i - 1) % 4],-1);
                    Checker.setDirection(Constant.RIGHT);
                    gameData.getPathList().add(Checker);
                } else if (i < 40) {
                    Checker Checker = new Checker(getPiontByRC(i - 30, 14),
                            Constant.COLORARRAY[(i - 1) % 4],-1);
                    Checker.setDirection(Constant.DOWN);
                    gameData.getPathList().add(Checker);
                } else if (i < 44) {
                    Checker Checker = new Checker(getPiontByRC(10, 54 - i),
                            Constant.COLORARRAY[(i - 1) % 4],-1);
                    Checker.setDirection(Constant.LEFT);
                    gameData.getPathList().add(Checker);
                } else if (i < 47) {
                    Checker Checker = new Checker(getPiontByRC(i - 33, 10),
                            Constant.COLORARRAY[(i - 1) % 4],-1);
                    Checker.setDirection(Constant.DOWN);
                    gameData.getPathList().add(Checker);
                } else if (i < 53) {
                    Checker Checker = new Checker(getPiontByRC(14, 57 - i),
                            Constant.COLORARRAY[(i - 1) % 4],-1);
                    Checker.setDirection(Constant.LEFT);
                    gameData.getPathList().add(Checker);
                }
            }

            // 初始化十字架线路
            for (int i = 0; i < Constant.CROSS_PATH_CAPACITANCE; i++) {
                // 初始化顺序为红，黄，绿，蓝
                if (i < 6) {
                    Checker Checker = new Checker(getPiontByRC(13 - i, 7),
                            Constant.COLORARRAY[1],-1);
                    Checker.setDirection(Constant.UP);
                    gameData.getCrossList().add(Checker);
                } else if (i < 12) {
                    Checker Checker = new Checker(getPiontByRC(7, i - 5),
                            Constant.COLORARRAY[2],-1);
                    Checker.setDirection(Constant.RIGHT);
                    gameData.getCrossList().add(Checker);
                } else if (i < 18) {
                    Checker Checker = new Checker(getPiontByRC(i - 11, 7),
                            Constant.COLORARRAY[3],-1);
                    Checker.setDirection(Constant.DOWN);
                    gameData.getCrossList().add(Checker);
                } else if (i < 24) {
                    Checker Checker = new Checker(getPiontByRC(7, 31 - i),
                            Constant.COLORARRAY[0],-1);
                    Checker.setDirection(Constant.LEFT);
                    gameData.getCrossList().add(Checker);
                }
            }

            // 初始化红棋路线
            gameData.getPlayers()[0].getLine().addAll(gameData.getPathList().subList(1, 51));
            gameData.getPlayers()[0].getLine().addAll(gameData.getCrossList().subList(0, 6));

            // 初始化黄棋路线
            gameData.getPlayers()[1].getLine().addAll(gameData.getPathList().subList(14, 53));
            gameData.getPlayers()[1].getLine().addAll(gameData.getPathList().subList(1, 12));
            gameData.getPlayers()[1].getLine().addAll(gameData.getCrossList().subList(6, 12));

            // 初始化绿棋路线
            gameData.getPlayers()[2].getLine().addAll(gameData.getPathList().subList(27, 53));
            gameData.getPlayers()[2].getLine().addAll(gameData.getPathList().subList(1, 25));
            gameData.getPlayers()[2].getLine().addAll(gameData.getCrossList().subList(12, 18));

            // 初始化蓝棋路线
            gameData.getPlayers()[3].getLine().addAll(gameData.getPathList().subList(40, 53));
            gameData.getPlayers()[3].getLine().addAll(gameData.getPathList().subList(1, 38));
            gameData.getPlayers()[3].getLine().addAll(gameData.getCrossList().subList(18, 24));

//            // 初始化所有玩家老家信息
//            for (int i = 0; i < 4; i++) {
//                gameData.getRedHome()[i] = new Checker(getLoc(Constant.RED_FIRST_LOC, i),
//                        Constant.TYPE_RED);
////                redHome[i].setDirection(Constant.RIGHT ) ;
//
//                gameData.getYellowHome()[i] = new Checker(getLoc(Constant.YELLOW_FIRST_LOC,
//                        i), Constant.TYPE_YELLOW);
////                yellowHome[i].setDirection(Constant.DOWN) ;
//
//                gameData.getGreenHome()[i] = new Checker(
//                        getLoc(Constant.GREEN_FIRST_LOC, i), Constant.TYPE_GREEN);
////                greenHome[i].setDirection(Constant.LEFT) ;
//
//
//                gameData.getBlueHome()[i] = new Checker(getLoc(Constant.BLUE_FIRST_LOC, i),
//                        Constant.TYPE_BLUE);
////                blueHome[i].setDirection(Constant.UP) ;
//            }

        }

    /**
     * 以图片最左上角为基准点
     */
    private Point getPiontByRC(int row, int col) {
        return new Point(-2 + 32 * col, 101 + 32 * row);
    }

    /**
     * 获得指定颜色的飞机数组
     * @param type 指定颜色
     */
    public Plane[] getPlane(String type,GameData gameData) {
        if (Constant.TYPE_BLUE.equals(type)) {
            return gameData.getPlayers()[3].getPlanes();
        } else if (Constant.TYPE_GREEN.equals(type)) {
            return gameData.getPlayers()[2].getPlanes();
        } else if (Constant.TYPE_RED.equals(type)) {
            return gameData.getPlayers()[0].getPlanes();
        } else if (Constant.TYPE_YELLOW.equals(type)) {
            return gameData.getPlayers()[1].getPlanes();
        }
        return null;
    }

    /**
     * 通过老家第一个点和老家的机场编号计算飞机停靠位置
     */
    private static Point getLoc(Point point, int index) {
        if (index < 2) {
            return new Point(point.x + index * 42, point.y);
        } else if (index < 4) {
            return new Point(point.x + (index - 2) * 42, point.y + 42);
        }
        return null;
    }

}
