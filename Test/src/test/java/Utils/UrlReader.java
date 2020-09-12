package Utils;


import java.io.FileInputStream;
import java.util.Properties;

public class UrlReader {

    private static Properties data;

    static {
        String path = "src/test/resources/urls.properties";

        try{
            FileInputStream file = new FileInputStream(path);
            data = new Properties();
            data.load(file);
            file.close();
        } catch (Exception e) {
            System.out.println("Path \""+path+"\" was not found");
        }
    }

    public static String getProperty(String key) {return data.getProperty(key);}

}
