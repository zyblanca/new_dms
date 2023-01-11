package com.example.dms.common.listener;

import com.alibaba.fastjson.JSON;
import com.example.dms.entity.DmsUser;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author zhouy
 * @date 2021/10/2
 * good 10
 */
@Component
public class ListenerTest {
    @EventListener
    public DmsUser excute(UserEven userEven){
        System.out.println(JSON.toJSONString(userEven.dmsUser()));
        return userEven.dmsUser();
    }

}
