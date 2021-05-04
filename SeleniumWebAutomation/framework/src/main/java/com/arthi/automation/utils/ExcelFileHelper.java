package com.arthi.automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileHelper {

	public static void main(String[] args) {
		writeToFile("./arthi_api.xlsx");
		System.out.println("Completed.");
	}
	
	private static Object[][] handleXlsFile(FileInputStream fileInputStream, final String sheetName) {
		try(Workbook workbook = new HSSFWorkbook(fileInputStream)) {
			Sheet sheet = workbook.getSheet(sheetName);
			int rowCount = getRowCount(sheet);
			int columnCount = getColumnCount(sheet);
			Object[][] returnObj = new Object[rowCount-1][columnCount-1];
			
			for(int i=1; i<rowCount; i++) {
				Row row = sheet.getRow(i);
				if (readCellvalue(row.getCell(0)).equals("Y")) {
					for(int j=1; i<columnCount; i++) {
						Cell cell = row.getCell(j);
						returnObj[i][j] = readCellvalue(cell);
					}					
				}
			}
			return returnObj;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Object[0][0];
		}
	}
	
	private static Object[][] handleXlsxFile(FileInputStream fileInputStream, final String sheetName) {
		try(Workbook workbook = new XSSFWorkbook(fileInputStream)) {
			Sheet sheet = workbook.getSheet(sheetName);
			
			int rowCnt = 0;
			int columnCnt = 0;
			int rowsDefined = 0;
			
			Map<String, List<String>> entireInput = new TreeMap<String, List<String>>();
			List<String> mapInput;
			for(Row row: sheet) {
				int colsDefined = 0;
				if (rowsDefined == 0) {
					rowsDefined++;
					continue;
				}
				Object inclusionFlagValue = readCellvalue(row.getCell(0));
				if(inclusionFlagValue != null && "Y".equals(inclusionFlagValue)) {
					rowCnt++;
					mapInput = new ArrayList<String>();
					final String key = (String) readCellvalue(row.getCell(1));
					for(Cell cell: row) {
						if (colsDefined == 0) {
							colsDefined++;
							continue;
						}
						columnCnt++;
						mapInput.add("" + readCellvalue(cell));
					}
					//System.out.println("Trying to put key: " + key + ", " + mapInput);
					entireInput.put(key, mapInput);
				}
			}
//			System.out.println("==================================================");
//			System.out.println(entireInput);
//			System.out.println("==================================================");
			
			Object[][] returnObj = new Object[rowCnt][columnCnt];
			
			int i=0;
			for(Entry<String, List<String>> entry: entireInput.entrySet()) {
				List<String> values = entry.getValue();
				for (int j=0; j < values.size(); j++) {
					returnObj[i][j] = values.get(j);
				}
				i++;
			}
			
			return returnObj;
		}
		catch (Exception e) {
			e.printStackTrace();
			return new Object[0][0];
		}
	}
	
	private static Object readCellvalue(final Cell cell) {
		if (null != cell) {
			switch(cell.getCellTypeEnum()) {
				case BLANK:
					return cell.getRichStringCellValue().getString();
				case STRING:
					return cell.getStringCellValue();
				case NUMERIC:
					return new DataFormatter().formatCellValue(cell);
				case BOOLEAN:
					return cell.getBooleanCellValue();
				case _NONE:
					return "";
				default:
					return null;
			}
		}
		return null;
	}
	
	public static Object[][] readFromExcelFile(final String filePath, final String sheetName) {
		try(FileInputStream fileInputStream = new FileInputStream(filePath)) {
			if (StringUtils.endsWith(filePath, ".xlsx")) {
				return handleXlsxFile(fileInputStream, sheetName);
			}
			else if (StringUtils.endsWith(filePath, ".xls")) {
				return handleXlsFile(fileInputStream, sheetName);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Object[0][0];
	}
	
	private static int getRowCount(final Sheet sheet) {
		int rowCount = sheet.getPhysicalNumberOfRows();
		//int rowCount = sheet.getLastRowNum() +1;
		return rowCount;
	}
	
	private static int getColumnCount(final Sheet sheet) {
		Row row = sheet.getRow(1); // Ignoring the first column
		int columnCount = row.getLastCellNum();
		return columnCount;
	}
	
	private static void writeToFile(final String filepath) {
		String[][] authApiData = new String[][] {{"Run(Y/N)", "TestCaseId", "Test Description", "UserName","Password","StatusCode","StatusMessage","FirstName", "LastName", "UserName"},
			{"Y", "1", "Validate Auth with valid values", "sekure_crm","SekureCrm2019!","200","Success","Sekure", "crm", "sekure_crm"},
			{"Y", "2", "Validate Auth with only valid Password", "UserName","SekureCrm2019!","401","Unauthorized","", "", ""},
			{"Y", "3", "Validate Auth with only valid UserName", "sekure_crm","Password","401","Unauthorized","", "", ""},
			{"Y", "4", "Validate Auth with Empty UserName and valid password", "","SekureCrm2019!","401","Unauthorized","", "", ""},
			{"Y", "5", "Validate Auth with Empty Password and valid UserName", "sekure_crm","","401","Unauthorized","", "", ""},
			{"Y", "6", "Validate Auth with Empty Values", "","","401","Unauthorized","", "", ""}};
		
		try (Workbook workbook = new XSSFWorkbook()) {
			Sheet sheet = workbook.createSheet();
			workbook.setSheetName(0, "AuthApi");
			for (int i=0; i< authApiData.length; i++) {
				final String[] columnData = authApiData[i];
				Row row = sheet.createRow(i);
				for(int j=0; j< columnData.length; j++) {
					Cell cell = row.createCell(j);
					if (j==2) {
						sheet.setColumnWidth(j, 20000);
					}
					cell.setCellValue(columnData[j]);
					System.out.println("Completed the Cell: " + j + " for Row " + i);
				}
				System.out.println("Completed the Row: " + i);
			}
			try(FileOutputStream fostream = new FileOutputStream(filepath)) {
				workbook.write(fostream);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}

}
