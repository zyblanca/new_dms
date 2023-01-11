package com.example.dms.controller;

import com.example.dms.Intercerptor.RoleData;
import com.example.dms.UserLoginUtil;
import com.example.dms.common.reflect.Order;
import com.example.dms.entity.DmsPermission;
import com.example.dms.service.DmsPermissionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限信息表(DmsPermission)表控制层
 *
 * @author makejava
 * @since 2021-09-07 00:43:24
 */
@RestController
@RequestMapping("dmsPermission")
@CrossOrigin(value = "**")
public class DmsPermissionController {
    /**
     * 服务对象
     */
    @Resource
    private DmsPermissionService dmsPermissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RoleData(good = "数据权限")
    @GetMapping("selectOne")
    @PreAuthorize("hasAuthority('user:add')")
    public List<DmsPermission> selectOne() throws Exception {
        Order order = UserLoginUtil.get();
        System.out.println("");
        throw new Exception("全局异常");

        //return this.dmsPermissionService.queryAllByLimit(0, 100);
    }

}
