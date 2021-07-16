package com.dotdash;



import org.junit.Test;
import org.openqa.selenium.By;



public class Test10FileDownload extends BaseMethod {


    @Test
    public void downloadFileRevisitedTest() throws Exception {
        driver.get("http://localhost:7080/download");
        driver.findElement(By.linkText("some-file.txt")).click();
        Thread.sleep(3000);



    }



}
