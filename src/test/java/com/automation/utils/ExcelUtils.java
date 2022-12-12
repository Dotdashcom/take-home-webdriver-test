package com.automation.utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public static void initExcelData(){
        try {
            workbook = new XSSFWorkbook("src/test/resources/data/testdata.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static XSSFSheet getSheet(){
        return sheet;
    }

    public static String getCellValue(int row, int col){
        sheet = workbook.getSheetAt(0);
        XSSFRow cell = sheet.getRow(row);
        return cell.getCell(col).toString();
    }

}
