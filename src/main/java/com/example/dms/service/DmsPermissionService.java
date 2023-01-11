package com.example.dms.service;

import com.example.dms.entity.DmsPermission;
import java.util.List;

/**
 * 权限信息表(DmsPermission)表服务接口
 *
 * @author makejava
 * @since 2021-09-07 00:43:24
 */
public interface DmsPermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param permissionId 主键
     * @return 实例对象
     */
    DmsPermission queryById(Integer permissionId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DmsPermission> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param dmsPermission 实例对象
     * @return 实例对象
     */
    DmsPermission insert(DmsPermission dmsPermission);

    /**
     * 修改数据
     *
     * @param dmsPermission 实例对象
     * @return 实例对象
     */
    DmsPermission update(DmsPermission dmsPermission);

    /**
     * 通过主键删除数据
     *
     * @param permissionId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer permissionId);

}