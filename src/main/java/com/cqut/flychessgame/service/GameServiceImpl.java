package com.cqut.flychessgame.service;

import com.cqut.flychessgame.domain.gameEntity.*;
import com.cqut.flychessgame.util.Constant;
import com.cqut.flychessgame.util.GameDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

/**
 * Create with IntelliJ IDEA.
 * 组件服务
 *
 * @author hj
 */
@Service
public class GameServiceImpl implements GameService {

    @Autowired
    GameDataUtil gameDataUtil;

    @Override
    public int throwDice(int bound) {
        // 随机数制造
        Random random = new Random();
        int temp = random.nextInt(bound);
        return temp + 1;
    }

    @Override
    public ArrayList<Checker> judgePlayerThrowResult(GameData gameData) {
        ArrayList<Checker> checkers = null;
        int flag = gameData.getCurrentRole();
        int diceNumber = gameData.getPlayers()[flag].getDice().getNumber();
        if (diceNumber == 6) {
            // 移动选中的飞机
            checkers = movePlane(gameData, diceNumber);
        } else {
            int tempNum = 0;
            // 获得该玩家所有飞机
            Plane[] planes = gameData.getPlayers()[flag].getPlanes();
            // 统计所有启航的飞机
            tempNum = getOutPlane(planes);
            //没有飞机能移动,换下一个玩家
            if (tempNum == 0) {
                return null;
            }
            // 移动选中的飞机
            checkers = movePlane(gameData, diceNumber);
        }
        //判断本飞机停留位置是否需要轰炸
        if (checkers != null && checkers.size() > 0) {
            Checker checkerLoc = checkers.get(checkers.size() - 1);
            //飞机轰炸
            List<Plane> planes = judgeIsBomb(gameData, checkerLoc);
            if (planes != null) {
                ArrayList<Checker> arrayList = null;
                if (planes.size() == 1) {
                    arrayList = bombPlane(gameData, planes);
                    if (arrayList.size() > 0) {
                        checkers.addAll(arrayList);
                    }
                } else if (planes.size() == 2) {
                    checkers.remove(checkers.size() - 1); //遇到同色的两个飞机，其他飞机不可跳至该位置
                    //飞机位置减一
                    Plane plane = gameData.getPlayers()[flag].getPlanes()[gameData.getNumberOfCurrentPlane()];
                    plane.setLoc(plane.getLoc() - 1);

                }
            }
        }
        return checkers;

    }

    @Override
    public ArrayList<Checker> judgeCompThrowResult(GameData gameData) {
        ArrayList<Checker> checkers = null;
        int flag = gameData.getCurrentRole();
        int diceNumber = gameData.getPlayers()[flag].getDice().getNumber();
        Plane[] planes = gameData.getPlayers()[flag].getPlanes();
        if (diceNumber == 6) {
            int temp = getOutPlane(planes);
            //没有飞机已起飞
            if (temp == 0) {
                //指定本轮移动飞机为第一架
                gameData.setNumberOfCurrentPlane(temp);
            } else {
                int index = isGetDes(planes, diceNumber);
                if (index != -1) {
                    gameData.setNumberOfCurrentPlane(index);
                } else if (isDoubleMoving(gameData.getPlayers()[flag]) != -1) {
                    gameData.setNumberOfCurrentPlane(isDoubleMoving(gameData.getPlayers()[flag]));
                } else if (getPlaneIndexAtHome(planes) != -1)
                    gameData.setNumberOfCurrentPlane(getPlaneIndexAtHome(planes));
                else {
                    gameData.setNumberOfCurrentPlane(getNearDes(planes));
                }

            }
            checkers = movePlane(gameData, diceNumber);
        } else {
            if (getOutPlane(planes) != 0) {
                int index = isGetDes(planes, diceNumber);
                if (index != -1) {
                    gameData.setNumberOfCurrentPlane(index);
                } else if (isDoubleMoving(gameData.getPlayers()[flag]) != -1) {
                    gameData.setNumberOfCurrentPlane(isDoubleMoving(gameData.getPlayers()[flag]));
                } else {
                    gameData.setNumberOfCurrentPlane(getNearDes(planes));
                }
                checkers = movePlane(gameData, diceNumber);
            }
        }
        //判断本飞机停留位置是否需要轰炸
        if (checkers != null && checkers.size() > 0) {
            Checker checkerLoc = checkers.get(checkers.size() - 1);
            //飞机轰炸
            List<Plane> planer = judgeIsBomb(gameData, checkerLoc);
            if (planer != null) {
                ArrayList<Checker> arrayList = null;
                if (planer.size() == 1) {
                    arrayList = bombPlane(gameData, planer);
                    if (arrayList.size() > 0) {
                        checkers.addAll(arrayList);
                    }
                } else if (planer.size() == 2) {
                    checkers.remove(checkers.size() - 1); //遇到同色的两个飞机，其他飞机不可跳至该位置
                    //飞机位置减一
                    Plane plane = gameData.getPlayers()[flag].getPlanes()[gameData.getNumberOfCurrentPlane()];
                    plane.setLoc(plane.getLoc() - 1);

                }
            }
        }
        return checkers;

    }

    @Override
    public ArrayList<Checker> movePlane(GameData gameData, int diceNumber) {
        ArrayList<Checker> checkers = new ArrayList<>();
        // 获得要移动的飞机
        int flag = gameData.getNumberOfCurrentPlane();
        //获得角色号
        int roleNum = gameData.getCurrentRole();
        Role role = gameData.getPlayers()[roleNum];
        Plane plane = role.getPlanes()[flag];
        // 如果该飞机在老家
        if (plane.getLoc() == -2) {
            // 飞机移动到起飞点
            Checker checker = copyChecker(getLaunchPointByTyep(plane.getPlaneType()));
            checker.setPlaneNum(plane.getIndex());
            checkers.add(checker);
            gameData.getPlayers()[roleNum].getPlanes()[flag].setLoc(-1);
        } else {
            // 获得该飞机在线路上的位置
            int increment = plane.getLoc();
            if (increment != 56) {
                // 如果移动后达不到终点
                if (plane.getLoc() + diceNumber < 55) {
                    // 直接移动
                    for (int i = 0; i < diceNumber; i++) {
                        // 飞机位置加一
                        gameData.getPlayers()[roleNum].getPlanes()[flag].setLoc(plane.getLoc() + 1);
                        // 获得要移动到哪一格的格子
                        Checker checker = copyChecker(role.getLine().get(plane.getLoc()));//航线位置
                        checker.setCellColor(numToColor(gameData.getCurrentRole()));//角色颜色
                        checker.setPlaneNum(plane.getIndex());//飞机号数
                        checkers.add(checker);
                    }
                    int temp = this.judgeIsJump(plane, gameData);
                    if (temp > 0) {
                        gameData.getPlayers()[roleNum].getPlanes()[flag].setLoc(plane.getLoc() + temp);
                        Checker checker = copyChecker(role.getLine().get(plane.getLoc()));//航线位置
                        checker.setCellColor(numToColor(gameData.getCurrentRole()));
                        checker.setPlaneNum(plane.getIndex());
                        checkers.add(checker);

                    }
                    // 如果移动后超过了终点
                } else if (plane.getLoc() + diceNumber > 55) {
                    // 计算前进的距离
                    int forwards = 55 - plane.getLoc();
                    // 计算后退的距离
                    int rears = diceNumber - forwards;
                    // 前进
                    for (int i = 0; i < forwards; i++) {
                        gameData.getPlayers()[roleNum].getPlanes()[flag].setLoc(plane.getLoc() + 1);
                        Checker checker = copyChecker(role.getLine().get(plane.getLoc()));//航线位置
                        checker.setCellColor(numToColor(gameData.getCurrentRole()));
                        checker.setPlaneNum(plane.getIndex());
                        checkers.add(checker);
                    }
                    // 后退
                    for (int i = 0; i < rears; i++) {
                        gameData.getPlayers()[roleNum].getPlanes()[flag].setLoc(plane.getLoc() - 1);
                        Checker checker = copyChecker(role.getLine().get(plane.getLoc()));//航线位置
                        checker.setCellColor(numToColor(gameData.getCurrentRole()));
                        checker.setPlaneNum(plane.getIndex());
                        checkers.add(checker);
                    }
                } else if (plane.getLoc() + diceNumber == 55) {
                    for (int i = 0; i < diceNumber; i++) {
                        gameData.getPlayers()[roleNum].getPlanes()[flag].setLoc(plane.getLoc() + 1);
                        Checker checker = copyChecker(role.getLine().get(plane.getLoc()));//航线位置
                        checker.setPlaneNum(plane.getIndex());
                        checker.setCellColor(numToColor(gameData.getCurrentRole()));
                        checkers.add(checker);
                    }
                    plane.setLoc(-3);

                    //TODO 胜利显示
                    int temp = judgeIsWin(role);
                    if (temp == 0) {
                        gameData.setWinRole(roleNum);
                        System.out.println(role.getRoleColor() + "方胜利！！！");
                    }
                }
            }
        }
        return checkers;
    }

    /**
     * 获得起飞的飞机数
     */
    @Override
    public int getOutPlane(Plane[] planes) {
        int temp = 0;
        for (Plane p : planes) {
            if (p.getLoc() > -2)
                temp++;
        }
        return temp;
    }

    /**
     * 判断有没有飞机移动后可直接到达目的地
     */
    private int isGetDes(Plane[] planes, int diceNumber) {
        for (int i = 0; i < 4; i++) {
            if (planes[i].getLoc() + diceNumber == 55)
                return i;
        }
        return -1;
    }

    /**
     * 查看指定角色的飞机中是否有飞机可以连续移动两次
     */
    private int isDoubleMoving(Role role) {
        List<Checker> path = role.getLine();
        Plane[] planes = role.getPlanes();
        int diceNumber = role.getDice().getNumber();
        for (int i = 0; i < 4; i++)
            if (planes[i].getLoc() > -2 && (planes[i].getLoc() + diceNumber) < 56)
                if (planes[i].getPlaneType().equals(path.get(planes[i].getLoc() + diceNumber).getCellColor()))
                    return i;
        return -1;
    }

    /**
     * 获得老家的飞机编号
     */
    private int getPlaneIndexAtHome(Plane[] planes) {
        for (int i = 0; i < 4; i++)
            if (planes[i].getLoc() == -2)
                return i;
        return -1;
    }

    /**
     * 判断是否有飞机要轰炸
     * 返回需要被撞回起飞点的飞机
     */
    private List<Plane> judgeIsBomb(GameData gameData, Checker checker) {
        List<Plane> planeList = new ArrayList<Plane>();

        for (int i = 0; i < 4; i++) {
            Role role = gameData.getPlayers()[i];
            if (!role.getRoleColor().equals(checker.getCellColor())) {
                Plane[] planes = role.getPlanes();
                //不同颜色
                for (Plane item : planes) {
                    if (item.getLoc() > 0 && item.getLoc() < 50) {
                        //该飞机在外围航线上，则判断有无轰炸情况
                        Checker planLoc = role.getLine().get(item.getLoc());
                        if (planLoc.getLocation().getX() == checker.getLocation().getX()
                                && planLoc.getLocation().getY() == checker.getLocation().getY()) {
                            planeList.add(item);
                        }
                    }
                }
            }
        }
        return planeList;
    }

    /**
     * 实行轰炸
     */
    private ArrayList<Checker> bombPlane(GameData gameData, List<Plane> planeList) {
        ArrayList<Checker> checkers = new ArrayList<>();
        for (Plane plane : planeList) {
            //老家颜色
            String type = plane.getPlaneType();
            //老家序号
            int index = plane.getIndex();
            Checker checker = new Checker();
            if (type.equals(Constant.TYPE_RED)) {
                if (index == 0) {
                    checker.setLocation(new Point(3, 479));
                } else if (index == 1) {
                    checker.setLocation(new Point(4, 521));
                } else if (index == 2) {
                    checker.setLocation(new Point(45, 521));
                } else {
                    checker.setLocation(new Point(46, 479));
                }
                checker.setCellColor("r");
                checker.setDirection(3);
                checker.setPlaneNum(index);
                gameData.getPlayers()[0].getPlanes()[index].setLoc(-2);
                gameData.getPlayers()[0].getPlanes()[index].setAtHome(true);
            } else if (type.equals(Constant.TYPE_YELLOW)) {
                if (index == 0) {
                    checker.setLocation(new Point(65, 106));
                } else if (index == 1) {
                    checker.setLocation(new Point(23, 106));
                } else if (index == 2) {
                    checker.setLocation(new Point(23, 149));
                } else {
                    checker.setLocation(new Point(65, 149));
                }
                checker.setCellColor("y");
                checker.setDirection(1);
                checker.setPlaneNum(index);
                gameData.getPlayers()[1].getPlanes()[index].setLoc(-2);
                gameData.getPlayers()[1].getPlanes()[index].setAtHome(true);

            } else if (type.equals(Constant.TYPE_GREEN)) {
                if (index == 0) {
                    checker.setLocation(new Point(438, 169));
                } else if (index == 1) {
                    checker.setLocation(new Point(438, 126));
                } else if (index == 2) {
                    checker.setLocation(new Point(396, 126));
                } else {
                    checker.setLocation(new Point(396, 169));
                }
                checker.setCellColor("g");
                checker.setDirection(2);
                checker.setPlaneNum(index);
                gameData.getPlayers()[2].getPlanes()[index].setLoc(-2);
                gameData.getPlayers()[2].getPlanes()[index].setAtHome(true);
            } else {
                if (index == 0) {
                    checker.setLocation(new Point(376, 540));
                } else if (index == 1) {
                    checker.setLocation(new Point(418, 540));
                } else if (index == 2) {
                    checker.setLocation(new Point(418, 499));
                } else {
                    checker.setLocation(new Point(376, 499));
                }
                checker.setCellColor("b");
                checker.setDirection(4);
                checker.setPlaneNum(index);
                gameData.getPlayers()[3].getPlanes()[index].setLoc(-2);
                gameData.getPlayers()[3].getPlanes()[index].setAtHome(true);
            }
            checkers.add(checker);
        }
        return checkers;
    }

    /**
     * 判断是否需要跳跃
     */
    private int judgeIsJump(Plane plane, GameData gameData) {
        String type = plane.getPlaneType();
        List<Checker> line = getLine(type, gameData);
        if (plane.getLoc() > 48)
            return 0;
        if (line.get(plane.getLoc()).getCellColor().equals(plane.getPlaneType()) && plane.getLoc() == 17)
            return 12;
        else if (line.get(plane.getLoc()).getCellColor().equals(plane.getPlaneType()))
            return 4;
        return 0;
    }


    /**
     * 随机选择一架飞机起飞
     */
    private int getNearDes(Plane[] planes) {
        int temp = 0;
        Random random = new Random();
        while (true) {
            temp = random.nextInt(4);
            if (planes[temp].getLoc() > -2)
                return temp;
        }
    }

    /**
     * 判断当前角色输赢情况
     * -1：没有任何一方赢 0：赢了 -1：未赢
     */
    private int judgeIsWin(Role role) {
        Plane[] planes = role.getPlanes();
        int temp = 0;
        for (int i = 0; i < 4; i++)
            if (planes[i].getLoc() == -3)
                temp++;
        if (temp == 4)
            return 0;
        return -1;
    }

    /**
     * 不同飞机起飞点的信息
     *
     * @param type
     */
    public Checker getLaunchPointByTyep(String type) {
        Checker checker = new Checker();
        if (Constant.TYPE_BLUE.equals(type)) {
            checker.setLocation(Constant.BLUE_LAUNCH);
            checker.setDirection(4);
            checker.setCellColor("b");
        } else if (Constant.TYPE_GREEN.equals(type)) {
            checker.setLocation(Constant.GREEN_LAUNCH);
            checker.setDirection(2);
            checker.setCellColor("g");
        } else if (Constant.TYPE_RED.equals(type)) {
            checker.setLocation(Constant.RED_LAUNCH);
            checker.setDirection(3);
            checker.setCellColor("r");
        } else if (Constant.TYPE_YELLOW.equals(type)) {
            checker.setLocation(Constant.YELLOW_LAUNCH);
            checker.setDirection(1);
            checker.setCellColor("y");
        }
        return checker;
    }


    /**
     * 颜色和角色编号转换
     */
    private String numToColor(int num) {
        if (num == 0) {
            return "r";
        } else if (num == 1) {
            return "y";
        } else if (num == 2) {
            return "g";
        } else if (num == 3) {
            return "b";
        }
        return null;
    }

    /**
     * 获得指定颜色的线路
     *
     * @param type 指定颜色
     */
    private List<Checker> getLine(String type, GameData gameData) {
        if (Constant.TYPE_BLUE.equals(type)) {
            return gameData.getPlayers()[3].getLine();
        } else if (Constant.TYPE_GREEN.equals(type)) {
            return gameData.getPlayers()[2].getLine();
        } else if (Constant.TYPE_RED.equals(type)) {
            return gameData.getPlayers()[0].getLine();
        } else if (Constant.TYPE_YELLOW.equals(type)) {
            return gameData.getPlayers()[1].getLine();
        }
        return null;
    }

    /**
     * 获得指定checker的所有信息
     */
    private Checker copyChecker(Checker checker) {
        Checker checker1 = new Checker();
        checker1.setDirection(checker.getDirection());
        checker1.setPlaneNum(checker.getPlaneNum());
        checker1.setLocation(checker.getLocation());
        checker1.setCellColor(checker.getCellColor());
        return checker1;
    }
}
