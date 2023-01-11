package com.example.dms;


import com.example.dms.entity.DmsUser;
import com.example.dms.service.DmsUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author zhouy
 * @date 2021/10/11
 * good 10
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitTTl {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Resource
    private DmsUserService dmsUserService;

    @Test
    public void testTTl() throws UnsupportedEncodingException {
        List<DmsUser> list = dmsUserService.queryAllByLimit(0, 20);
        MessagePostProcessor messagePostProcessor = message -> {
            MessageProperties messageProperties = message.getMessageProperties();
//            设置编码
            messageProperties.setContentEncoding("utf-8");
//            设置过期时间10*1000毫秒(最终过期时间取x-message-ttl和messageProperties.setExpiration的最小值
            messageProperties.setExpiration("10000");
            return message;
        };
        amqpTemplate.convertAndSend("DL_EXCHANGE", "DL_KEY", "123456", messagePostProcessor);
    }

}
