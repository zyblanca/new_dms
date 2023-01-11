package com.example.dms.common.rabbit;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouy
 * @date 2021/10/10
 * good 10
 */
@Slf4j
@Configuration
public class RabbitDirectConfig {

    @Bean
    public Queue createDirectQueue(){
        Map<String,Object> map = new HashMap<>();
        map.put("x-dead-letter-exchange", "dl.direct.eExchange");
        map.put("x-dead-letter-routing-key", "dl.direct.Routing");
        return  new Queue("directType", false, false, false, map);
    }
    @Bean
    public Queue createDlDirectQueue(){
        return new Queue("dll.direct.Type");
    }

    @Bean
    public DirectExchange createDirectExchange(){
        return new DirectExchange("directExchange");
    }

    @Bean
    public DirectExchange createdlDirectExchange(){
        return new DirectExchange("dl.direct.eExchange");
    }

    @Bean
    public Binding createDirectBinding(Queue createDirectQueue,DirectExchange createDirectExchange){
        return BindingBuilder.bind(createDirectQueue).to(createDirectExchange).with("directRouting");
    }
    @Bean
    public Binding createdlDirectBinding(Queue createDlDirectQueue,DirectExchange createdlDirectExchange){
        return BindingBuilder.bind(createDlDirectQueue).to(createdlDirectExchange).with("dl.direct.Routing");
    }



}
