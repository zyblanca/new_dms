package com.example.dms;

import com.example.dms.common.reflect.Order;
import org.apache.poi.ss.formula.functions.T;

/**
 * @author zhouy
 * @date 2022/7/31
 * good 07
 */
public class UserLoginUtil {
    private static final ThreadLocal THREAD_LOCAL = new ThreadLocal();

    public static void setObject(Order good) {
        THREAD_LOCAL.set(good);
    }

    public static Order get (){
        Order order = (Order) THREAD_LOCAL.get();
        return order;
    }

    public static void  remove (){
        THREAD_LOCAL.remove();
    }

}
