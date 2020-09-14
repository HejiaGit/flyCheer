package com.cqut.flychessgame.service;

import com.cqut.flychessgame.domain.database.PlayInfo;
import com.cqut.flychessgame.domain.database.UserInfo;
import com.cqut.flychessgame.mapper.PlayInfoMapper;
import com.cqut.flychessgame.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Create with IntelliJ IDEA.
 *
 * @author hj
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    PlayInfoMapper playInfoMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    @Transactional
    public Boolean regisUser(Long userId,String password) {
        Date date = new Date();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserid(userId);
        userInfo.setPassword(password);
        userInfo.setCreatedate(date);
        userInfo.setLogindate(date);
        PlayInfo playInfo = new PlayInfo();
        playInfo.setUserid(userId);
        try {
            userInfoMapper.insert(userInfo);
            playInfoMapper.insert(playInfo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int loginUser(Long userId,String password) {
        try {
            UserInfo info = userInfoMapper.selectByPrimaryKey(userId);
            if (info == null) {
                return -1;
            } else if (!info.getPassword().equals(password)) {
                return 0;
            } else {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -2;
        }
    }
}
