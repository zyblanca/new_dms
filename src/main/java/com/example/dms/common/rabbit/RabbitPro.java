package com.example.dms.common.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhouy
 * @date 2021/10/10
 * good 10
 */
@Slf4j
@Component
public class RabbitPro {
    /*@Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String mes){

        rabbitTemplate.convertAndSend("directExchange","directRouting",mes);

    }*/
}
