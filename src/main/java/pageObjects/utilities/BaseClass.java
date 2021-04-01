package utilities;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.HashMap;
//Base class for all tests
public class BaseClass {

    public static String testDataFilePath;
    private static String xlQuery;
    private static Connection connection;
    private static Recordset recordset;
    public static WebDriver driver;

    //Get data from Config file
    ReadConfig readconfig=new ReadConfig();
    public String baseURL=readconfig.getBaseUrl();

    //Setup browser
    @BeforeClass
    public void setup(){
        String chromedriverPath = readconfig.getChromePath();
        //Select chromeDriver version as per OS
        if(System.getProperty("os.name").toLowerCase().contains("win")){
            chromedriverPath+=".exe";
        }
        System.setProperty("webdriver.chrome.driver", chromedriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
    }

    //Tear down
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    //Initialize Datasheet Path
    public void initialize_TestDataSheet(String sheetName){
        testDataFilePath = "./src\\main\\resources\\datasheet\\"+sheetName;
    }

    //Read data from excel
    public HashMap<String, String> fnReadTestDataFromExcel(String dataSheetName, String testCaseName)
    {
        initialize_TestDataSheet(dataSheetName);
        xlQuery = "Select * from TestCaseData where TestCase='"+testCaseName+"'";

        HashMap<String, String> sTestData = new HashMap<String, String> ();
        Fillo fillo = new Fillo();
        try {
            ArrayList<String> listColNames = getDataColumnNames();
            connection = fillo.getConnection(testDataFilePath);
            recordset = connection.executeQuery(xlQuery);

            while(recordset.next())
            {
                for( String listColName : listColNames ) {
                    sTestData.put(listColName, recordset.getField(listColName));
                }

                }

            } catch (FilloException e) {
                e.printStackTrace();
            }

            recordset.close();
            connection.close();

            recordset = null;
            connection = null;

            return sTestData;

    }

    //Retrieve column names for specified test case record
    public ArrayList getDataColumnNames() {
        ArrayList<String> sColumnNames = null;
        Fillo fillo = new Fillo();

        try {
            connection = fillo.getConnection(testDataFilePath);
            recordset = connection.executeQuery(xlQuery);

            while(recordset.next())
            {
                sColumnNames = recordset.getFieldNames();
            }
        } catch (FilloException e) {
            e.printStackTrace();
        }

        recordset.close();
        connection.close();

        recordset = null;
        connection = null;

        return sColumnNames;
    }


}