package com.cqut.flychessgame.service;

import com.cqut.flychessgame.domain.database.*;
import com.cqut.flychessgame.domain.gameEntity.Checker;
import com.cqut.flychessgame.mapper.CombatMapper;
import com.cqut.flychessgame.mapper.MatchInfoMapper;
import com.cqut.flychessgame.mapper.PlayInfoMapper;
import com.cqut.flychessgame.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Create with IntelliJ IDEA.
 *
 * @author hj
 */
@Service
public class PlayInfoServiceImpl implements PlayInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    PlayInfoMapper playInfoMapper;

    @Autowired
    MatchInfoMapper matchInfoMapper;

    @Autowired
    CombatMapper combatMapper;


    @Override
    public int changeUserInfo(UserInfo userInfo, String nPassword) {
        Long userId = userInfo.getUserid();
        UserInfo uUserInfo = userInfoMapper.selectByPrimaryKey(userId);
        if (!uUserInfo.getPassword().equals(userInfo.getPassword())) {
            //修改密码失败
            return -1;
        }
        if (nPassword != null && !nPassword.equals("")) {
            uUserInfo.setPassword(nPassword);
        } else {
            //维持原密码
            uUserInfo.setPassword(userInfo.getPassword());
        }
        userInfo.setCreatedate(uUserInfo.getCreatedate());
        userInfoMapper.updateByPrimaryKey(userInfo);
        return 0;
    }

    @Override
    public UserInfo getUserInfo(Long userId) {
        return userInfoMapper.selectByPrimaryKey(userId);
    }

    @Override
    public PlayInfo getPlayInfo(Long userId) {
        return playInfoMapper.selectByPrimaryKey(userId);
    }

    @Override
    public void setPlayInfo(Long userId,int sign, boolean isWin) {
        PlayInfo playInfo = playInfoMapper.selectByPrimaryKey(userId);
        PlayInfoExample example = new PlayInfoExample();
        example.or().andUseridEqualTo(userId);
        if(playInfo != null){
            PlayInfo pInfo = new PlayInfo();
            pInfo.setPlaycount(playInfo.getPlaycount() + 1);
            if(isWin){
                pInfo.setWincount(playInfo.getWincount() + 1);
            }
            if(sign == 0){
                pInfo.setPlaytor(playInfo.getPlaytor() + 1);
            }
            playInfoMapper.updateByExampleSelective(pInfo,example);
        }
    }

    @Override
    public void saveCombat(Long spoId, Long accId, Long winId) {
        Combat combat = new Combat();
        combat.setSponsorid(spoId);
        combat.setAcceptid(accId);
        combat.setWinid(winId);
        combatMapper.insert(combat);
    }

    @Override
    public MatchInfo getMatchInfo(Long userId) {
        MatchInfo matchInfo = null;
        //查找待匹配的用户
        MatchInfoExample example = new MatchInfoExample();
        MatchInfoExample.Criteria criteria = example.createCriteria();
        criteria.andSponsoridEqualTo(userId);
        MatchInfoExample.Criteria criteria3 = example.createCriteria();
        criteria3.andAcceptidEqualTo(userId);
        example.or(criteria3);
        List<MatchInfo> matchInfor = matchInfoMapper.selectByExample(example);
        if(matchInfor == null || matchInfor.size()== 0 ){ //表中还不存在该玩家已匹配信息
            MatchInfoExample example2 = new MatchInfoExample();
            MatchInfoExample.Criteria criteria2 = example2.createCriteria();
            criteria2.andSignEqualTo(-1);
            List<MatchInfo> matchInfos = matchInfoMapper.selectByExample(example2);
            if (matchInfos == null || matchInfos.size() == 0) {
                //当前没有待匹配用户，创建一个等待匹配
                matchInfo = new MatchInfo();
                matchInfo.setSponsorid(userId);
                matchInfo.setSign(-1);
                matchInfoMapper.insert(matchInfo);
                return null;
            } else {
                MatchInfo match = matchInfos.get(0);
                //有且已经创建等待，直接返回
                if (userId.longValue() == match.getSponsorid().longValue()) {
                    return null;
                } else if (match.getAcceptid() == null) {
                    //作为接受者匹配成功
                    criteria.andSponsoridEqualTo(userId);
                    match.setAcceptid(userId);
                    match.setSign(0); //匹配成功
                    matchInfoMapper.updateByExampleSelective(match, example2);
                    return match;
                } else {
                    return match;
                }
            }
        } else {
            return matchInfor.get(0);
        }
    }

    @Override
    public void saveMoveInfo(Long spoId, Long accId, int sign, Object o) {
        List<Object> list = (List<Object>) o;
        for (Object ob : list) {
            MatchInfo matchInfo = new MatchInfo();
            matchInfo.setSponsorid(spoId);
            matchInfo.setAcceptid(accId);
            matchInfo.setSign(sign);
            if (ob instanceof Integer) {
                //存入色子点数
                matchInfo.setDicenum((Integer) ob);
            } else {
                Checker checker = (Checker) ob;
                matchInfo.setLocx(checker.getLocation().getX());
                matchInfo.setLocy(checker.getLocation().getY());
                matchInfo.setCellcolor(checker.getCellColor());
                matchInfo.setDirection(checker.getDirection());
                matchInfo.setPlanenum(checker.getPlaneNum());
            }
            matchInfoMapper.insert(matchInfo); //插入该条数据
        }
    }

    @Override
    public void deleteGameData(int sign) {
        MatchInfoExample example = new MatchInfoExample();
        MatchInfoExample.Criteria criteria = example.createCriteria();
        criteria.andSignNotEqualTo(sign);
        matchInfoMapper.deleteByExample(example);
    }

    @Override
    public ArrayList<Object> searchCheckers(Long spoId, Long accId, int sign) {
        ArrayList<Object> objects = new ArrayList<>();
        MatchInfoExample example = new MatchInfoExample();
        MatchInfoExample.Criteria criteria = example.createCriteria();
        criteria.andSponsoridEqualTo(spoId).andAcceptidEqualTo(accId).andSignNotEqualTo(sign);
        //找到对应数据
        List<MatchInfo> list = matchInfoMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            return null;
        } else {
            objects.add(list.get(0).getSign());
            for (MatchInfo matchInfo : list) {
                if (matchInfo.getDicenum() != null) {
                    objects.add(matchInfo.getDicenum());//取出色子点数
                } else {
                    Checker checker = new Checker();
                    checker.setCellColor(matchInfo.getCellcolor());
                    checker.setPlaneNum(matchInfo.getPlanenum());
                    checker.setDirection(matchInfo.getDirection());
                    checker.setLocation(new Point(matchInfo.getLocx().intValue(), matchInfo.getLocy().intValue()));
                    objects.add(checker);
                }
            }
            return objects;
        }
    }

}
