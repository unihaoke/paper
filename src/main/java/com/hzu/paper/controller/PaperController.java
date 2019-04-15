package com.hzu.paper.controller;

import com.hzu.paper.common.Result;
import com.hzu.paper.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    private PaperService paperService;

    @GetMapping(value = "/{userId}/{keyWord}")
    public Result searchPaper(@PathVariable String userId,@PathVariable String keyWord){
        return paperService.findPaper(userId,keyWord);
    }
}
