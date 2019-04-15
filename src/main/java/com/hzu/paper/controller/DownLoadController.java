package com.hzu.paper.controller;

import com.hzu.paper.common.Result;
import com.hzu.paper.entity.DownLoad;
import com.hzu.paper.entity.DownLoadKey;
import com.hzu.paper.service.DownLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/downLoad")
public class DownLoadController {

    @Autowired
    private DownLoadService downLoadService;

    @PostMapping
    public Result addHistory(@RequestBody DownLoad downLoad){
        return downLoadService.addDownLoad(downLoad);
    }

    @GetMapping(value = "/{userId}")
    public Result findHistory(@PathVariable String userId){
        return downLoadService.findDownLoadByUserId(userId);
    }

    @PostMapping(value = "/del")
    public Result delHistory(@RequestBody DownLoadKey downLoadKey){
        return downLoadService.delHistory(downLoadKey);
    }
}
