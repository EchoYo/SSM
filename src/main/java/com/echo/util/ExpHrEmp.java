package com.echo.util;

import com.echo.model.Emp;
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
public class ExpHrEmp {
    //导出Excel
    public static void expExcel(String expFilePath,List<Emp> customs){
        OutputStream os = null ;
        Workbook book = null;
        try {
            // 输出流
            os = new FileOutputStream(expFilePath);
            // 创建工作区(97-2003)
            book = new XSSFWorkbook();
            // 创建第一个sheet页
            Sheet sheet= book.createSheet("test");
            // 生成第一行
            Row row = sheet.createRow(0);
            // 给第一行的第一列赋值
            row.createCell(0).setCellValue("工号");
            row.createCell(1).setCellValue("登记号");
            row.createCell(2).setCellValue("用工性质");
            row.createCell(3).setCellValue("姓名");
            row.createCell(4).setCellValue("性别");
            row.createCell(5).setCellValue("学历");
            row.createCell(6).setCellValue("参保类型");
            row.createCell(7).setCellValue("所属部门");
            row.createCell(8).setCellValue("岗位");
            row.createCell(9).setCellValue("身份证号");
            row.createCell(10).setCellValue("入职日期");
            row.createCell(11).setCellValue("离职日期");
            row.createCell(12).setCellValue("现住址");
            row.createCell(13).setCellValue("户籍地址");
            row.createCell(14).setCellValue("电话");
            row.createCell(15).setCellValue("合同生效日期");
            row.createCell(16).setCellValue("合同结束日期");
            row.createCell(17).setCellValue("备注");
            for(int i = 1;i<=customs.size();i++){
                row = sheet.createRow(i);
                Emp empCustom = customs.get(i-1);
                row.createCell(0).setCellValue(empCustom.getWorkId());
                row.createCell(1).setCellValue(empCustom.getCardId());
                row.createCell(2).setCellValue(empCustom.getNatureId());
                row.createCell(3).setCellValue(empCustom.getEmpName());
                row.createCell(4).setCellValue(empCustom.getSex());
                row.createCell(5).setCellValue(empCustom.getEducation());
                row.createCell(6).setCellValue(empCustom.getCpfId());
                row.createCell(7).setCellValue(empCustom.getDeptId());
                row.createCell(8).setCellValue(empCustom.getPostName());
                row.createCell(9).setCellValue(empCustom.getIdentityId());
                row.createCell(10).setCellValue(empCustom.getEntryDate());
                row.createCell(11).setCellValue(empCustom.getLeaveDate());
                row.createCell(12).setCellValue(empCustom.getHomeAddress());
                row.createCell(13).setCellValue(empCustom.getTmpAddress());
                row.createCell(14).setCellValue(empCustom.getPhone());
                row.createCell(15).setCellValue(empCustom.getContractStart());
                row.createCell(16).setCellValue(empCustom.getContractEnd());
                row.createCell(17).setCellValue(empCustom.getRemarks());
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
