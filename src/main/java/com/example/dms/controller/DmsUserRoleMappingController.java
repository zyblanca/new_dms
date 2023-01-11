package com.example.dms.controller;

import com.example.dms.entity.DmsUserRoleMapping;
import com.example.dms.service.DmsUserRoleMappingService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户与角色映射表(DmsUserRoleMapping)表控制层
 *
 * @author makejava
 * @since 2021-09-07 00:43:24
 */
@RestController
@RequestMapping("dmsUserRoleMapping")
public class DmsUserRoleMappingController {
    /**
     * 服务对象
     */
    @Resource
    private DmsUserRoleMappingService dmsUserRoleMappingService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public DmsUserRoleMapping selectOne(Integer id) {
        return this.dmsUserRoleMappingService.queryById(id);
    }

}
