package com.example.dms.service.impl;

import com.example.dms.entity.DmsRolePermissionMapping;
import com.example.dms.mapper.DmsRolePermissionMappingDao;
import com.example.dms.service.DmsRolePermissionMappingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色与权限映射表(DmsRolePermissionMapping)表服务实现类
 *
 * @author makejava
 * @since 2021-09-07 00:43:24
 */
@Service("dmsRolePermissionMappingService")
public class DmsRolePermissionMappingServiceImpl implements DmsRolePermissionMappingService {
    @Resource
    private DmsRolePermissionMappingDao dmsRolePermissionMappingDao;

    /**
     * 通过ID查询单条数据
     *
     * @param mappingId 主键
     * @return 实例对象
     */
    @Override
    public DmsRolePermissionMapping queryById(Integer mappingId) {
        return this.dmsRolePermissionMappingDao.queryById(mappingId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<DmsRolePermissionMapping> queryAllByLimit(int offset, int limit) {
        return this.dmsRolePermissionMappingDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param dmsRolePermissionMapping 实例对象
     * @return 实例对象
     */
    @Override
    public DmsRolePermissionMapping insert(DmsRolePermissionMapping dmsRolePermissionMapping) {
        this.dmsRolePermissionMappingDao.insert(dmsRolePermissionMapping);
        return dmsRolePermissionMapping;
    }

    /**
     * 修改数据
     *
     * @param dmsRolePermissionMapping 实例对象
     * @return 实例对象
     */
    @Override
    public DmsRolePermissionMapping update(DmsRolePermissionMapping dmsRolePermissionMapping) {
        this.dmsRolePermissionMappingDao.update(dmsRolePermissionMapping);
        return this.queryById(dmsRolePermissionMapping.getMappingId());
    }

    /**
     * 通过主键删除数据
     *
     * @param mappingId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer mappingId) {
        return this.dmsRolePermissionMappingDao.deleteById(mappingId) > 0;
    }
}
