package com.hzu.paper.service;

import com.hzu.paper.common.Result;

public interface PaperService {
    public Result findPaper(String userId,String keyWord);
}
