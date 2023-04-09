package com.internet.pages;



public class DynamicContentPage extends BasePage{

    public String getSourceOfPage(){
        return driver.getPageSource();
    }
    public boolean compareContentIfSame(String source){
        driver.navigate().refresh();
        String contentAfterRefresh = driver.getPageSource();
        return source.equals(contentAfterRefresh);

    }







}
