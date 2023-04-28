package com.Classroom.ClassroomApp.service;
import com.Classroom.ClassroomApp.entity.Student;
import com.Classroom.ClassroomApp.exception.ResourceNotFoundException;
import com.Classroom.ClassroomApp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<Student> getStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id){ Optional<Student> studentPicked = studentRepository.findById(id);
        if (studentPicked.isPresent()){
            return studentPicked.get();
        } else {
            throw new ResourceNotFoundException("Student with " +id + " is absent!");
        }
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Optional<Student>optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            optionalStudent.get().setId(student.getId());
            optionalStudent.get().setName(student.getName());
            optionalStudent.get().setlastName(student.getlastName());
            optionalStudent.get().setGrade(student.getGrade());
            optionalStudent.get().setYear(student.getYear());
            optionalStudent.get().setAge(student.getAge());
            optionalStudent.get().setTeacher(student.getTeacher());

            return studentRepository.save(optionalStudent.get());

        }else {
            throw new ResourceNotFoundException("Student with " +id + " is absent!");
        }


    }

    @Override
    public Student saveStudent(Student student) {

      return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
