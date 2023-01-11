package com.example.dms.service.impl;

import com.example.dms.entity.DmsUser;
import com.example.dms.mapper.DmsUserDao;
import com.example.dms.service.DmsUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户信息表(DmsUser)表服务实现类
 *
 * @author makejava
 * @since 2021-09-07 00:43:24
 */
@Service("dmsUserService")
public class DmsUserServiceImpl implements DmsUserService {
    @Resource
    private DmsUserDao dmsUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public DmsUser queryById(Integer userId) {
        return this.dmsUserDao.queryById(userId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<DmsUser> queryAllByLimit(int offset, int limit) {
        return this.dmsUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param dmsUser 实例对象
     * @return 实例对象
     */
    @Override
    public DmsUser insert(DmsUser dmsUser) {
        this.dmsUserDao.insert(dmsUser);
        return dmsUser;
    }

    /**
     * 修改数据
     *
     * @param dmsUser 实例对象
     * @return 实例对象
     */
    @Override
    public DmsUser update(DmsUser dmsUser) {
        this.dmsUserDao.update(dmsUser);
        return this.queryById(dmsUser.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userId) {
        return this.dmsUserDao.deleteById(userId) > 0;
    }

    /**
     * 批量插入
     * @param userList
     * @return
     */
    @Transactional
    @Override
    public int batchInsert(@Param("userList") List<DmsUser> userList){
        return this.dmsUserDao.batchInsert(userList);
    }

    @Override
    public int batchUpdate(List<DmsUser> userList) {
        return this.dmsUserDao.batchUpdate(userList);
    }
}
