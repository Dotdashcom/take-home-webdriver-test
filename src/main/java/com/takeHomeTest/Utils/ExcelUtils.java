package com.takeHomeTest.Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// reading CSV files

public class ExcelUtils {

	public static FileInputStream fi;

	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowsCount(String xFile, String sheetName) throws IOException {
		int rowCount;
		fi = new FileInputStream(xFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		rowCount = ws.getLastRowNum();
		wb.close();
		fi.close();
		System.out.println("Totals rows in " + sheetName + " : " + rowCount);
		return rowCount;
	}

	public static int getColumnCount(String xFile, String sheetName, int rowNo) throws Exception {
		int colCount;
		fi = new FileInputStream(xFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rowNo);
		colCount = row.getLastCellNum();
		wb.close();
		fi.close();
		System.out.println("Column count in " + sheetName + " : " + colCount);
		return colCount;
	}

	@SuppressWarnings("deprecation")
	public static String getCellData(String xFile, String sheetName, int rowNo, int colNo) throws Exception {
		String data = "";
		fi = new FileInputStream(xFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rowNo);
		cell = row.getCell(colNo);
		cell.setCellType(cell.CELL_TYPE_STRING);
		data = cell.getStringCellValue();

		return data;
	}

}
