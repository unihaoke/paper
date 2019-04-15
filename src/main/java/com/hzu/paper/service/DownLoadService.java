package com.hzu.paper.service;

import com.hzu.paper.common.Result;
import com.hzu.paper.entity.DownLoad;
import com.hzu.paper.entity.DownLoadKey;

public interface DownLoadService {
    Result addDownLoad(DownLoad downLoad);

    Result findDownLoadByUserId(String userId);

    Result delHistory(DownLoadKey downLoadKey);
}
