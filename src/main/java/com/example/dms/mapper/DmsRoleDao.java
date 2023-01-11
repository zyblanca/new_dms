package com.example.dms.mapper;

import com.example.dms.entity.DmsRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色信息表(DmsRole)表数据库访问层
 *
 * @author makejava
 * @since 2021-09-07 00:43:24
 */
@Repository
public interface DmsRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    DmsRole queryById(Integer roleId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DmsRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dmsRole 实例对象
     * @return 对象列表
     */
    List<DmsRole> queryAll(DmsRole dmsRole);

    /**
     * 新增数据
     *
     * @param dmsRole 实例对象
     * @return 影响行数
     */
    int insert(DmsRole dmsRole);

    /**
     * 修改数据
     *
     * @param dmsRole 实例对象
     * @return 影响行数
     */
    int update(DmsRole dmsRole);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 影响行数
     */
    int deleteById(Integer roleId);

}
