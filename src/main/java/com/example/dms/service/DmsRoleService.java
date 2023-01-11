package com.example.dms.service;

import com.example.dms.entity.DmsRole;
import java.util.List;

/**
 * 角色信息表(DmsRole)表服务接口
 *
 * @author makejava
 * @since 2021-09-07 00:43:24
 */
public interface DmsRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    DmsRole queryById(Integer roleId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DmsRole> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param dmsRole 实例对象
     * @return 实例对象
     */
    DmsRole insert(DmsRole dmsRole);

    /**
     * 修改数据
     *
     * @param dmsRole 实例对象
     * @return 实例对象
     */
    DmsRole update(DmsRole dmsRole);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer roleId);

}