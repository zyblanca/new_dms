package com.example.dms.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author zhouy
 * @date 2021/9/22
 * good 09
 */
@Slf4j
@Component
public class AutoSchedule  implements SchedulingConfigurer {

    public static  String DEFAULT_CORN="0/3 * * * * *";
    //##动态传参要给默认值。
    public static String corn=DEFAULT_CORN;

    // TODO: 2021/9/22 可以通过数据库配置是否启用定时任务 
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        taskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                System.out.println("动态定时任务");
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                //任务触发，可修改任务的执行周期
                CronTrigger cronTrigger = new CronTrigger(corn);

                Date date = cronTrigger.nextExecutionTime(triggerContext);
                return date;
            }
        });
    }

}
