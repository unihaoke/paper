package com.hzu.paper.service;

import com.hzu.paper.common.Result;
import com.hzu.paper.entity.History;
import com.hzu.paper.entity.HistoryKey;

public interface HistoryService {
    Result addHistory(History history);

    Result findHistoryByUserId(String userId);

    Result delHistory(HistoryKey historyKey);
}
