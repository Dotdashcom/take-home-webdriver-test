package com.ProjectName.utilities;

import java.io.File;

public class BrowserUtils {

    public static String getBaseUrl (){
        return ConfigurationReader.getProperty("baseURL");
    }

}
