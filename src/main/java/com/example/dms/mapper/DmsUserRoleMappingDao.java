package com.example.dms.mapper;

import com.example.dms.entity.DmsUserRoleMapping;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户与角色映射表(DmsUserRoleMapping)表数据库访问层
 *
 * @author makejava
 * @since 2021-09-07 00:43:24
 */
@Repository
public interface DmsUserRoleMappingDao {

    /**
     * 通过ID查询单条数据
     *
     * @param mappingId 主键
     * @return 实例对象
     */
    DmsUserRoleMapping queryById(Integer mappingId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DmsUserRoleMapping> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dmsUserRoleMapping 实例对象
     * @return 对象列表
     */
    List<DmsUserRoleMapping> queryAll(DmsUserRoleMapping dmsUserRoleMapping);

    /**
     * 新增数据
     *
     * @param dmsUserRoleMapping 实例对象
     * @return 影响行数
     */
    int insert(DmsUserRoleMapping dmsUserRoleMapping);

    /**
     * 修改数据
     *
     * @param dmsUserRoleMapping 实例对象
     * @return 影响行数
     */
    int update(DmsUserRoleMapping dmsUserRoleMapping);

    /**
     * 通过主键删除数据
     *
     * @param mappingId 主键
     * @return 影响行数
     */
    int deleteById(Integer mappingId);

}
