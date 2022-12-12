package com.automation.utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ReadDataFromExcel {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook("src/test/resources/data/testdata.xlsx");
        XSSFSheet sheet = workbook.getSheetAt(0);


        for(int i=0; i<sheet.getPhysicalNumberOfRows(); i++){
            XSSFRow row = sheet.getRow(i);

            for(int j=0; j<row.getPhysicalNumberOfCells(); j++){
                    System.out.print(row.getCell(j).toString() +"  ");
            }
            System.out.println();
        }

    }
}
