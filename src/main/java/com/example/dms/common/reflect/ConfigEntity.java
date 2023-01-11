package com.example.dms.common.reflect;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author zhouy
 * @date 2021/9/27
 * good 09
 */
@Component
@ConfigurationProperties(value = "user")
@PropertySource(value = {"classpath:static/config.properties"},encoding = "UTF-8")
@Data
@ToString
public class ConfigEntity {
    private String communityTitle;
    private String communityFiled;
    private String communityFiledType;

    public static void main(String[] args) {


    }
}
