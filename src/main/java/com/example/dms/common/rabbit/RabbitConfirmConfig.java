package com.example.dms.common.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author zhouy
 * @date 2021/10/12
 * good 10
 */
@Slf4j
@Component
public class RabbitConfirmConfig implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnsCallback{
    /*@Autowired
    private RabbitTemplate rabbitTemplate;*/
    @PostConstruct
    public void init(){
       /* rabbitTemplate.setReturnsCallback(this);
        rabbitTemplate.setConfirmCallback(this);*/
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack){
            log.info("消息推送成功ack:{}-原因{}",ack,cause);
        }else {
            log.info("消息推送失败:{}",correlationData.toString());
        }
    }


    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("消息主体: " + SerializationUtils.deserialize(message.getBody()));
        System.out.println("应答码: " + replyCode);
        System.out.println("描述：" + replyText);
        System.out.println("消息使用的交换器 exchange : " + exchange);
        System.out.println("消息使用的路由键 routing : " + routingKey);
    }

    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {

    }
}
