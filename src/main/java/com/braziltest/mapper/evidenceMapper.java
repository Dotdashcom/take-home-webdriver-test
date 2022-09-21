package com.braziltest.mapper;

import com.braziltest.dto.evidence;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class evidenceMapper implements RowMapper<evidence> {

    public evidence mapRow(ResultSet rs, int rowNum) throws SQLException {
        evidence ev = new evidence();
        ev.setRunner(rs.getString("Runner"));

        return ev;
    }


}
