package com.Classroom.ClassroomApp.repository;

import com.Classroom.ClassroomApp.entity.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher,Long> {
}