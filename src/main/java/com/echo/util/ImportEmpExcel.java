package com.echo.util;

import com.echo.model.Emp;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 导入花名册
 * <p>Description:获取excel数据</p>
 * Created by Echoj on 2016-06-12.
 */
public class ImportEmpExcel {
    /**
     * 查询指定目录中电子表格中所有的数据
     *
     * @param file 文件完整路径
     * @return
     */
    //导入Excel
    public static List<Emp> getAllByExcel(String file) {
        List<Emp> list = new ArrayList<Emp>();
        try {
            Workbook rwb = null;
            try {
                // Excel 2007获取方法
                rwb = new XSSFWorkbook(new FileInputStream(file));
            } catch (Exception ex) {
                // Excel 2003获取方法
                rwb = new HSSFWorkbook(new FileInputStream(file));
            }
            // 读取表格的第一个sheet页
            Sheet sheet = rwb.getSheetAt(0);
            // 定义 row、cell
            Row row;
            String cell;
            // 总共有多少行,从0开始
            int totalRows = sheet.getLastRowNum();
            // 循环输出表格中的内容,首先循环取出行,再根据行循环取出列
            for (int i = 1; i <= totalRows; i++) {
                row = sheet.getRow(i);
                // 处理空行
                if (row == null) {
                    continue;
                }
                // 总共有多少列,从0开始
                int totalCells = row.getLastCellNum();
                for (int j = row.getFirstCellNum(); j < totalCells; j++) {
                    // 处理空列
                    if (row.getCell(j) == null) {
                        continue;
                    }
                    // 通过 row.getCell(j).toString() 获取单元格内容
                    Emp emp = new Emp();
                    emp.setEmpId(row.getCell(j++).toString());
                    emp.setWorkId(row.getCell(j++).toString());
                    emp.setNatureId(row.getCell(j++).toString());
                    emp.setEmpName(row.getCell(j++).toString());
                    emp.setSex(row.getCell(j++).toString());
                    emp.setIdentityId(row.getCell(j++).toString());
                    emp.setEducation(row.getCell(j++).toString());
                    emp.setDeptId(row.getCell(j++).toString());
                    emp.setPostName(row.getCell(j++).toString());
                    emp.setCpfId(row.getCell(j++).toString());
                    emp.setEntryDate(row.getCell(j++).toString());
                    emp.setLeaveDate(row.getCell(j++).toString());
                    emp.setContractStart(row.getCell(j++).toString());
                    emp.setContractEnd(row.getCell(j++).toString());
                    emp.setTmpAddress(row.getCell(j++).toString());
                    emp.setHomeAddress(row.getCell(j++).toString());
                    emp.setPhone(row.getCell(j++).toString());
                    emp.setLeaveYN(row.getCell(j++).toString());
                    list.add(emp);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    //导出Excel
    public static void expExcel(String expFilePath){
        OutputStream os = null ;
        Workbook book = null;
        try {
            // 输出流
            os = new FileOutputStream(expFilePath);
            // 创建工作区(97-2003)
            book = new HSSFWorkbook();
            // 创建第一个sheet页
            Sheet sheet= book.createSheet("test");
            // 生成第一行
            Row row = sheet.createRow(0);
            // 给第一行的第一列赋值
            row.createCell(0).setCellValue("工号");
            row.createCell(1).setCellValue("用工性质");
            row.createCell(2).setCellValue("姓名");
            row.createCell(3).setCellValue("性别");
            row.createCell(4).setCellValue("身份证号");
            row.createCell(5).setCellValue("学历");
            row.createCell(6).setCellValue("部门");
            row.createCell(7).setCellValue("岗位");
            row.createCell(8).setCellValue("公积金类型");
            row.createCell(9).setCellValue("入职日期");
            row.createCell(10).setCellValue("离职日期");
            row.createCell(11).setCellValue("合同生效日期");
            row.createCell(12).setCellValue("合同结束日期");
            row.createCell(13).setCellValue("户籍地址");
            row.createCell(14).setCellValue("现居住地");
            row.createCell(15).setCellValue("电话");
            row.createCell(16).setCellValue("离职状态");
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

