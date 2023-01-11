package com.example.dms.service.impl;

import com.example.dms.entity.DmsPermission;
import com.example.dms.mapper.DmsPermissionDao;
import com.example.dms.service.DmsPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限信息表(DmsPermission)表服务实现类
 *
 * @author makejava
 * @since 2021-09-07 00:43:24
 */
@Service
public class DmsPermissionServiceImpl implements DmsPermissionService {
    @Resource
    private DmsPermissionDao dmsPermissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param permissionId 主键
     * @return 实例对象
     */
    @Override
    public DmsPermission queryById(Integer permissionId) {
        return dmsPermissionDao.queryById(permissionId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<DmsPermission> queryAllByLimit(int offset, int limit) {
        return this.dmsPermissionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param dmsPermission 实例对象
     * @return 实例对象
     */
    @Override
    public DmsPermission insert(DmsPermission dmsPermission) {
        this.dmsPermissionDao.insert(dmsPermission);
        return dmsPermission;
    }

    /**
     * 修改数据
     *
     * @param dmsPermission 实例对象
     * @return 实例对象
     */
    @Override
    public DmsPermission update(DmsPermission dmsPermission) {
        this.dmsPermissionDao.update(dmsPermission);
        return this.queryById(dmsPermission.getPermissionId());
    }

    /**
     * 通过主键删除数据
     *
     * @param permissionId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer permissionId) {
        return this.dmsPermissionDao.deleteById(permissionId) > 0;
    }
}
