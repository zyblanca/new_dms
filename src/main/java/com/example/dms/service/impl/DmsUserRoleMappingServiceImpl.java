package com.example.dms.service.impl;

import com.example.dms.entity.DmsUserRoleMapping;
import com.example.dms.mapper.DmsUserRoleMappingDao;
import com.example.dms.service.DmsUserRoleMappingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户与角色映射表(DmsUserRoleMapping)表服务实现类
 *
 * @author makejava
 * @since 2021-09-07 00:43:24
 */
@Service("dmsUserRoleMappingService")
public class DmsUserRoleMappingServiceImpl implements DmsUserRoleMappingService {
    @Resource
    private DmsUserRoleMappingDao dmsUserRoleMappingDao;

    /**
     * 通过ID查询单条数据
     *
     * @param mappingId 主键
     * @return 实例对象
     */
    @Override
    public DmsUserRoleMapping queryById(Integer mappingId) {
        return this.dmsUserRoleMappingDao.queryById(mappingId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<DmsUserRoleMapping> queryAllByLimit(int offset, int limit) {
        return this.dmsUserRoleMappingDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param dmsUserRoleMapping 实例对象
     * @return 实例对象
     */
    @Override
    public DmsUserRoleMapping insert(DmsUserRoleMapping dmsUserRoleMapping) {
        this.dmsUserRoleMappingDao.insert(dmsUserRoleMapping);
        return dmsUserRoleMapping;
    }

    /**
     * 修改数据
     *
     * @param dmsUserRoleMapping 实例对象
     * @return 实例对象
     */
    @Override
    public DmsUserRoleMapping update(DmsUserRoleMapping dmsUserRoleMapping) {
        this.dmsUserRoleMappingDao.update(dmsUserRoleMapping);
        return this.queryById(dmsUserRoleMapping.getMappingId());
    }

    /**
     * 通过主键删除数据
     *
     * @param mappingId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer mappingId) {
        return this.dmsUserRoleMappingDao.deleteById(mappingId) > 0;
    }
}
