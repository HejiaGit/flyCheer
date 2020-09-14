package com.cqut.flychessgame.mapper;

import com.cqut.flychessgame.domain.database.PlayInfo;
import com.cqut.flychessgame.domain.database.PlayInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlayInfoMapper {
    int deleteByExample(PlayInfoExample example);

    int deleteByPrimaryKey(Long userid);

    int insert(PlayInfo record);

    int insertSelective(PlayInfo record);

    List<PlayInfo> selectByExample(PlayInfoExample example);

    PlayInfo selectByPrimaryKey(Long userid);

    int updateByExampleSelective(@Param("record") PlayInfo record, @Param("example") PlayInfoExample example);

    int updateByExample(@Param("record") PlayInfo record, @Param("example") PlayInfoExample example);

    int updateByPrimaryKeySelective(PlayInfo record);

    int updateByPrimaryKey(PlayInfo record);
}