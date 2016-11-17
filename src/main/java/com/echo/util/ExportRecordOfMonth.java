package com.echo.util;

import com.echo.model.EmpCustom;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * <p>Description:</p>
 * Created by Echoj on 2016-07-18.
 */
public class ExportRecordOfMonth {
    //导出Excel
    public static void expExcel(String expFilePath,List<EmpCustom> customs,List<Integer> listDay){
        OutputStream os = null ;
        Workbook book = null;
        try {
            // 输出流
            os = new FileOutputStream(expFilePath);
            // 创建工作区(2007)
            book = new XSSFWorkbook();
            // 创建第一个sheet页
            Sheet sheet= book.createSheet("test");
            // 生成第一行
            Row row = sheet.createRow(0);
            // 给第一行的第一列赋值
            row.createCell(0).setCellValue("工号");
            row.createCell(1).setCellValue("姓名");
            row.createCell(2).setCellValue("部门");
            for(int i = 1;i<listDay.size()+1;i++){
                row.createCell(i+2).setCellValue(i);
            }
            for(int i = 1;i<=customs.size();i++){
                row = sheet.createRow(i);
                EmpCustom empCustom = customs.get(i-1);
                row.createCell(0).setCellValue(empCustom.getEmp().getWorkId());
                row.createCell(1).setCellValue(empCustom.getEmp().getEmpName());
                row.createCell(2).setCellValue(empCustom.getDeptName());
                for(int j = 1;j<listDay.size()+1;j++){
                    List<String> record = empCustom.getRecords().get(j-1);
                    String value = "";
                    for(int k = 0;k<record.size();k++){
                       value = value + record.get(k)+" ";
                    }
                    row.createCell(j+2).setCellValue(value);
                }
            }
            // 写文件
            book.write(os);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭输出流
            try {
                assert os != null;
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
