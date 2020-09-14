package com.cqut.flychessgame.service;

import com.cqut.flychessgame.domain.database.MatchInfo;
import com.cqut.flychessgame.domain.database.PlayInfo;
import com.cqut.flychessgame.domain.database.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Create with IntelliJ IDEA.
 * 信息提取和存储服务
 * @author hj
 */
public interface PlayInfoService {
    /**
     * 修改用户信息
     * @param userInfo 用户信息
     */
    int changeUserInfo(UserInfo userInfo,String nPassword);

    /**
     * 获得用户详细信息
     * @param userId 用户id
     */
    UserInfo getUserInfo(Long userId);

    /**
     * 获得用户历史战绩信息
     */
    PlayInfo getPlayInfo(Long userId);

    /**
     * 重置用户历史战绩信息 传入用户ID，人机对战标识，是否胜利
     */
    void setPlayInfo(Long userId,int sign,boolean isWin);

    /**
     * 存储战绩历史
     */
    void saveCombat(Long spoId,Long accId,Long winId);

    /**
     * 获得匹配信息,返回标识（null：等待匹配 matchInfo：匹配信息）
     * @param userId 请求方ID
     */
    MatchInfo getMatchInfo(Long userId);

    /**
     * 将移动信息存入数据库中,传入存储对象
     */
    void saveMoveInfo(Long spoId,Long accId,int sign,Object o);

    /*
     * 删除指定标识对应的数据
     * @param sign 删除除指定标识的所有数据
     */
    void deleteGameData(int sign);

    /**
     * 查找本轮需要运行的内容
     * @return 返回跳转位置
     */
    ArrayList<Object> searchCheckers(Long spoId, Long accId, int sign);

}
