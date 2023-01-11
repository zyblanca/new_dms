package com.example.dms.service.impl;

import com.example.dms.entity.DmsRole;
import com.example.dms.mapper.DmsRoleDao;
import com.example.dms.service.DmsRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色信息表(DmsRole)表服务实现类
 *
 * @author makejava
 * @since 2021-09-07 00:43:24
 */
@Service("dmsRoleService")
public class DmsRoleServiceImpl implements DmsRoleService {
    @Resource
    private DmsRoleDao dmsRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    @Override
    public DmsRole queryById(Integer roleId) {
        return this.dmsRoleDao.queryById(roleId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<DmsRole> queryAllByLimit(int offset, int limit) {
        return this.dmsRoleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param dmsRole 实例对象
     * @return 实例对象
     */
    @Override
    public DmsRole insert(DmsRole dmsRole) {
        this.dmsRoleDao.insert(dmsRole);
        return dmsRole;
    }

    /**
     * 修改数据
     *
     * @param dmsRole 实例对象
     * @return 实例对象
     */
    @Override
    public DmsRole update(DmsRole dmsRole) {
        this.dmsRoleDao.update(dmsRole);
        return this.queryById(dmsRole.getRoleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer roleId) {
        return this.dmsRoleDao.deleteById(roleId) > 0;
    }
}
