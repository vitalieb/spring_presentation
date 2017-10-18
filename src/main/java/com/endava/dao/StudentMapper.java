package com.endava.dao;

import com.endava.BoyStudent;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<BoyStudent> {
    public BoyStudent mapRow(ResultSet rs, int rowNum) throws SQLException {
        BoyStudent boyStudent = new BoyStudent();
        boyStudent.setId(rs.getInt("id"));
        boyStudent.setName(rs.getString("name"));

        return boyStudent;
    }
}