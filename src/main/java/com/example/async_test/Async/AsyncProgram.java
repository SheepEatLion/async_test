package com.example.async_test.Async;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Log4j2
public class AsyncProgram {
    private  static final int THREAD_POOL_SIZE = 100;
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100).forEach(n -> {
                    String threadName = Thread.currentThread().getName();
                    //log.info("sync : " + threadName + " : start " + n + " th");
                    executor.submit(() -> asyncTask(n));
                    //executor.execute(AsyncProgram::asyncTask(n));  // 변경점
                    //log.info("sync : " + threadName + " : end " + n + " th");
                }
        );

    }

    private static void asyncTask(int n){
        try{
            String threadName = Thread.currentThread().getName();
            log.info("sync : " + threadName + " : start " + n + " th");
            Thread.sleep(1000);
            log.info("sync : " + threadName + " : end " + n + " th");
        } catch (InterruptedException e){
            log.error(e.getMessage());
        }
    }
}
