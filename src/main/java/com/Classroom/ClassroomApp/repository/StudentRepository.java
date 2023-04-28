package com.Classroom.ClassroomApp.repository;


import com.Classroom.ClassroomApp.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {

}