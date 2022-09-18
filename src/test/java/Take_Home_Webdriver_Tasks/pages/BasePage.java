package Take_Home_Webdriver_Tasks.pages;


import Take_Home_Webdriver_Tasks.utilities.ConfigurationReader;
import Take_Home_Webdriver_Tasks.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public  abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    /**
     * methods to navigate between pages
     * @param pageName
     */

    public static void navigateToPage(String pageName){

        String pageURL = ConfigurationReader.getProperty("page.url");
        Driver.getDriver().get(pageURL + pageName);
    }



}
