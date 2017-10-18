package com.endava;

import com.endava.qualifiers.Humans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

@Component
public class School {

    List<Student> studentList;


    public List<Student> getStudentList() {
        return studentList;
    }

    @Autowired
    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
