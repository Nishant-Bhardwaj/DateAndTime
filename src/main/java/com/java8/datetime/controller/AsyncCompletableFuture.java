package com.java8.datetime.controller;

import com.java8.datetime.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class AsyncCompletableFuture {

    @Autowired
    MessageService messageService;

    @RequestMapping("/reactive")
    public String helloWorld(){

        var startTime = System.currentTimeMillis();

        var helloResult = CompletableFuture
                .supplyAsync(messageService::hello)
                .handle((res, e)->{
                    if(null != e)
                        return "HELLO EX";
                    return res;
                })
                .thenApply(String::toLowerCase);

        var worldResult= CompletableFuture
                .supplyAsync(messageService::world)
                .exceptionally(Throwable::getMessage);

        var result= helloResult
                .thenCombine(worldResult , (h,w)-> h + w)
                .join();

        var stopTime = System.currentTimeMillis();

        System.out.println("Total Time: " + (stopTime -startTime));

        return result;
    }

    @RequestMapping("/normal")
    public String helloWorldOld(){

        var startTime = System.currentTimeMillis();

        var helloResult = messageService.hello();
        var worldResult= messageService.world();
        var result= helloResult + worldResult;

        var stopTime = System.currentTimeMillis();

        System.out.println("Total Time: " + (stopTime -startTime));

        return result;
    }
}
