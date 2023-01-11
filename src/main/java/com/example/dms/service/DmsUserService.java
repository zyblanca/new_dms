package com.example.dms.service;

import com.example.dms.entity.DmsUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户信息表(DmsUser)表服务接口
 *
 * @author makejava
 * @since 2021-09-07 00:43:24
 */
public interface DmsUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    DmsUser queryById(Integer userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DmsUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param dmsUser 实例对象
     * @return 实例对象
     */
    DmsUser insert(DmsUser dmsUser);

    /**
     * 修改数据
     *
     * @param dmsUser 实例对象
     * @return 实例对象
     */
    DmsUser update(DmsUser dmsUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userId);

    /**
     * 批量插入
     *
     * @param userList
     * @return int
     */
    int batchInsert(List<DmsUser> userList);

    /**
     *
     * @param userList
     * @return
     */
    int batchUpdate(List<DmsUser> userList);

}
