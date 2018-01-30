package com.spring.study.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask {

    @Async
    public void executeAsyncTask(Integer i){
        System.out.println("执行异步任务：" + i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("异步执行任务+1：" + i);
    }
}
