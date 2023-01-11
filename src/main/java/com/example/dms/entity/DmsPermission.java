package com.example.dms.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 权限信息表(DmsPermission)实体类
 *
 * @author makejava
 * @since 2021-09-07 00:43:24
 */
@Data
public class DmsPermission implements Serializable {
    private static final long serialVersionUID = -79264800355079936L;
    /**
    * 权限ID（主键、自增）
    */
    private Integer permissionId;
    /**
    * 权限编号
    */
    private String permissionCode;
    /**
    * 权限名称
    */
    private String permissionName;

}
