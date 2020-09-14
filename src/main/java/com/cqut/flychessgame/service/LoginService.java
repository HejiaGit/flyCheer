package com.cqut.flychessgame.service;


import com.cqut.flychessgame.domain.database.UserInfo;

/**
 * Create with IntelliJ IDEA.
 * 登录服务类
 * @author hj
 */
public interface LoginService {

    /**
     * 注册用户
     * @param userId ID
     * @param password 密码
     */
    Boolean regisUser(Long userId,String password);

    /**
     * 用户登录
     * @param userId ID
     * @param password 密码
     */
    int loginUser(Long userId,String password);

}
