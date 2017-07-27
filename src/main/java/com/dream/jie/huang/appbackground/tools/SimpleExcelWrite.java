package com.dream.jie.huang.appbackground.tools;

import com.dream.jie.huang.appbackground.entity.Result;
import org.apache.poi.hssf.usermodel.*;

import java.io.OutputStream;
import java.util.List;

/**
 * Created by Dream on 2017/7/24.
 */
public class SimpleExcelWrite {

    public void createExcel(OutputStream os, List<Result> list){
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("成绩");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        HSSFCell cell = row.createCell((short) 0);
        cell.setCellValue("用户ID");
        cell.setCellStyle(style);
        cell = row.createCell((short) 1);
        cell.setCellValue("用户姓名");
        cell.setCellStyle(style);
        cell = row.createCell((short) 2);
        cell.setCellValue("成绩");
        cell.setCellStyle(style);
        cell = row.createCell((short) 3);
        cell.setCellValue("测试时间");
        cell.setCellStyle(style);
        cell = row.createCell((short) 4);
        cell.setCellValue("组织");
        cell.setCellStyle(style);

        for (int i = 0; i < list.size(); i++)
        {
            row = sheet.createRow((int) i + 1);
            Result stu = list.get(i);
            // 第四步，创建单元格，并设置值
            row.createCell((short) 0).setCellValue(stu.getUserid());
            row.createCell((short) 1).setCellValue(stu.getUsername());
            row.createCell((short) 2).setCellValue(stu.getGrade());
            row.createCell((short) 3).setCellValue(stu.getSettime());
            row.createCell((short) 4).setCellValue(stu.getOrg());
        }
        // 第六步，将文件存到指定位置
        try
        {
//            FileOutputStream fout = new FileOutputStream("E:/students.xls");
            wb.write(os);
            wb.close();
            os.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
