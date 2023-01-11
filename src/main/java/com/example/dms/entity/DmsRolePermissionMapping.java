package com.example.dms.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色与权限映射表(DmsRolePermissionMapping)实体类
 *
 * @author makejava
 * @since 2021-09-07 00:43:24
 */
@Data
public class DmsRolePermissionMapping implements Serializable {
    private static final long serialVersionUID = -64619126583911100L;
    /**
    * 映射ID（主键、自增）
    */
    private Integer mappingId;
    /**
    * 角色ID
    */
    private Integer roleId;
    /**
    * 权限ID
    */
    private Integer permissionId;
}
