package utils;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {


	// Global Variables
	public String path;
	public FileInputStream fis = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	// Constructor to initialize variables
	public ExcelReader(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String getCell_Data(String sheetName,int rownum,int colnum) throws IOException
	{
		fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);

		DataFormatter formatter = new DataFormatter();
		String data;
		try{
			data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
		}
		catch(Exception e)
		{
			data="";
		}
		workbook.close();
		fis.close();
		return data;
	}
	// Method to call the value
	public String getCellData(String sheetName, String colName, int rowNum) {
		// For Sheet
		int index = workbook.getSheetIndex(sheetName);
		int col_Num = 0;
		sheet = workbook.getSheetAt(index);

		// For Row
		row = sheet.getRow(0);
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
				col_Num = i;
			}
		}

		// For Column
		row = sheet.getRow(rowNum - 1);
		cell = row.getCell(col_Num);
		return cell.getStringCellValue();
	}

	public int getRowCount(String sheetName) throws IOException
	{
		fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowcount;
	}


	public int getCellCount(String sheetName,int rownum) throws IOException
	{
		fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		fis.close();
		return cellcount;
	}

}
