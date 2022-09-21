package com.braziltest;

import com.braziltest.utils.ManipularJson;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class testClass {

    public static void main(String[] args) throws Exception {
        //System.out.println( obterDataSemana("TER"));
       // ManipularJson mj = new ManipularJson();
        //System.out.println(mj.dataAtual());

RemoteWebDriver driver;
        DesiredCapabilities cap = new DesiredCapabilities().firefox();
        cap.setPlatform(Platform.WIN10);
        cap.setBrowserName("firefox");
         driver = new RemoteWebDriver(new URL("http://10.10.0.5:5557/wd/hub"), cap);
        driver.get("https://192.168.15.1/");
    }



    public static String obterDataSemana(String diaSemana) throws Exception {
        Calendar calendar = Calendar.getInstance();
        Date dataHj = new Date();
        calendar.setTime(dataHj);
        LocalDate ld = LocalDate.now();
        DayOfWeek dow = ld.getDayOfWeek();
        int value = dow.getValue();
        calendar.setFirstDayOfWeek(value);
        switch (diaSemana) {
            case "SAB":
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
                break;
            case "DOM":
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                break;
            case "SEG":
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                break;
            case "TER":
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                break;
            case "QUA":
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                break;
            case "QUI":
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                break;
            case "SEX":
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                break;
            default:
                throw new Exception("Opção de menu inválida");
        }
        SimpleDateFormat format1 = new SimpleDateFormat("ddMMyyyy");
        String formatted = format1.format(calendar.getTime());
        //System.out.println(formatted);
        return  formatted;
    }
}
