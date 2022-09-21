package com.braziltest.sql;

import javax.sql.DataSource;
import java.io.IOException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class sqlDatasource {
    private static String url;

    @Bean
    private static DataSource getDataSource(String Env, String Server, String Type) throws IOException, ClassNotFoundException {

        String driverClassName = null;

        if (Type.equals("SQLITE")) {
            driverClassName = "org.sqlite.JDBC";
            //windows platform agent
            if (System.getProperty("os.name").contains("Windows")) {


                if (Env.contains("BKUS")) {
                    url = "jdbc:sqlite:\\\\" + Server + "\\bkus\\bkus\\data\\databases\\product.db";
                }
                if (Env.contains("THUS")) {
                    url = "jdbc:sqlite:\\\\" + Server + "\\thus\\thus\\data\\databases\\product.db";
                }

                if (Env.equals("BOH")) {
                    url = "jdbc:sqlite:\\\\" + Server + "\\boh\\data.sqlite";
                }
                if (Env.equals("BKDE")) {
                    url = "jdbc:sqlite:\\\\" + Server + "\\bkde\\bkde\\data\\databases\\product.db";
                }
                if (Env.equals("BKUS-LDST")) {
                    url = "jdbc:sqlite:\\\\" + Server + "\\ServerRoot\\mediaworks\\sources\\repos\\version38\\bkus\\data\\databases\\product.db";
                }

                if (Env.contains("POPEYES")) {
                    url = "jdbc:sqlite:\\\\" + Server + "\\plkus\\popeyes\\data\\databases\\product.db";
                }

                if (Env.equals("THCA")) {
                    url = "jdbc:sqlite:\\\\" + Server + "\\\\thca\\thca\\data\\databases\\product.db";
                }

                if (Env.equals("bkuspmix")) {
                    url = "jdbc:sqlite:\\\\" + Server + "\\profiles\\mediaworks\\sources\\repos\\BKUS-Barnett\\data\\databases\\rbi_pmix.db";
                }
                if (Env.equals("thuspmix")) {
                    url = "jdbc:sqlite:\\\\" + Server + "\\thim_hortons\\data\\databases\\rbi_pmix.db";
                }

                if (Env.equals("BKMEX")) {
                    url = "jdbc:sqlite:\\\\" + Server + "\\bkmex\\bkmex\\data\\databases\\product.db";

                }
            }


            //linux platform agent
            if (System.getProperty("os.name").contains("Linux")) {
                if (Env.contains("BKUS")) {

                    url = "jdbc:sqlite:/mnt/bkus/bkus/data/databases/product.db";
                }

                if (Env.equals("THCA")) {
                    url = "jdbc:sqlite:/mnt/thca/thca/data/databases/product.db";
                }


                if (Env.contains("THUS")) {
                    url = "jdbc:sqlite:/mnt/thus/thus/data/databases/product.db";
                }

                if (Env.equals("POPEYES")) {
                    url = "jdbc:sqlite:/mnt/popeyes/popeyes/data/databases/product.db";
                }

                if (Env.equals("BKDE")) {
                    url = "jdbc:sqlite:/mnt/bkde/bkde/data/databases/product.db";
                }

                if (Env.equals("BKMEX")) {
                    url = "jdbc:sqlite:/mnt/bkmex/bkmex/data/databases/product.db";
                }

            }

        }

        if(Type.equals("SQLSERVER")) {
            driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            url = "jdbc:sqlserver://10.10.0.10:1433;"
                    + "database=xproject;"
                    + "user=sa;"
                    + "password=agt007;"
                    + "encrypt=true;"
                    + "trustServerCertificate=true;"
                    + "loginTimeout=30;";
        }

        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        return dataSource;
    }

    public static JdbcTemplate getJdbc(String Env,String Server,String Type) throws IOException, ClassNotFoundException {

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource(Env,Server,Type));

        return jdbcTemplate;
    }
}
