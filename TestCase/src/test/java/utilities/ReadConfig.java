package utilities;




import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

    public class ReadConfig
    {
        Properties pro;
        public ReadConfig()

        {
            File src=new File("./configuration/config.properties");
            try
            {
                FileInputStream fis=new FileInputStream(src);
                pro=new Properties();
                pro.load(fis);

            }
            catch(Exception e)
            {
                System.out.println("Exception is:"+e.getMessage());
            }
        }
        public String getApplicationURL()
        {
            String url=pro.getProperty("BaseUrl");
            return url;
        }

        public String getUsername()
        {
            String username=pro.getProperty("Username");
            return username;
        }
        public String getPassword()
        {
            String password=pro.getProperty("Password");
            return password;

        }
        public String getWrongUsername()
        {
            String WrngUname=pro.getProperty("WrongUserName");
            return WrngUname;
        }
        public String getWrongPwd()
        {
            String WrngPwd=pro.getProperty("WrongPassword");
            return WrngPwd;
        }
        public String getChromePath()
        {
            String chromePath=pro.getProperty("ChromedriverPath");
            return chromePath;
        }




    }

