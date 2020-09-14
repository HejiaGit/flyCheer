package com.cqut.flychessgame.controller;

import com.cqut.flychessgame.FlychessgameApplication;
import com.cqut.flychessgame.domain.database.MatchInfo;
import com.cqut.flychessgame.domain.database.PlayInfo;
import com.cqut.flychessgame.domain.database.UserInfo;
import com.cqut.flychessgame.domain.gameEntity.Checker;
import com.cqut.flychessgame.domain.gameEntity.Dice;
import com.cqut.flychessgame.domain.gameEntity.GameData;
import com.cqut.flychessgame.domain.gameEntity.Role;
import com.cqut.flychessgame.service.GameService;
import com.cqut.flychessgame.service.PlayInfoService;
import com.cqut.flychessgame.speechRecognition.RecodeResult;
import com.cqut.flychessgame.util.ClipboardUitl;
import com.cqut.flychessgame.util.Constant;
import com.cqut.flychessgame.util.GameDataUtil;
import com.cqut.flychessgame.util.GameResource;
import com.cqut.flychessgame.view.UserInfoStageView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Create with IntelliJ IDEA.
 *
 * @author hj
 */
@FXMLController
@Slf4j
public class PlayStageController implements Initializable {

    @FXML
    private Label gameId;

    @FXML
    private Label gameNickName;

    @FXML
    private Label sex;

    @FXML
    private Label days;

    @FXML
    private Button portrait;

    @FXML
    private Label ppTotal;

    @FXML
    private Label win;

    @FXML
    private Label fail;

    @FXML
    private Label todayDate;

    @FXML
    private Label prTotal;

    @FXML
    private Label hWin;

    @FXML
    private Label hFail;

    @FXML
    private Label prHTotal;

    @FXML
    private Label ppHTotal;

    @FXML
    private Label hLoginDate;


    @FXML
    private ImageView rp1; //黄色飞机

    @FXML
    private ImageView rp2;

    @FXML
    private ImageView rp3;

    @FXML
    private ImageView rp4;

    @FXML
    private ImageView yp1; //黄色飞机

    @FXML
    private ImageView yp2;

    @FXML
    private ImageView yp3;

    @FXML
    private ImageView yp4;

    @FXML
    private ImageView gp1; //绿色飞机

    @FXML
    private ImageView gp2;

    @FXML
    private ImageView gp3;

    @FXML
    private ImageView gp4;

    @FXML
    private ImageView bp1; //蓝色飞机

    @FXML
    private ImageView bp2;

    @FXML
    private ImageView bp3;

    @FXML
    private ImageView bp4;

    @FXML
    private ImageView diceR; //红色飞机对应的色子

    @FXML
    private ImageView diceY; //黄色飞机对应的色子

    @FXML
    private ImageView diceG; //绿色飞机对应的色子

    @FXML
    private ImageView diceB; //蓝色飞机对应的色子

    @FXML
    private ImageView warnPic;//提醒玩家掷色子图片

    @FXML
    private ImageView rw;//胜利方图片

    @FXML
    private Button gameStart;

    @FXML
    private Button Ydice;

    @FXML
    private Button startRecord;

    @FXML
    private Button endRecord;

    @FXML
    private Text recordResults; //语音识别结果显示

    @FXML
    private Text textInfo;//胜利显示

    @Autowired
    PlayInfoService playInfoService;

    @Autowired
    GameService gameService;

    @Autowired
    GameDataUtil gameDataUtil;

    public static Long userId = 18780462616L;

    private static int sign = -1; //匹配成功标识

    private static Long spoId = 0L;//约战方id

    private static Long accId = 0L;//接受方id

    private static int perToper = 0;//人机或人人对战标识 1人人

    private static int isSponsor = 0;//人人对战时是否为发起方

    private static int judge = -1;//判断本次扫描时是否已经做过扫描状态

    private ArrayList<Object> checkers = new ArrayList<>(); //本轮所有需要移动/改变的图片

    private static GameData gameData = new GameData();

    private static RecodeResult recodeResult = new RecodeResult(); //语音识别类

//    private static int count = 0;//按下语音识别键的次数


    /**
     * 退出游戏
     *
     * @param event 监听
     */
    @FXML
    public void onSwitch(ActionEvent event) {
        showWarning(2);
    }

    /**
     * 修改个人信息
     *
     * @param event 事件监听
     */
    @FXML
    public void changeInfo(ActionEvent event) {
        portrait.getOnMouseClicked();
        UserInfoStageController.userId = this.userId;
        FlychessgameApplication.getStage().close();
        FlychessgameApplication.showView(UserInfoStageView.class);
    }

    //游戏开始,按钮显示
    @FXML
    public void gameStarts(ActionEvent event) {
        int result = showWarning(3);
        if (result != 0) {
            if (result == 1) {
                recordResults.setVisible(true);
                startRecord.setVisible(true);
                warnPic.setVisible(true);
                //游戏开始
                System.out.println("人机对战");
                playDetail(1);
                gameStart.setVisible(false); //隐藏开始按钮
            } else if (result == 2) {
                System.out.println("人人对战：");
                //匹配
                int re = showWarning(5);
                if (re == 1) {//匹配成功
                    gameData.getPlayers()[2].setPlayer(true); //将第三方改为玩家操作
                    Timer timers = new Timer();
                    timers.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            playWithPlayer(); //定时扫描进行实时检测
                        }
                    }, 1000, 3000);
                    gameStart.setVisible(false); //隐藏按钮
                } else {
                    //删除表中匹配信息
                    playInfoService.deleteGameData(-1);
                    System.out.println("取消人人对战");
                }
            }
        }

    }


    //对战得路径函数
    @FXML
    public void Ydices(ActionEvent event) {
        checkers.clear();
        if (perToper == 1) {
            checkers.add(gameData.getPlayers()[isSponsor].getDice().getNumber());
        }
        //人机
        if (gameData.isClick()) {
            gameData.setChoice(true);
            planeMove();
            if (perToper == 0) { //人机时需要通过计算机控制其他三方
                while (!gameData.getPlayers()[gameData.getCurrentRole()].isPlayer()) {
                    if (gameData.getWinRole() != -1) { //出现胜利方
                        break;
                    }
                    throwDiceAuto();
                    planeMoveAuto();
                }
            }
        }
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                //移动面板
                setPlaneLoc("save");
            }
        });
        gameData.setClick(false);
        gameData.setChoice(false);
        if (gameData.getWinRole() != -1) {
            //某一方胜利
            displayWin();
        }
    }

    //胜利函数
    private void displayWin() {
        if (perToper == 0) { //人机
            if (gameData.getWinRole() == 0) { //玩家胜利
                playInfoService.setPlayInfo(userId, 0, true);
            } else {
                playInfoService.setPlayInfo(userId, 0, false);
            }
        } else { //人人
            playInfoService.deleteGameData(0);
            if (isSponsor == 0) { //发起方
                if (gameData.getWinRole() == 0) {
                    playInfoService.setPlayInfo(userId, 1, true);
                    playInfoService.saveCombat(spoId, accId, spoId);
                } else {
                    playInfoService.setPlayInfo(userId, 1, false);
                    playInfoService.saveCombat(spoId, accId, accId);
                }
            } else { //接受方
                if (gameData.getWinRole() == 2) {
                    playInfoService.setPlayInfo(userId, 1, true);
                } else {
                    playInfoService.setPlayInfo(userId, 1, false);
                }
            }
        }


    }

    /**
     * 初始化玩家和角色航线信息
     */
    private void initPlayers() {
        gameData.getPlayers()[0] = new Role(true, Constant.TYPE_RED);
        gameData.getPlayers()[0].setPlayer(true);
        gameData.getPlayers()[1] = new Role(false, Constant.TYPE_YELLOW);
        gameData.getPlayers()[2] = new Role(false, Constant.TYPE_GREEN);
        gameData.getPlayers()[3] = new Role(false, Constant.TYPE_BLUE);
        //初始化角色和航线等信息
        gameDataUtil.GameDataInit(gameData);
        //初始化色子
        initDices();
    }

    /**
     * 初始化色子
     */
    private void initDices() {
        // 初始化色子
        Dice dice1 = new Dice();
        //玩家的色子
        dice1.setPlayerDice(true);
        gameData.getPlayers()[0].setDice(dice1);
        Dice dice2 = new Dice();
        gameData.getPlayers()[1].setDice(dice2);
        Dice dice3 = new Dice();
        gameData.getPlayers()[2].setDice(dice3);
        Dice dice4 = new Dice();
        gameData.getPlayers()[3].setDice(dice4);
    }

    /**
     * 填充信息
     */
    private void fillInfo() {
        UserInfo userInfo = playInfoService.getUserInfo(userId);
        PlayInfo playInfo = playInfoService.getPlayInfo(userId);
        //填用户信息
        gameId.setText(userId.toString());
        if (userInfo.getNickname() == null) {
            gameNickName.setText(userId.toString());
        } else {
            gameNickName.setText(userInfo.getNickname());
        }
        if (userInfo.getSex().equals("f")) {
            sex.setText("女");
        } else if (userInfo.getSex().equals("m")) {
            sex.setText("男");
        } else {
            sex.setText("保密");
        }
        Date date = new Date();
        days.setText(betweenDays(userInfo.getCreatedate(), date) + " 天");
        //填对局信息
        ppHTotal.setText(String.valueOf(playInfo.getPlaycount() - playInfo.getPlaytor()));
        prHTotal.setText(playInfo.getPlaytor().toString());
        hWin.setText(playInfo.getWincount().toString());
        hFail.setText(String.valueOf(playInfo.getPlaycount() - playInfo.getWincount()));
        hLoginDate.setText(changeDate(userInfo.getLogindate()));
        //填今日对局信息
        ppTotal.setText("0");
        prTotal.setText("0");
        win.setText("0");
        fail.setText("0");
        todayDate.setText(changeDate(new Date()));
    }

    /**
     * 转换时间
     */
    private String changeDate(Date date) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dates = "";
        try {
            dates = formatter.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dates;
    }


    //计算经过天数
    private String betweenDays(Date date1, Date date2) {
        Long days = (date2.getTime() - date1.getTime()) / (3600 * 24 * 1000) + 1;
        return days.toString();
    }

    /*
     * 解析玩家飞机移动位置
     */
    private void planeMove() {
        ArrayList<Checker> checkerMove = gameService.judgePlayerThrowResult(gameData);
        if (checkerMove != null) {
            checkers.addAll(checkerMove);
        }
        if (gameData.getPlayers()[gameData.getCurrentRole()].getDice().getNumber() != 6) {
            //移动以后换下一个玩家
            gameData.setCurrentRole(gameData.getCurrentRole() + 1);
        }
        if (gameData.getCurrentRole() == 4) {
            gameData.setCurrentRole(0);
            //操作初始化
            gameData.setChoice(false);
            gameData.setClick(false);
        }
    }

    /**
     * 移动imageView标签位置指定位置和改变图片方向
     */
    private void moveImage(Checker checker) {
        //位置
        Point point = checker.getLocation();
        //方向
        int direction = checker.getDirection() - 1;
        //需移动到该格的飞机号
        int planNum = checker.getPlaneNum();
        if (checker.getCellColor().equals("r")) {
            //红
            Image image = GameResource.redPlaneImgArray[direction];
            if (planNum == 0) {
                rp1.setImage(image);
                rp1.setLayoutX(point.getX());
                rp1.setLayoutY(point.getY());
            } else if (planNum == 1) {
                rp2.setImage(image);
                rp2.setLayoutX(point.getX());
                rp2.setLayoutY(point.getY());
            } else if (planNum == 2) {
                rp3.setImage(image);
                rp3.setLayoutX(point.getX());
                rp3.setLayoutY(point.getY());
            } else if (planNum == 3) {
                rp4.setImage(image);
                rp4.setLayoutX(point.getX());
                rp4.setLayoutY(point.getY());
            }
        } else if (checker.getCellColor().equals("y")) {
            //黄
            Image image = GameResource.yellowPlaneImgArray[direction];
            if (planNum == 0) {
                yp1.setImage(image);
                yp1.setLayoutX(point.getX());
                yp1.setLayoutY(point.getY());
            } else if (planNum == 1) {
                yp2.setImage(image);
                yp2.setLayoutX(point.getX());
                yp2.setLayoutY(point.getY());
            } else if (planNum == 2) {
                yp3.setImage(image);
                yp3.setLayoutX(point.getX());
                yp3.setLayoutY(point.getY());
            } else {
                yp4.setImage(image);
                yp4.setLayoutX(point.getX());
                yp4.setLayoutY(point.getY());
            }
        } else if (checker.getCellColor().equals("g")) {
            //绿
            Image image = GameResource.greenPlaneImgArray[direction];
            if (planNum == 0) {
                gp1.setImage(image);
                gp1.setLayoutX(point.getX());
                gp1.setLayoutY(point.getY());
            } else if (planNum == 1) {
                gp2.setImage(image);
                gp2.setLayoutX(point.getX());
                gp2.setLayoutY(point.getY());
            } else if (planNum == 2) {
                gp3.setImage(image);
                gp3.setLayoutX(point.getX());
                gp3.setLayoutY(point.getY());
            } else {
                gp4.setImage(image);
                gp4.setLayoutX(point.getX());
                gp4.setLayoutY(point.getY());
            }
        } else {
            //蓝
            Image image = GameResource.bluePlaneImgArray[direction];
            if (planNum == 0) {
                bp1.setImage(image);
                bp1.setLayoutX(point.getX());
                bp1.setLayoutY(point.getY());
            } else if (planNum == 1) {
                bp2.setImage(image);
                bp2.setLayoutX(point.getX());
                bp2.setLayoutY(point.getY());
            } else if (planNum == 2) {
                bp3.setImage(image);
                bp3.setLayoutX(point.getX());
                bp3.setLayoutY(point.getY());
            } else {
                bp4.setImage(image);
                bp4.setLayoutX(point.getX());
                bp4.setLayoutY(point.getY());
            }
        }

    }

    /**
     * 玩家掷骰子操作
     */
    private void throwDiceAuto() {
        int diceNum = gameService.throwDice(6);
//        int diceNum = 6;
        checkers.add(diceNum);
        if (gameData.getCurrentRole() == 4) {
            //循环回红色
            gameData.setCurrentRole(0);
        }
        gameData.getPlayers()[gameData.getCurrentRole()].getDice().setNumber(diceNum);
        System.out.println(gameData.getCurrentRole() + "角色投掷到" + diceNum + "点");
    }

    /**
     * 自动移动飞机操作
     */
    private void planeMoveAuto() {
        ArrayList<Checker> checkerMove = gameService.judgeCompThrowResult(gameData);
        if (checkerMove != null) {
            checkers.addAll(checkerMove);

        }
        if (gameData.getPlayers()[gameData.getCurrentRole()].getDice().getNumber() != 6) {
            //移动以后换下一个玩家
            gameData.setCurrentRole(gameData.getCurrentRole() + 1);
        }
        //看角色是否需要改变
        if (gameData.getCurrentRole() == 4) {
            //掷色子和选飞机重置,角色回到红色
            gameData.setCurrentRole(0);
            gameData.setClick(false);
            gameData.setChoice(false);
        }

    }

    /**
     * 胜利方显示信息
     */
    private void winInfo(int num) {
        Image image = null;
        if (num == 0) {
            //红方
            image = GameResource.RED_CROWN;
            textInfo.setText("恭喜红方玩家获得胜利！");
        } else if (num == 1) {
            //黄方
            image = GameResource.YELLOW_CROWN;
            textInfo.setText("恭喜黄方玩家获得胜利！");
        } else if (num == 2) {
            //绿方
            image = GameResource.GREEN_CROWN;
            textInfo.setText("恭喜绿方玩家获得胜利！");
        } else if (num == 3) {
            image = GameResource.BLUE_CROWN;
            textInfo.setText("恭喜蓝方玩家获得胜利！");
        }
        rw.setImage(image);
        rw.setVisible(true);
        textInfo.setVisible(true);
    }

    //角色转色子图片函数
    private ImageView roleToDice(int num) {
        ImageView diceImage = null;
        if (num == 0) {
            //红
            diceImage = diceR;
        } else if (num == 1) {
            //黄
            diceImage = diceY;
        } else if (num == 2) {
            //绿
            diceImage = diceG;
        } else if (num == 3) {
            //蓝
            diceImage = diceB;
        }
        return diceImage;
    }

    /*
     * 使用定时器+多线程方式实现飞机和色子变化
     */
    private void setPlaneLoc(String oper) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int r = 0;
            int roleDice = 1;
//            int roleDice2 = 2;

            public void run() {
                if (r < checkers.size()) {
                    if (checkers.get(r) instanceof Integer) {
                        //存的色子的值
                        int diceNum = (int) checkers.get(r);
                        ImageView imageView = null;
                        if (perToper == 1) { //人人
                            if(!"save".equals(oper)){
                                if (isSponsor == 0) {
                                    imageView = roleToDice(2);
                                } else if (isSponsor == 2) {
                                    imageView = roleToDice(0);
                                }
                            } else {
                                if (isSponsor == 0) {
                                    imageView = roleToDice(0);
                                } else if (isSponsor == 2) {
                                    imageView = roleToDice(2);
                                }
                            }
                        } else {//人机
                            imageView = roleToDice(roleDice);
                            if (diceNum != 6) {
                                roleDice++;
                            }
                        }
                        imageView.setImage(GameResource.DICE[diceNum]);
                    } else {
                        Checker checker = (Checker) checkers.get(r);
                        moveImage(checker);
                    }
                } else {
                    if (perToper == 1) {
                        if ("save".equals(oper)) {
                            //人人对战需要向数据库存内容
                            //判断此时是否需要存储信息
                            if (gameData.getPlayers()[isSponsor].getDice().getNumber() != 6) {
                                sign++; //对象是否变化
                            }
                            playInfoService.saveMoveInfo(spoId, accId, sign, checkers);
                        } else {
                            //删除数据库中内容
                            playInfoService.deleteGameData(0);
                        }
                    }
                    if (gameData.getWinRole() != -1) {
                        //某一方胜利
                        winInfo(gameData.getWinRole());
                    } else {
                        warnPic.setVisible(true); //提示掷色子图片
                    }
                    timer.cancel();
                }
                r++;
            }
        }, 0, 800);
    }


    /*
     * 对战流程控制函数
     */
    private void playDetail(int type) {
        if (type == 2) {
            //人人
            perToper = 1;
        }
        //开始录音
        startRecord.setOnAction(event -> {
            //改变按钮
            startRecord.setVisible(false);
            endRecord.setVisible(true);
            recordResults.setText("");
            recodeResult.startRecord();
        });
        endRecord.setOnAction(event -> {
            endRecord.setVisible(false);
            startRecord.setVisible(true);
            recodeResult.stopRecord();
            String result = ClipboardUitl.getClipboardString();
            if (result != null && !result.equals("")) {
                recordResults.setText(result);
                if (result.contains("掷") || result.contains("摇")) {
                    gameData.setRecord(true);
                    gameData.setClick(true);
                    warnPic.setVisible(false);
                    gameData.setCurrentRole(isSponsor);
                    throwDiceAuto(); //掷色子
                    if (gameData.getPlayers()[isSponsor].getDice().getNumber() != 6) {
                        if (perToper == 1 && isSponsor == 2) {
                            diceG.setImage(GameResource.DICE[gameData.getPlayers()[isSponsor].getDice().getNumber()]);
                        } else {
                            diceR.setImage(GameResource.DICE[gameData.getPlayers()[isSponsor].getDice().getNumber()]);
                        }
//                        //判断飞机起飞数
                        if (gameService.getOutPlane(gameData.getPlayers()[isSponsor].getPlanes()) > 1) {
                            //若有大于1的飞机起飞，则需要选择飞机
                            recordResults.setText("请选择飞机飞行");
                        } else {
                            Ydice.fire();
                        }
                    } else {
                        if (perToper == 1 && isSponsor == 2) {
                            diceG.setImage(GameResource.DICE[6]); //掷到六点单独运行图片变化
                        } else {
                            diceR.setImage(GameResource.DICE[6]); //掷到六点单独运行图片变化
                        }
                        recordResults.setText("请选择飞机飞行");
                    }
                } else if (result.contains("飞机")) {
                    if (gameData.isClick()) {
                        int diceJud = gameData.getPlayers()[isSponsor].getDice().getNumber();
                        if (result.contains("1") || result.contains("一")) {
                            if (gameData.getPlayers()[isSponsor].getPlanes()[0].getLoc() == -3) {
                                //飞机已经到达目的地
                                showWarning(1);
                            } else if (diceJud != 6 && gameData.getPlayers()[isSponsor].getPlanes()[0].getLoc() == -2) {
                                //色子点数不为6，选择飞机又未起飞
                                showWarning(4);
                            } else {
                                gameData.setNumberOfCurrentPlane(0);
                                Ydice.fire();
                            }
                        } else if (result.contains("2") || result.contains("二")) {
                            if (gameData.getPlayers()[isSponsor].getPlanes()[1].getLoc() == -3) {
                                showWarning(1);
                            } else if (diceJud != 6 && gameData.getPlayers()[isSponsor].getPlanes()[1].getLoc() == -2) {
                                showWarning(4);
                            } else {
                                gameData.setNumberOfCurrentPlane(1);
                                Ydice.fire();
                            }
                        } else if (result.contains("3") || result.contains("三")) {
                            if (gameData.getPlayers()[isSponsor].getPlanes()[2].getLoc() == -3) {
                                showWarning(1);
                            } else if (diceJud != 6 && gameData.getPlayers()[isSponsor].getPlanes()[2].getLoc() == -2) {
                                showWarning(4);
                            } else {
                                gameData.setNumberOfCurrentPlane(2);
                                Ydice.fire();
                            }
                        } else if (result.contains("4") || result.contains("四")) {
                            if (gameData.getPlayers()[isSponsor].getPlanes()[3].getLoc() == -3) {
                                showWarning(1);
                            } else if (diceJud != 6 && gameData.getPlayers()[isSponsor].getPlanes()[3].getLoc() == -2) {
                                showWarning(4);
                            } else {
                                gameData.setNumberOfCurrentPlane(3);
                                Ydice.fire();
                            }
                        } else {
                            recordResults.setText("请选择正确的飞机。");
                        }
                    } else {
                        recordResults.setText("您好，请先摇色子。");
                        warnPic.setVisible(true);
                    }
                } else if (result.contains("幸运数字")) {
                    //执行幸运数字指令
                    if (gameData.getChance() > 0 && isSponsor == 0) {
                        gameData.setChance(gameData.getChance() - 1);
                        gameData.setRecord(true);
                        gameData.setClick(true);
                        warnPic.setVisible(false);
                        gameData.setCurrentRole(isSponsor);
                        diceR.setImage(GameResource.DICE[6]); //掷到六点单独运行图片变化
                        gameData.getPlayers()[0].getDice().setNumber(6);
                        recordResults.setText("请选择飞机飞行");
                    } else {
                        recordResults.setText("幸运数字次数已用完！");
                    }
                } else {
                    recordResults.setText("指令不正确！");
                }
            } else {
                recordResults.setText("您好像没有说话哦！");
            }
        });
    }

    /*
     * 人人对战函数
     */
    private void playWithPlayer() {
        int flag = 0; //标记该运行哪种情况
        ArrayList<Object> list = playInfoService.searchCheckers(spoId, accId, 0);
        if (userId.longValue() == spoId.longValue()) {
            //本局是发起方,控制红色
            if (list != null && list.size() > 0) {
                judge = 1;
                sign = (int) list.get(0);
                list.remove(0); //移除标记
                //发起方运行
                if (sign % 2 == 0) {
                    flag = 1;
                } else {
                    recordResults.setText("等待对方操作");
                    recordResults.setVisible(true);
                    startRecord.setVisible(false);
                    warnPic.setVisible(false);
                    judge = 0;
                }
            } else if (judge == -1 || judge == 1) {
                //第一次进
                flag = 1;
            } else {
                recordResults.setText("等待对方操作");
                recordResults.setVisible(true);
                startRecord.setVisible(false);
                warnPic.setVisible(false);
                judge = 0;
            }
        } else {
            //本局是接收方,控制绿色
            isSponsor = 2;
            if (list != null && list.size() > 0) {
                judge = 1;
                sign = (int) list.get(0);
                list.remove(0); //移除标记
                //发起方运行
                if (sign % 2 == 1) {
                    flag = 1;
                } else {
                    recordResults.setText("等待对方操作");
                    recordResults.setVisible(true);
                    startRecord.setVisible(false);
                    warnPic.setVisible(false);
                    judge = 0;
                }
            } else if (judge == 1) {
                flag = 1;
            } else {
                recordResults.setText("等待对方操作");
                recordResults.setVisible(true);
                startRecord.setVisible(false);
                warnPic.setVisible(false);
                judge = 0;
            }
        }
        //运行内容
        if (flag == 1) {
            if (list != null && list.size() > 0) {
                checkers = list;
                //承接上一个角色的信息并运行,此时不需要保存数据
                setPlaneLoc("notSave");
            }
            recordResults.setText("");
            recordResults.setVisible(true);
            startRecord.setVisible(true);
            warnPic.setVisible(true);
            playDetail(2);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //打开背景音乐
//        openBGM() ;
        //初始化玩家等信息
        initPlayers();
        //填信息
        fillInfo();
        //相关按钮隐藏
        Ydice.setVisible(false);
        recordResults.setVisible(true);

    }

    /**
     * @param type 显示提示信息
     */
    private int showWarning(int type) {
        if (type == 1 || type == 4) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("提示");
            if (type == 1) {
                alert.setContentText("该飞机已经到达目的地，请重新选择飞机");
            } else {
                alert.setContentText("该飞机还未起飞，请重新选择飞机");
            }
            alert.showAndWait();
            return 0;
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            ButtonType buttonTypeCancel = new ButtonType("取消", ButtonBar.ButtonData.CANCEL_CLOSE);
            if (type == 2) {
                alert.setTitle("提示");
                alert.setContentText("确认退出游戏？");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    System.exit(0);
                }
            } else if (type == 3) {
                alert.setTitle("游戏选择");
                alert.setContentText("请选择你想玩的游戏类型");
                ButtonType buttonTypeOne = new ButtonType("人机对战");
                ButtonType buttonTypeTwo = new ButtonType("双人对战");
                alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == buttonTypeOne) {
                    return 1;
                } else if (result.isPresent() && result.get() == buttonTypeTwo) {
                    return 2;
                } else {
                    return 0;
                }
            } else {
                alert.setTitle("玩家匹配中...");
                alert.setContentText("正在进行玩家匹配，请稍后...");
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        MatchInfo matchInfo = playInfoService.getMatchInfo(userId);
                        if (matchInfo != null && matchInfo.getSign() == 0) {
                            sign = 0; //匹配成功
                            spoId = matchInfo.getSponsorid();
                            accId = matchInfo.getAcceptid();
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    alert.setContentText("匹配成功");
                                }
                            });
                            timer.cancel();
                        }
                    }
                }, 0, 2000);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.CANCEL) {
                    return 0;
                } else if (result.isPresent() && result.get() == ButtonType.OK) {
                    if (sign == 0) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}
