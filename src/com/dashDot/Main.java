package com.dashDot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

public class Main {
    WebDriver driver = new ChromeDriver();
public void home() {

    driver.get("http://localhost:7080");
    driver.manage().window().maximize();
}



    public static void main(String[] args) throws InterruptedException, AWTException {
	// write your code here
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chaitanya\\Documents\\ChromeDriver\\chromedriver.exe");
        Checkboxes c = new Checkboxes();
        c.checkboxes();
        Context_Menu cm = new Context_Menu();
        cm.contextMenu();
        DDList dd = new DDList();
        dd.ddlist();
        DragandDrop d = new DragandDrop();
        d.dragDrop();
        Dynamic_Controls dc = new Dynamic_Controls();
        dc.dynControls();
        DynamicContent dcnt = new DynamicContent();
        dcnt.dynamic();
        Notification n = new Notification();
        n.notification();
        DynamicLoad dl = new DynamicLoad();
        dl.dynamicLoad();
        File_Download fd = new File_Download();
        fd.file_download();
        File_upload fu = new File_upload();
        fu.fileUpload();
        Floating_Menu fm = new Floating_Menu();
        fm.floatingMenu();
        Hover_to_Element he = new Hover_to_Element();
        he.hovertoele();
        JsAlert j = new JsAlert();
        j.jsAlert();
        LoginSuccess ls = new LoginSuccess();
        ls.loginSucess();
        MoveIframe mf = new MoveIframe();
        mf.miFrame();
        Window_Handling wh = new Window_Handling();
        wh.win_handling();
    }
}
