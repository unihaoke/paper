package com.hzu.paper.controller;


import com.hzu.paper.common.Result;
import com.hzu.paper.entity.CollectionHistory;
import com.hzu.paper.entity.CollectionKey;
import com.hzu.paper.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @PostMapping
    public Result addCollection(@RequestBody CollectionHistory collectionHistory){
        return collectionService.addCollection(collectionHistory);

    }

    @PostMapping(value = "/del")
    public Result delCollection(@RequestBody CollectionKey collectionKey){
        return collectionService.delCollection(collectionKey);
    }

    @GetMapping(value = "/{userId}")
    public Result findCollection(@PathVariable String userId ){
        return collectionService.findCollection(userId);
    }

}
