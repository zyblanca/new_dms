package com.example.dms.controller;

import com.example.dms.entity.DmsRolePermissionMapping;
import com.example.dms.service.DmsRolePermissionMappingService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 角色与权限映射表(DmsRolePermissionMapping)表控制层
 *
 * @author makejava
 * @since 2021-09-07 00:43:24
 */
@RestController
@RequestMapping("dmsRolePermissionMapping")
public class DmsRolePermissionMappingController {
    /**
     * 服务对象
     */
    @Resource
    private DmsRolePermissionMappingService dmsRolePermissionMappingService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public DmsRolePermissionMapping selectOne(Integer id) {
        return this.dmsRolePermissionMappingService.queryById(id);
    }

}