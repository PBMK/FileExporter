package com.krish.FileExporter.write;

import com.krish.FileExporter.model.Employee;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class WriteExcel {

        public void createExcel(List<Employee> list, String dest) {

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Employee Data");
            int rownum = 0;
            for (Employee key : list) {
                Employee curr = key;
                for(String pro : curr.profession) {
                    for(String spec : curr.specialization) {
                        Row row = sheet.createRow(rownum++);
                        int cellnum = 0;
                        Cell cell = row.createCell(cellnum++);
                        cell.setCellValue((Double)curr.id);
                        cell = row.createCell(cellnum++);
                        cell.setCellValue((String)pro);
                        cell = row.createCell(cellnum++);
                        cell.setCellValue((String)spec);
                    }
                }
            }
            try
            {
                FileOutputStream out = new FileOutputStream(new File(dest));
                workbook.write(out);
                out.close();
                System.out.println("File saved successfully on file.");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

