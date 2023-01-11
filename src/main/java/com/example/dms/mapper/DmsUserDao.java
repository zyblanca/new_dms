package com.example.dms.mapper;

import com.example.dms.entity.DmsUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户信息表(DmsUser)表数据库访问层
 *
 * @author makejava
 * @since 2021-09-07 00:43:24
 */
@Repository
public interface DmsUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    DmsUser queryById(Integer userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DmsUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dmsUser 实例对象
     * @return 对象列表
     */
    List<DmsUser> queryAll(DmsUser dmsUser);

    /**
     * 新增数据
     *
     * @param dmsUser 实例对象
     * @return 影响行数
     */
    int insert(DmsUser dmsUser);

    /**
     * 修改数据
     *
     * @param dmsUser 实例对象
     * @return 影响行数
     */
    int update(DmsUser dmsUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(Integer userId);

    /**
     * 批量插入
     * @param userList
     * @return
     */
    int batchInsert(@Param("userList") List<DmsUser> userList);

    /**
     *
     * @param userList
     * @return
     */
    int batchUpdate(@Param("userList") List<DmsUser> userList);

}
