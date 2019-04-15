package com.hzu.paper.dao;

import com.hzu.paper.entity.Recode;

public interface RecodeMapper {
    int deleteByPrimaryKey(String yhid);

    int insert(Recode record);

    int insertSelective(Recode record);

    Recode selectByPrimaryKey(String yhid);

    int updateByPrimaryKeySelective(Recode record);

    int updateByPrimaryKey(Recode record);
}