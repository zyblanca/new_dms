package com.example.dms.common.listener;

import com.example.dms.entity.DmsUser;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * @author zhouy
 * @date 2021/10/2
 * good 10
 */
public class UserEven extends ApplicationEvent {
    private DmsUser dmsUser;

    public UserEven(Object source) {
        super(source);
    }

    public UserEven(Object source, DmsUser dmsUser) {
        super(source);
        this.dmsUser = dmsUser;
    }
    public DmsUser dmsUser(){
        return dmsUser;
    }
    public UserEven() {
        super(null);
        this.dmsUser = dmsUser;
    }
}
