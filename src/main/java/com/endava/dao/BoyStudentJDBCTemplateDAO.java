package com.endava.dao;

import com.endava.BoyStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class BoyStudentJDBCTemplateDAO implements BoyStudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void create(String name) {
        String SQL = "insert into boystudent (name) values (?)";
        jdbcTemplate.update(SQL, name);
        System.out.println("Created Record Name = " + name);
        return;
    }

    @Transactional //(propagation = Propagation.REQUIRED)
    public BoyStudent getStudent(Integer id) {
        String SQL = "select * from boystudent where id = ?";
        BoyStudent student = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new StudentMapper());
        return student;
    }

    public List<BoyStudent> listStudents() {
        String SQL = "select * from boystudent";
        List<BoyStudent> students = jdbcTemplate.query(SQL, new StudentMapper());
        System.out.println("Returning list of students ...");
        return students;
    }

    public List<BoyStudent> listStudentsUsingResultSetExtractor() {
        String SQL = "select * from boystudent";
        List<BoyStudent> result = jdbcTemplate.query(SQL, new ResultSetExtractor<List<BoyStudent>>() {
            @Nullable
            @Override
            public List<BoyStudent> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<BoyStudent> boyStudents = new ArrayList<>();
                while (resultSet.next()) {
                    BoyStudent boyStudent = new BoyStudent();
                    boyStudent.setId(resultSet.getInt(1));
                    boyStudent.setName(resultSet.getString(2));
                    boyStudents.add(boyStudent);
                }
                return boyStudents;
            }
        });
        return result;
    }

    public void delete(Integer id) {
        String SQL = "delete from boystudent where id = ?";
        jdbcTemplate.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id);
        return;
    }

}