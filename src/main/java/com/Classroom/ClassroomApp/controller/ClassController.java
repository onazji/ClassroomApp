package com.Classroom.ClassroomApp.controller;
import com.Classroom.ClassroomApp.entity.Student;
import com.Classroom.ClassroomApp.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//

import java.util.List;
//
@RestController
@RequestMapping("/api/v1/classroom")
public class ClassController {
    @Autowired
  private StudentService studentService;
    @GetMapping("/all")
    public ResponseEntity<List<Student>> getStudents(){return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }
    //"id/{id}"
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student student){return new ResponseEntity<>(studentService.updateStudent(id, student), HttpStatus.ACCEPTED);}

    //post == saving
    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){ return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);}

    //DEL
    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id){studentService.deleteStudent(id); return new ResponseEntity<>(HttpStatus.NO_CONTENT);}










}