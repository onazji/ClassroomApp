package com.Classroom.ClassroomApp.controller;

import com.Classroom.ClassroomApp.entity.Student;
import com.Classroom.ClassroomApp.entity.Teacher;
import com.Classroom.ClassroomApp.service.TeacherService;
import com.Classroom.ClassroomApp.service.TeacherService;
import com.Classroom.ClassroomApp.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/all")
    public ResponseEntity<List<Teacher>> getTeachers() {
        return new ResponseEntity<>(teacherService.getTeachers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable Long id){return new ResponseEntity<>(teacherService.getTeacherById(id),HttpStatus.OK);}

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id,@RequestBody Teacher teacher){ return new ResponseEntity<>(teacherService.updateTeacher(id,teacher),HttpStatus.ACCEPTED);}

    @PostMapping
    public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher){return new ResponseEntity<>(teacherService.saveTeacher(teacher),HttpStatus.CREATED);}

    @DeleteMapping("/{id}")
    public ResponseEntity<Teacher> delTeacher(@PathVariable Long id){teacherService.deleteTeacher(id); return new ResponseEntity<>(HttpStatus.NO_CONTENT);}













}
