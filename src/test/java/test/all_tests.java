package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import utils.Browser_Factory;
import utils.ExcelReader;

import java.io.IOException;

public class all_tests {
    WebDriver driver;

    String login = "login";
    String checkboxes = "checkboxes";
    String context_menu = "context_menu";
    String drag_and_drop = "drag_and_drop";
    String dropdown = "dropdown";
    String dynamic_content = "dynamic_content";
    String dynamic_controls = "dynamic_controls";
    String dynamic_loading_2 = "dynamic_loading/2";
    String download = "download";
    String upload = "upload";
    String floating_menu = "floating_menu";
    String iframe = "iframe";
    String hovers = "hovers";
    String javascript_alerts = "javascript_alerts";
    String javascript_error = "javascript_error";
    String windows = "windows";
    String notification_message_rendered = "notification_message_rendered";
    ExcelReader XLR = new ExcelReader("Test_data\\login_data.xlsx");
    String UserName = XLR.getCellData("Logininfo", "UserName", 2);
    String PassWord = XLR.getCellData("Logininfo", "PassWord", 2);

    @BeforeClass
    public void browser_fact_before() {
        driver = Browser_Factory.init_browser();
    }

    @Test(priority=1)
    public void login_test() throws InterruptedException {
        Browser_Factory.init_url(login);
        login_page Pagex = PageFactory.initElements(driver, login_page.class);
        Pagex.login_meth(UserName, PassWord);
    }
    @Test(priority=2)
    public void Checkboxes_test(){
        driver = Browser_Factory.init_url(checkboxes);
       checkboxes_page cp = PageFactory.initElements(driver,checkboxes_page.class);
       cp.chech_box_meth();
    }
    @Test(priority=3)
    public void Context_Menu_test(){
        driver = Browser_Factory.init_url(context_menu);
         context_menu_page cmp= PageFactory.initElements(driver, context_menu_page.class);
         cmp.right_click_meth();
    }
    @Test(priority=4)
    public void Drag_and_Drop_test(){
        driver = Browser_Factory.init_url(drag_and_drop);
         drag_and_drop_page ddp = PageFactory.initElements(driver, drag_and_drop_page.class);
         ddp.Drag_and_Drop_meth();
    }
    @Test(priority=5)
    public void dropdown_test() throws InterruptedException {
        driver = Browser_Factory.init_url(dropdown);
         dropdown_page dwp = PageFactory.initElements(driver, dropdown_page.class);
         dwp.Drop_Down_meth();
    }
    @Test(priority=6)
    public void Dynamic_Content_test(){
        driver = Browser_Factory.init_url(dynamic_content);
         dynamic_content_page dcp = PageFactory.initElements(driver, dynamic_content_page.class);
         dcp.Dynamic_Content_meth();
    }
    @Test(priority=7)
    public void Dynamic_Controls_test(){
        driver = Browser_Factory.init_url(dynamic_controls);
         dynamic_controls_page dtp = PageFactory.initElements(driver, dynamic_controls_page.class);
         dtp.Dynamic_Controls_meth();
    }
    @Test(priority=8)
    public void dynamic_loading_test(){
        driver = Browser_Factory.init_url(dynamic_loading_2);
          dynamic_loading_page dlp= PageFactory.initElements(driver, dynamic_loading_page.class);
          dlp.Dynamic_loading_meth();
    }
    @Test(priority=9)
    public void download_test() throws IOException, InterruptedException {
        driver = Browser_Factory.init_url(download);
        download_page dp = PageFactory.initElements(driver, download_page.class);
        dp.File_Download_meth();
    }
    @Test(priority=10)
    public void Upload_test() throws InterruptedException {
        driver = Browser_Factory.init_url(upload);
       upload_page up = PageFactory.initElements(driver, upload_page.class);
       up.File_Upload_meth();
    }
    @Test(priority=11)
    public void Floating_Menu_test(){
        driver = Browser_Factory.init_url(floating_menu);
       floating_menu_page fmp  = PageFactory.initElements(driver, floating_menu_page.class);
       fmp.right_click_meth();
    }
    @Test(priority=12)
    public void Iframe_test(){
        driver = Browser_Factory.init_url(iframe);
        iframe_page ip = PageFactory.initElements(driver, iframe_page.class);
        ip.Iframe_meth();
    }
    @Test(priority=13)
    public void  Hover_test(){
        driver = Browser_Factory.init_url(hovers);
        hovers_page hp = PageFactory.initElements(driver, hovers_page.class);
        hp.hovers_page_meth();
    }
    @Test(priority=14)
    public void  JavaScript_Alerts_test(){
        driver = Browser_Factory.init_url(javascript_alerts);
        javascript_alerts_page jsp = PageFactory.initElements(driver, javascript_alerts_page.class);
        jsp.JavaScript_Alerts_meth();
    }
    @Test(priority=15)
    public void  JavaScript_Error_test(){
        driver = Browser_Factory.init_url(javascript_error);
         javascript_error_page jsep = PageFactory.initElements(driver, javascript_error_page.class);
         jsep.JavaScript_Error_meth();
    }
    @Test(priority=16)
    public void  windows_test(){
        driver = Browser_Factory.init_url(windows);
       windows_page wip  = PageFactory.initElements(driver, windows_page.class);
       wip.Open_in_New_Tab_meth();
    }
    @Test(priority=17)
    public void  Notification_Message_test(){
        driver = Browser_Factory.init_url(notification_message_rendered);
        notification_message_page nmrp = PageFactory.initElements(driver, notification_message_page.class);
        nmrp.notification_message_meth();
    }
    @AfterClass
    public void browser_fact_After() throws InterruptedException {
//      driver =  Browser_Factory.teardown();
    }
}