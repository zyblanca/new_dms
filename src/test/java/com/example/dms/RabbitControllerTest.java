package com.example.dms;


import com.alibaba.fastjson.JSON;
import com.example.dms.common.rabbit.RabbitPro;
import com.example.dms.entity.DmsUser;
import com.example.dms.service.DmsUserService;
import org.junit.Test;
import org.junit.runner.RunWith;


import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;


import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhouy
 * @date 2021/10/10
 * good 10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitControllerTest {

    @Autowired
    private RabbitPro rabbitPro;

    @Resource
    private DmsUserService dmsUserService;

    @Autowired

    private RabbitTemplate rabbitTemplate;

    @Test
    public void direct(){
        List<DmsUser> list = dmsUserService.queryAllByLimit(0, 20);
        System.out.println("direct 开始");
        MessagePostProcessor messagePostProcessor = message -> {
            MessageProperties convert = message.getMessageProperties();
            convert.setExpiration("20000");
            
            return message;
        };
        rabbitTemplate.convertAndSend("directExchange","directRouting", JSON.toJSONString(list),messagePostProcessor);
        System.out.println("direct----成功");
    }
}
