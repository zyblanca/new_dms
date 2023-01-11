package com.example.dms.excel;

import com.example.dms.entity.DmsUser;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @author zhouy
 * @date 2021/9/15
 * good 09
 */
public class ExcelUtils {


    public static Workbook readExcelFile(File file){
        Workbook workbook = null;
        String url = file.getPath();
        if  (url.endsWith(".xls")){
            workbook = new HSSFWorkbook();
        }else if (url.endsWith(".xls")){
            workbook = new HSSFWorkbook();
        }else {
            workbook = null;
        }
        return workbook;
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\zhouy\\Desktop\\info.xlsx");
        Workbook workbook = ExcelUtils.readExcelFile(file);
        int sheetNumber = workbook.getNumberOfSheets();
        for (int i = 0; i <sheetNumber; i++) {
            Sheet sheet = workbook.getSheetAt(i);
            int maxRowNum = sheet.getLastRowNum();
            for (int rowNum  = 1; rowNum  < maxRowNum; rowNum ++) {
                Row row =  sheet.getRow(rowNum);
                if (Objects.isNull(row)){
                    continue;
                }
                DmsUser dmsUser = new DmsUser();
                int cellNum= row.getLastCellNum();
                for (int cellnum = 0; cellnum < cellNum; cellnum++) {
                }
            }
        }

    }
}
