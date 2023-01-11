package com.example.dms.Intercerptor;

import com.example.dms.UserLoginUtil;
import com.example.dms.common.reflect.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author zhouy
 * @date 2021/9/23
 * good 09
 */
@Component
public class MyIntercerptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        RoleData roleData = handlerMethod.getMethodAnnotation(RoleData.class);
        RoleData roleData1 = handlerMethod.getBeanType().getAnnotation(RoleData.class);
        if (Objects.nonNull(roleData)){
            UserLoginUtil.remove();
            String url = request.getRequestURI();
            Order order = new Order();
            order.setOrderNum(1);
            order.setOrderName("sld");
            Map<String, String> good = new HashMap<>();
            good.put("name", "用户");
            good.put("name", "用户");
            order.setGood(good);
            System.out.println("进入拦截器");
            UserLoginUtil.setObject(order);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Order order = UserLoginUtil.get();
        System.out.println(order);

    }
}
