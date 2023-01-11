package com.example.dms.common.rabbit;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.io.IOException;

import java.util.Map;

/**
 * @author zhouy
 * @date 2021/10/10
 * good 10
 */
@Slf4j
@Component
public class RabbitReceive {
    /*@RabbitListener(queues = "directType")
    @RabbitHandler
    public void directReceive(Channel channel, String json, Message message){

            try {
                log.info("json：{}",json);
                //否认消息,拒接该消息重回队列
                channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);


                return;
            } catch (IOException e) {
                e.printStackTrace();
            }


    }

    @RabbitListener(queues = "dll.direct.Type")
    @RabbitHandler
    public void directdlReceive(String message){
        System.out.println("死信队列接受消息1"+ message);
        System.out.println(message);
    }


    @RabbitListener(queues = "dll.direct.Type")
    @RabbitHandler
    public void directdlReceive(String data, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag,Message mesage,Channel channel ){
        mesage.getBody();
    }*/
}
