package com.example.dms.common.listener;

import com.alibaba.fastjson.JSON;
import com.example.dms.entity.DmsUser;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author zhouy
 * @date 2021/10/2
 * good 10
 */
@Component
public class MyListener implements ApplicationListener<UserEven> {
    @Override
    public void onApplicationEvent(UserEven userEven) {
        DmsUser dmsUser = userEven.dmsUser();
        System.out.println(JSON.toJSONString(dmsUser));
    }

}

