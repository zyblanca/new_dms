package com.example.dms.common.aspect;

import com.example.dms.Intercerptor.RoleData;
import com.example.dms.UserLoginUtil;
import com.example.dms.common.reflect.Order;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

/**
 * @author zhouy
 * @date 2022/7/31
 * good 07
 */
@Aspect
@EnableAspectJAutoProxy
@Component
public class AuthPermissionAspect {
    private static final ThreadLocal LOCAL = new ThreadLocal();
    @Pointcut("@annotation(com.example.dms.Intercerptor.RoleData)")
    public void authPermission(){

    }
    @Before("authPermission()")
    public void doBefore(JoinPoint joinPoint){
        Object[] good = joinPoint.getArgs();
        for (Object o : good) {
            System.out.println(o);
        }
        Signature signature = joinPoint.getSignature();
        MethodSignature mehtodSignature = (MethodSignature) signature;
        Method method = mehtodSignature.getMethod();
        RoleData roleData = method.getAnnotation(RoleData.class);
        if (Objects.nonNull(roleData)){
            String str=roleData.good();
            System.out.println(str);
            UserLoginUtil.remove();
            Order order = new Order();
            order.setOrderNum(1);
            order.setOrderName("sld");
            Map<String, String> good1 = new HashMap<>();
            good1.put("name", "用户");
            good1.put("name", "用户");
            order.setGood(good1);
            System.out.println("进入拦截器");
            UserLoginUtil.setObject(order);
        }
    }

    @After("authPermission()")
    public void clearPermissons(){
        UserLoginUtil.remove();
    }
    // @Around("authPermission()&& @annotation(roleData)")
    public void around(ProceedingJoinPoint joinPoint,RoleData roleData){
        HashMap<String, String> map = new HashMap<>();




    }

}
