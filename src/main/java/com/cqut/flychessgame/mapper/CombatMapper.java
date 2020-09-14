package com.cqut.flychessgame.mapper;

import com.cqut.flychessgame.domain.database.Combat;
import com.cqut.flychessgame.domain.database.CombatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CombatMapper {
    int deleteByExample(CombatExample example);

    int insert(Combat record);

    int insertSelective(Combat record);

    List<Combat> selectByExample(CombatExample example);

    int updateByExampleSelective(@Param("record") Combat record, @Param("example") CombatExample example);

    int updateByExample(@Param("record") Combat record, @Param("example") CombatExample example);
}