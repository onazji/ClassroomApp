package com.Classroom.ClassroomApp.service;

import com.Classroom.ClassroomApp.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    // get all students
    List<Student> getStudents();
    // find students by id
    Student getStudentById(Long id);
    //update student by id
    Student updateStudent(Long id,Student student);
    //create a student
    Student saveStudent(Student student);
    //DEL
    void deleteStudent(Long id);


}