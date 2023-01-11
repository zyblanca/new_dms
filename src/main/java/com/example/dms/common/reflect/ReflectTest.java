package com.example.dms.common.reflect;

import com.example.dms.controller.DmsUserController;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Method;

/**
 * @author zhouy
 * @date 2021/9/26
 * good 09
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        ConfigEntity configEntity = new ConfigEntity();
        System.out.println(configEntity.getCommunityFiled());
        Class classType = DmsUserController.class;
        Method method = classType.getDeclaredMethod("selectOne", Integer.class);
        if (method.isAnnotationPresent(GetMapping.class)){
            GetMapping getMapping = method.getAnnotation(GetMapping.class);
            String[] str = getMapping.value();
            System.out.println(str[0]);
        }


    }

}
