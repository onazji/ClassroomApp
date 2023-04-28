package com.Classroom.ClassroomApp.service;


import com.Classroom.ClassroomApp.entity.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getTeachers();

    Teacher getTeacherById(Long id);

    //update Teacher by id
    Teacher updateTeacher(Long id,Teacher teacher);

    //create a Teacher
    Teacher saveTeacher(Teacher teacher);

    //DEL
    void deleteTeacher(Long id);

}
