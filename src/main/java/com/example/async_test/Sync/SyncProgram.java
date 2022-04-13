package com.example.async_test.Sync;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

import java.util.stream.IntStream;

/**
 * @author junyeong
 * 동기(sync) 예제
 */
@Log4j2
public class SyncProgram {

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100).forEach(n -> {
            String threadName = Thread.currentThread().getName();
            log.info("sync : " + threadName + " : start " + n + " th");
            syncTask();
            log.info("sync : " + threadName + " : end " + n + " th");
        });
    }

    private static void syncTask() {
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            log.error(e.getMessage());
        }
    }
}
