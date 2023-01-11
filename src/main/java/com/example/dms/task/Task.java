package com.example.dms.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author zhouy
 * @date 2021/9/22
 * good 09
 */
@Component
public class Task {

    @Scheduled(cron = "${task.schedue.crom}")
    public void taskExcute() {
        System.out.println("task");
    }

    @Scheduled(cron = "${task.schedue.one}")
    public void taskExcuteOne() {
        System.out.println("task-one");
    }
}
