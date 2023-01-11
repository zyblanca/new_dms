package com.example.dms.service;

import com.example.dms.entity.DmsRolePermissionMapping;
import java.util.List;

/**
 * 角色与权限映射表(DmsRolePermissionMapping)表服务接口
 *
 * @author makejava
 * @since 2021-09-07 00:43:24
 */
public interface DmsRolePermissionMappingService {

    /**
     * 通过ID查询单条数据
     *
     * @param mappingId 主键
     * @return 实例对象
     */
    DmsRolePermissionMapping queryById(Integer mappingId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DmsRolePermissionMapping> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param dmsRolePermissionMapping 实例对象
     * @return 实例对象
     */
    DmsRolePermissionMapping insert(DmsRolePermissionMapping dmsRolePermissionMapping);

    /**
     * 修改数据
     *
     * @param dmsRolePermissionMapping 实例对象
     * @return 实例对象
     */
    DmsRolePermissionMapping update(DmsRolePermissionMapping dmsRolePermissionMapping);

    /**
     * 通过主键删除数据
     *
     * @param mappingId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer mappingId);

}