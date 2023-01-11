package com.example.dms.common.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @author zhouy
 * @date 2021/9/23
 * good 09
 */
@Configuration
public class ConfigFilters  {
    @Autowired
    private Configfilter configfilter;
    @Bean
    public FilterRegistrationBean registerAuthFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(configfilter);
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setName("configfilter");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}
