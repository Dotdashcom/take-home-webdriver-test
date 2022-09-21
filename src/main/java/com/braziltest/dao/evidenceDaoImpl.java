package com.braziltest.dao;

import com.braziltest.dto.evidence;
import com.braziltest.mapper.evidenceMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.braziltest.sql.sqlDatasource;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class evidenceDaoImpl implements evidenceDao {

    public void evidenceSave(
            String Runner,
            String Evidence,
            Integer COD_BU ) throws Exception {
        JdbcTemplate jdbcTemplate = sqlDatasource.getJdbc("TLY","10.10.0.10","SQLSERVER");
        String vlsql ="";
        vlsql = "INSERT INTO TEST_EVIDENCE ( Runner,Evidence,Created_by,Creation_date,COD_BU)values(";
        vlsql = vlsql + " '" + Runner + "'" ;
        vlsql = vlsql + " ,'" + Evidence + "'" ;
        vlsql = vlsql + " ,'AUTOMATION'" ;
        vlsql = vlsql + " ,getdate()" ;
        vlsql = vlsql + " ," + COD_BU  ;
        vlsql = vlsql + ")" ;
        jdbcTemplate.execute(vlsql);

    }


    public Collection<evidence> evidenceGet(String Runner) throws SQLException, IOException, ClassNotFoundException {
        JdbcTemplate jdbcTemplate = sqlDatasource.getJdbc("TLY","10.10.0.10","SQLSERVER");
        String vlsql ="";
        vlsql = "SELECT Runner FROM TEST_EVIDENCE WHERE Runner = '"+ Runner + "'";
        jdbcTemplate.execute(vlsql);

        List<evidence> evret =  jdbcTemplate.query(vlsql,new evidenceMapper());
        return evret;

    }

}
