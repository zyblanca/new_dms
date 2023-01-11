package com.example.dms.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author zhouy
 * @date 2021/12/21
 * good 12
 */
@Service
@Slf4j
public class AsyncService {
    @Async("taskExecutor")
    public void getInfo(String string) {
        log.info("日志记录{}",string);
    }
}
