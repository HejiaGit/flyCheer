package com.cqut.flychessgame.mapper;

import com.cqut.flychessgame.domain.database.MatchInfo;
import com.cqut.flychessgame.domain.database.MatchInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MatchInfoMapper {
    int deleteByExample(MatchInfoExample example);

    int insert(MatchInfo record);

    int insertSelective(MatchInfo record);

    List<MatchInfo> selectByExample(MatchInfoExample example);

    int updateByExampleSelective(@Param("record") MatchInfo record, @Param("example") MatchInfoExample example);

    int updateByExample(@Param("record") MatchInfo record, @Param("example") MatchInfoExample example);
}