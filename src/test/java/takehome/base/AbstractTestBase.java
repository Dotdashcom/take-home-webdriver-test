package takehome.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import takehome.pages.*;
import takehome.utilities.BrowserUtilities;
import takehome.utilities.ConfigurationReader;
import takehome.utilities.Driver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTestBase {
    protected DropDownPage dropDownPage;
    protected Actions actions ;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected Checkbox checkbox;
    protected ZDrop dragAndDrop;
    protected DynamicContent dynamicContent;
    protected DynamicControlPage dynamicControlPage;
    protected DynamicLoadingPage dynamicLoadingPage ;
    protected FileDownloadPage fileDownloadPage ;
    protected FileUploadPage fileUploadPage ;
    protected FloatingMenuPage floatingMenuPage;
    protected IFrame iFrame ;
    public HoverPage hoverPage ;
    protected  JSErrorPage jsErrorPage;
    protected NewTabPage newTabPage;
    protected NotifiMsgPage notifiMsgPage;
    protected JSAlertPage jsAlertPage ;





    @BeforeMethod()
    public void setUpMethod(@Optional String url) {
        System.out.println("url = " + url);
        driver = Driver.getDriver();
        BrowserUtilities.waitForPageToLoad(10);
        Driver.getDriver().manage().window().maximize();
       Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        if (url == null) {
            driver.get(ConfigurationReader.getProperty("baseUrl"));
        } else {
            driver.get(url);
        }
        dragAndDrop = new ZDrop();
        loginPage = new LoginPage();
        checkbox= new Checkbox();
        dropDownPage = new DropDownPage();
        dynamicContent = new DynamicContent();
        dynamicControlPage = new DynamicControlPage();
        dynamicLoadingPage = new DynamicLoadingPage();
        fileDownloadPage = new FileDownloadPage();
        fileUploadPage = new FileUploadPage() ;
        floatingMenuPage = new FloatingMenuPage();
        iFrame = new IFrame();
        hoverPage = new HoverPage();
        jsErrorPage = new JSErrorPage();
        newTabPage = new NewTabPage();
        notifiMsgPage = new NotifiMsgPage();
        jsAlertPage = new JSAlertPage();
        actions = new Actions(Driver.getDriver());


    }

    @AfterMethod
    public void teardown() throws IOException {

        BrowserUtilities.wait(3);

        Driver.closeDriver();
    }
}
