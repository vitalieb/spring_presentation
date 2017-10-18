package com.endava.dao;

import com.endava.BoyStudent;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

public interface BoyStudentDao {

    public void create(String name);

    public BoyStudent getStudent(Integer id);

    public List<BoyStudent> listStudents();

    public void delete(Integer id);

}
