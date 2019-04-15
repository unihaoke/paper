package com.hzu.paper.controller;

import com.hzu.paper.common.Result;
import com.hzu.paper.entity.History;
import com.hzu.paper.entity.HistoryKey;
import com.hzu.paper.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @PostMapping
    public Result addHistory(@RequestBody History history){
        return historyService.addHistory(history);
    }

    @GetMapping(value = "/{userId}")
    public Result findHistory(@PathVariable String userId){
        return historyService.findHistoryByUserId(userId);
    }

    @PostMapping(value = "/del")
    public Result delHistory(@RequestBody HistoryKey historyKey){
        return historyService.delHistory(historyKey);
    }

}
