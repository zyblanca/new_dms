package com.example.dms.controller;

import com.example.dms.entity.DmsRole;
import com.example.dms.service.DmsRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 角色信息表(DmsRole)表控制层
 *
 * @author makejava
 * @since 2021-09-07 00:43:24
 */
@RestController
@RequestMapping("dmsRole")
public class DmsRoleController {
    /**
     * 服务对象
     */
    @Resource
    private DmsRoleService dmsRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public DmsRole selectOne(Integer id) {
        return this.dmsRoleService.queryById(id);
    }

}