package com.example.dms.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户与角色映射表(DmsUserRoleMapping)实体类
 *
 * @author makejava
 * @since 2021-09-07 00:43:24
 */
@Data
public class DmsUserRoleMapping implements Serializable {
    private static final long serialVersionUID = -95671953930793312L;
    /**
    * 映射ID（主键、自增）
    */
    private Integer mappingId;
    /**
    * 用户ID
    */
    private Integer userId;
    /**
    * 角色ID
    */
    private Integer roleId;
}
