package com.example.dms.thread;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouy
 * @date 2021/12/21
 * good 12
 */
@RestController
@RequestMapping("/testthread")
public class ThreadTest {
    private AsyncService asyncService;
    @PostMapping("getinfo")
    public String getInfo(){
        asyncService.getInfo("test");
        return null;
    }
}
