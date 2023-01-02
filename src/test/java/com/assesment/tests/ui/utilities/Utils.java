package com.assesment.tests.ui.utilities;

public class Utils {

    public static String getParams(String currentUrl){
        String base_url = ConfigReader.getProperty("base_url");
        String params = currentUrl.replace(base_url,"");
        return params;
    }
}

