package com.endava;

import com.endava.dao.BoyStudentJDBCTemplateDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainClass {

    public static void main(String[] args) {

        // Random name pickup
        List<String > names = Arrays.asList("Noah","Liam","Mason","Jacob","William","Ethan","James","Alexander");
        String randomName = names.get(new Random().nextInt(names.size()));

        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationClass.class);
        School school = context.getBean(School.class);
        List<Student> studentList = school.getStudentList();

//        for (Student s : studentList) {
//            System.out.println(s.getName());
//        }



// Plain JDBC

//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/ifinances", "root", "123321");
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from boystudent");
//            while (rs.next())
//                System.out.println(rs.getInt(1) + "  " + rs.getString(14));
//            con.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }

// End of plain JDBC


//        // JdbcTemplate DAO example
//
        BoyStudentJDBCTemplateDAO boyStudentJDBCTemplateDAO = context.getBean(BoyStudentJDBCTemplateDAO.class);
        boyStudentJDBCTemplateDAO.create(randomName);
//        List<BoyStudent> boyStudents = boyStudentJDBCTemplateDAO.listStudents();

//        boyStudents.stream().forEach(boy-> System.out.println(boy.getName()));
        BoyStudent student = boyStudentJDBCTemplateDAO.getStudent(1);
//        System.out.println(student.getName());
//        List<BoyStudent> boyStudentsFromResultSetExtractor = boyStudentJDBCTemplateDAO.listStudentsUsingResultSetExtractor();
//        System.out.println("Listing students using a stream: ");
//        boyStudentsFromResultSetExtractor.stream().forEach(studentFromStream-> System.out.println(studentFromStream.getId()+" "+ studentFromStream.getName()));


//        // Transactional example with interface
//        BoyStudentDao boyStudentDao = context.getBean(BoyStudentDao.class);
//
//        boyStudentDao.create("Transactional John");

    }

}


