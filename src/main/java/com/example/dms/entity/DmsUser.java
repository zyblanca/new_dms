package com.example.dms.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户信息表(DmsUser)实体类
 *
 * @author makejava
 * @since 2021-09-07 00:43:24
 */

@Data
public class DmsUser implements Serializable {
    private static final long serialVersionUID = 972464391364021868L;
    /**
    * 用户ID（主键、自增）
    */
    private Integer userId;
    /**
    * 用户姓名
    */
    private String userName;
    /**
    * 登录密码
    */
    private String password;
    /**
    * 盐
    */
    private String salt;
    /**
    * 状态（0：禁用；1：锁定；2：启用）
    */
    private String state;
    /**
    * 博客地址
    */
    private String blogUrl;
    /**
    * 博客信息
    */
    private String blogRemark;
}
