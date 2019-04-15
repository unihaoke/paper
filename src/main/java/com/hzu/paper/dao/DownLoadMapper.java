package com.hzu.paper.dao;

import com.hzu.paper.entity.DownLoad;
import com.hzu.paper.entity.DownLoadKey;

import java.util.List;

public interface DownLoadMapper {
    int deleteByPrimaryKey(DownLoadKey key);

    int insert(DownLoad record);

    int insertSelective(DownLoad record);

    DownLoad selectByPrimaryKey(DownLoadKey key);

    int updateByPrimaryKeySelective(DownLoad record);

    int updateByPrimaryKey(DownLoad record);

    List<DownLoad> findDownLoadByUserId(String userId);
}