package com.example.dms.controller;

import com.alibaba.fastjson.JSON;
import com.example.dms.common.listener.UserEven;
import com.example.dms.common.reflect.ConfigEntity;
import com.example.dms.entity.DmsUser;
import com.example.dms.service.DmsUserService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 用户信息表(DmsUser)表控制层
 *
 * @author makejava
 * @since 2021-09-07 00:43:24
 */
@RestController
@RequestMapping("dmsUser")
public class DmsUserController {
    /**
     * 服务对象
     */
    @Resource
    private DmsUserService dmsUserService;
    @Autowired
    private ConfigEntity configEntity;

    @Autowired
    ApplicationContext applicationContext;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public DmsUser selectOne(Integer id) {
        DmsUser user =dmsUserService.queryById(id);
        applicationContext.publishEvent(new UserEven(this,user));
        return user;
    }
    @PostMapping("importUser")
    public List<DmsUser> importUser (@RequestParam(value = "file") MultipartFile file) throws IOException {
        List<DmsUser> users = new ArrayList<>();
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        int totalRowNum = sheet.getLastRowNum();
        for (int i = 1; i < totalRowNum; i++) {
            DmsUser dmsUser = new DmsUser();
            Row row = sheet.getRow(i);
            dmsUser.setUserName(row.getCell(0).getStringCellValue());
            dmsUser.setPassword(row.getCell(1).getStringCellValue());
            dmsUser.setSalt(row.getCell(2).getStringCellValue());
            Cell cell = row.getCell(3);
            System.out.println(i);
            if (Objects.nonNull(cell)){
                cell.setCellType(CellType.STRING);
                dmsUser.setState(cell.getStringCellValue());
            }
            dmsUser.setBlogUrl(row.getCell(4).getStringCellValue());
            dmsUser.setBlogRemark(row.getCell(5).getStringCellValue());
            users.add(dmsUser);
        }
        dmsUserService.batchInsert(users);
        return users;
    }
    
    @GetMapping("exportUser")
    public List<DmsUser> exportUser (HttpServletResponse response) throws IOException {
        URL url = DmsUserController.class.getResource("/exelTemplates/行列的分手费dms_user.xlsx");
        String path = URLDecoder.decode(url.getPath(),"UTF-8");

        File file = new File(path);
        List<DmsUser> users = new ArrayList<>();
        Workbook workbook = new XSSFWorkbook(new FileInputStream(file));
        Sheet sheet = workbook.getSheetAt(0);
        List<DmsUser>  dmsUsers = dmsUserService.queryAllByLimit(0, 10000);
        for (int i = 1; i < dmsUsers.size(); i++) {
            Row row = sheet.getRow(i);
            if (Objects.isNull(row)){
                row = sheet.createRow(i);
            }
            DmsUser user = dmsUsers.get(i - 1);
            row.createCell(0).setCellValue(user.getUserId());
            row.createCell(1).setCellValue(user.getUserName());
            row.createCell(2).setCellValue(user.getPassword());
            row.createCell(3).setCellValue(user.getSalt());
            row.createCell(4).setCellValue(user.getState());
            row.createCell(5).setCellValue(user.getBlogUrl());
            row.createCell(6).setCellValue(user.getBlogRemark());
        }
        String fileName = "用户信息表" + System.currentTimeMillis() + ".xlsx";
        response.setContentType("application/msexcel");
        response.setHeader("Content-disposition",
                "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
        workbook.write(response.getOutputStream());
        workbook.close();
        return users;
    }
    @PostMapping(value = "/xmlToBean")
    public String xmlTobean(@RequestBody Map<String,Object>obj){
        System.out.println(JSON.toJSONString(obj));
        return null;

    }
    @PostMapping(value = "/batchUpdate")
    public int xmlTobean(@RequestBody List<DmsUser> userList){
        return dmsUserService.batchUpdate(userList);
    }
}
