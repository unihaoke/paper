package com.hzu.paper.service.Impl;

import com.hzu.paper.common.Result;
import com.hzu.paper.common.StatusCode;
import com.hzu.paper.dao.PaperMapper;
import com.hzu.paper.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaperServiceImpl implements PaperService {

    @Autowired
    private PaperMapper paperMapper;

    @Override
    public Result findPaper(String userId,String keyWord) {
        if(userId == null || keyWord == null){
            return new Result(false,StatusCode.ERROR,"查找失败");
        }
        return new Result(false,StatusCode.ERROR,"查找成功",paperMapper.findPaper(keyWord));
    }
}
