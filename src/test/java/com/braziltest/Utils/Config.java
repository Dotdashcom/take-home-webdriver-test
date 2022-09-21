package com.braziltest.Utils;

import com.braziltest.utils.ManipularJson;

public class Config {

    public static final String PLATFORMNAME = "WEB";
    public static final String BROWSERTESTING = "CHROME"; // FIREFOX / CHROME //GRID
    public static final String DRIVERPATHCHROMELIN = "/home/bressan/drivers/chromedriver_linux64/chromedriver";
    public static final String DRIVERPATHCHROMEWIN = "C:\\Drivers\\browsers\\chrome\\105\\chromedriver.exe";
    public static final String DRIVERPATHFFOXLIN = "/home/bressan/drivers/chromedriver_linux64/chromedriver";
    public static final String DRIVERPATHFFOXWIN = "C:\\Drivers\\browsers\\firefox\\geckodriver-v0.26.0-win64\\geckodriver.exe";
    //For Windows Users
    public static final String RunnerNbr = "Run_"+ ManipularJson.getSaltStringCelular();
    public static final String PATHEVIDENCEWIN = "C:\\Evidencias\\TEILUR\\" + RunnerNbr + "\\";
    public static final String PATHEVIDENCELINUX = "/home/bressan/evidencias/TEILUR/"+ RunnerNbr + "/";

    public static final String EvidenceGen = "S"; //S//N
    public static final int TIMEOUTAUTOMATION = 100;
    public static final String PLATFORMTYPE = PLATFORMNAME;
    public static final String dataAtual = ManipularJson.dataAtual();
    public static String ScenarioName = "";
    public static String ScenarioId = "";
    public static String FeatureName = "";
    public static final String xpath = "xpath";
    public static final String cssSelector = "cssSelector";
    public static final String className = "className";
    public static final String id = "id";
    public static final String tagname = "tagname";
    public static String PathOrigin = "";
    public static String pSit = "";
}
