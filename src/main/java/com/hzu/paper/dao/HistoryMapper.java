package com.hzu.paper.dao;

import com.hzu.paper.entity.History;
import com.hzu.paper.entity.HistoryKey;

import java.util.List;

public interface HistoryMapper {
    int deleteByPrimaryKey(HistoryKey key);

    int insert(History record);

    int insertSelective(History record);

    History selectByPrimaryKey(HistoryKey key);

    int updateByPrimaryKeySelective(History record);

    int updateByPrimaryKey(History record);

    List<History> findHistoryByUserId(String userId);
}