package com.example.async_test.Async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class AsyncCall {

    AsyncTask asyncTask = new AsyncTask();

    // task 를 비동기로 실행
    public void startTask() {
        List<Future> futures = new ArrayList<>();
        log.info("main START");

        for(int k = 1; k <= 30; k *= 4){
            log.info("do Task");
            futures.add(asyncTask.doTask(k));
            log.info("finish Task");
        }

        log.info("round 2");
        for(Future future : futures){
            try {
                future.get();
            } catch (ExecutionException e){
                e.printStackTrace();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        log.info("main END");
    }
}
