package data;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {

	public static Workbook book;
	public static Sheet sheet;
	
	public static Object[][] read(String sheetname){
		
		
		FileInputStream file = null;
		
		try {
			file = new FileInputStream("C:\\Users\\Service 1\\eclipse-workspace\\Webdriver\\src\\test\\java\\data\\Data.xlsx");
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file); 
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		
		for (int i=0; i<sheet.getLastRowNum();i++) {
			
			for(int k = 0; k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();			
				
			}
		}
		return data;
	}
}
