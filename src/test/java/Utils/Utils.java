package Utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Properties;

public class Utils {

    /**
     * @description The function is used to read value from the config files under Config Folder
     * @param filename: the properties file name
     * @param key: the key of the properties files
     * @return the value corresponding to the key
     * @throws IOException
     **/
    public String read_from_config_file(String filename, String key) throws IOException {
        String value;
        FileInputStream input_stream = new FileInputStream("Configs/" + filename + ".properties");
        Properties properties = new Properties();
        properties.load(input_stream);
        value = properties.getProperty(key);
        input_stream.close();
        return value;
    }

    /**
     * @description Read from Excel File
     * @param filePath  excel file path
     * @param sheetName  sheet name in excel file XLSX format from row 2
     * @return excel data
     * @throws InvalidFormatException
     * @throws IOException
     */
    public static Object[][] read_excel(String filePath, String sheetName) throws IOException {
        FileInputStream file= new FileInputStream(filePath);
        Workbook wb = null;
        String fileExtensionName = filePath.substring(filePath.indexOf("."));
        if(fileExtensionName.equals(".xlsx")){
            wb = new XSSFWorkbook(file);
        }
        else if(fileExtensionName.equals(".xls")){
            wb = new HSSFWorkbook(file);
        }
        Sheet sheet = wb.getSheet(sheetName);

        int rowCount = sheet.getLastRowNum();
        int column = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount][column];
        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < column; j++) {
                Cell cell = row.getCell(j);
                DataFormatter formatter = new DataFormatter();
                String val = formatter.formatCellValue(cell);
                data[i - 1][j] = val;
            }
        }
        return data;
    }

    /**
     * @Description Test Environment Variable Info in Allure Test Result. This can be modified and dynamically used
     * based on requirement
     * @param browser: Browser info
     * @param base_url: Base URL
     */
    public void create_allure_xml_file (String browser, String base_url) {
        String xmlBuilder = "<qa:environment xmlns:qa=\"Dot Dash\">";
        xmlBuilder += "\n\t<name>" + "The Internet Test Results" + "</name>";
        xmlBuilder += "\n\t<parameter>" + "\n\t\t<name>Env</name>" + "\n\t\t<key>Environment</key>" + "\n\t\t<value>" + "Test" + "</value>" + "\n\t</parameter>";
        xmlBuilder += "\n\t<parameter>" + "\n\t\t<name>Browser</name>" + "\n\t\t<key>Browser</key>" + "\n\t\t<value>" + browser + "</value>" + "\n\t</parameter>";
        xmlBuilder += "\n\t<parameter>" + "\n\t\t<name>Base URL</name>" + "\n\t\t<key>Base URL</key>" + "\n\t\t<value>" + base_url + "</value>" + "\n\t</parameter>";
        xmlBuilder += "\n</qa:environment>";
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("environment.xml");
            writer.println(xmlBuilder);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }

        File fileToMove = new File("environment.xml");
        fileToMove.renameTo(new File("allure-results/environment.xml"));
        fileToMove.delete();
    }
}
