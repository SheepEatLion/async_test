package com.example.async_test.Async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.Future;
import java.util.stream.IntStream;

/**
 * 비동기로 실행해야 하는 임의 테스크
 */
@Slf4j
public class AsyncTask {

    // 파라미터로 넘겨받은 시간(초) 만큼 소요되는 task 메서드
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    @Async
    public Future<Void> doTask(int num){
        log.info("task START : " + num);
        IntStream.range(0, num).forEach(n -> {
            try {
                Thread.sleep(1000 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        log.info("task END : " + num);
        return new AsyncResult<>(null);
    }
}
