package com.echo.util;

import com.echo.model.Drawing;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 导入文控图纸
 * <p>Description:获取excel数据</p>
 * Created by Echoj on 2016-06-12.
 */
public class ImportExcel {
    /**
     * 查询指定目录中电子表格中所有的数据
     *
     * @param file 文件完整路径
     * @return
     */
    //导入Excel
    public static List<Drawing> getAllByExcel(String file) {
        List<Drawing> list = new ArrayList<Drawing>();
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
                    Drawing drawing = new Drawing();
                    drawing.setDate(row.getCell(j++).toString());
                    drawing.setId(Long.parseLong(row.getCell(j++).toString()));
                    drawing.setSampleDrawingEdition(row.getCell(j++).toString());
                    drawing.setCustomerName(row.getCell(j++).toString());
                    drawing.setCustomerDrawingName(row.getCell(j++).toString());
                    drawing.setCustomerDrawingNumber(row.getCell(j++).toString());
                    drawing.setCustomerDrawingEdition(row.getCell(j++).toString());
                    drawing.setMoldDrawingEdition(row.getCell(j++).toString());
                    drawing.setMoldDrawingDate(row.getCell(j++).toString());
                    drawing.setFormalDrawingEdition(row.getCell(j++).toString());
                    drawing.setFormalDrawingDate(row.getCell(j++).toString());
                    drawing.setCraftNumber(row.getCell(j++).toString());
                    drawing.setCraftEdition(row.getCell(j++).toString());
                    drawing.setCraftDate(row.getCell(j++).toString());
                    drawing.setFormalMoldDrawingEdition(row.getCell(j++).toString());
                    drawing.setFormalMoldDrawingDate(row.getCell(j++).toString());
                    drawing.setRemark(row.getCell(j++).toString());
                    list.add(drawing);
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
            row.createCell(0).setCellValue("column1");
            // 给第一行的第二列赋值
            row.createCell(1).setCellValue("column2");
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

