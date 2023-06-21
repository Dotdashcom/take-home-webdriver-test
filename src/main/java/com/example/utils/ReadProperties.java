package com.example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Logger;

public class ReadProperties {

    Logger log = Logger.getLogger(ReadProperties.class.getName());
    private String browser;
    private String env;
    private String url;
    private String userName;
    private String password;
    private String driverPath;

    private final String TEST_RUNNER_PROPERTIES = "testRunner.properties";
    private final String PROJECT_PROPERTIES = "config/project.properties";
    private final String QA_PROPERTIES = "config/qa.properties";
    private final String SMOKE_PROPERTIES = "config/qa.properties";
    private final String LOCAL_PROPERTIES = "config/local.properties";
    private final String UAT_PROPERTIES = "config/qa.properties";

    public ReadProperties(){
        if(System.getProperty("env") == null){
            setEnv(getProjectProperties(TEST_RUNNER_PROPERTIES,"org.env"));
        }else {
            setEnv(System.getProperty("rcm.env"));
        }

        if (System.getProperty("browser") == null){
            setBrowser(getProjectProperties(TEST_RUNNER_PROPERTIES,"org.web.browser"));
        }else {
            setBrowser(System.getProperty("browser"));
        }
        setDriverPath(getProjectProperties(PROJECT_PROPERTIES,"project.driver.path"));

        if (getEnv().equals("qa")){
            setUrl(getProjectProperties(QA_PROPERTIES,"org.web.url"));
            if (System.getProperty("userName")!=null){
                String name = System.getProperty("userName");
                setUserName(name);
            }
            else {
                setUserName(getProjectProperties(QA_PROPERTIES,"userName"));
            }

            if (System.getProperty("password")!=null){
                setPassword(System.getProperty("password"));
            }else {
                setPassword(getProjectProperties(QA_PROPERTIES,"password"));
            }
        } else if (getEnv().equals("smoke")){
            setUrl(getProjectProperties(SMOKE_PROPERTIES,"org.web.url"));
            if (System.getProperty("userName")!=null){
                String name = System.getProperty("userName");
                setUserName(name);
            }
            else {
                setUserName(getProjectProperties(SMOKE_PROPERTIES,"userName"));
            }

            if (System.getProperty("password")!=null){
                setPassword(System.getProperty("password"));
            }else {
                setPassword(getProjectProperties(SMOKE_PROPERTIES,"password"));
            }
        } else if (getEnv().equals("UAT")){
            setUrl(getProjectProperties(UAT_PROPERTIES,"org.web.url"));
            if (System.getProperty("userName")!=null){
                String name = System.getProperty("userName");
                setUserName(name);
            }
            else {
                setUserName(getProjectProperties(UAT_PROPERTIES,"userName"));
            }

            if (System.getProperty("password")!=null){
                setPassword(System.getProperty("password"));
            }else {
                setPassword(getProjectProperties(UAT_PROPERTIES,"password"));
            }
        } else if (getEnv().equals("local")){
            setUrl(getProjectProperties(LOCAL_PROPERTIES,"org.web.url"));
            if (System.getProperty("userName")!=null){
                String name = System.getProperty("userName");
                setUserName(name);
            }
            else {
                setUserName(getProjectProperties(LOCAL_PROPERTIES,"userName"));
            }

            if (System.getProperty("password")!=null){
                setPassword(System.getProperty("password"));
            }else {
                setPassword(getProjectProperties(LOCAL_PROPERTIES,"password"));
            }
        }
    }

    public String getProjectProperties(String propertyFile, String property){
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            if(propertyFile.equalsIgnoreCase(TEST_RUNNER_PROPERTIES)){
                //this code can be improved for mac or windows
                inputStream = new FileInputStream(Paths.get("").toAbsolutePath().normalize().toString() + "/" + propertyFile);
            }else{
                inputStream = getClass().getClassLoader().getResourceAsStream(propertyFile);
            }
            properties.load(inputStream);
        }catch (IOException e){
            log.info(e.getMessage());
        }finally {
            try{
                inputStream.close();
            }catch (IOException e){
                log.info(e.getMessage());
            }
        }
        return properties.getProperty(property);
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverPath() {
        return driverPath;
    }

    public void setDriverPath(String driverPath) {
        this.driverPath = driverPath;
    }
}
