package com.hzu.paper.service.Impl;

import com.hzu.paper.common.Result;
import com.hzu.paper.common.StatusCode;
import com.hzu.paper.dao.DownLoadMapper;
import com.hzu.paper.entity.DownLoad;
import com.hzu.paper.entity.DownLoadKey;
import com.hzu.paper.service.DownLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DownLoadServiceImpl implements DownLoadService {

    @Autowired
    private DownLoadMapper downLoadMapper;


    @Override
    public Result addDownLoad(DownLoad downLoad) {
        if(downLoad == null){
            return new Result(false,StatusCode.ERROR,"添加失败");
        }
        int count = downLoadMapper.insert(downLoad);
        if (count < 0){
            return new Result(false,StatusCode.ERROR,"添加失败");
        }
        return new Result(true,StatusCode.OK,"添加成功");
    }

    @Override
    public Result findDownLoadByUserId(String userId) {
        if(userId == null){
            return new Result(false,StatusCode.ERROR,"查询失败");
        }
        return new Result(true,StatusCode.OK,"查询成功",downLoadMapper.findDownLoadByUserId(userId));
    }

    @Override
    public Result delHistory(DownLoadKey downLoadKey) {
        if(downLoadKey == null){
            return new Result(false,StatusCode.ERROR,"删除失败");
        }
        int count = downLoadMapper.deleteByPrimaryKey(downLoadKey);
        if (count < 0){
            return new Result(false,StatusCode.ERROR,"删除失败");
        }
        return new Result(true,StatusCode.OK,"删除成功");
    }
}
