package com.Classroom.ClassroomApp.service;

import com.Classroom.ClassroomApp.entity.Teacher;
import com.Classroom.ClassroomApp.exception.ResourceNotFoundException;
import com.Classroom.ClassroomApp.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    private TeacherRepository teacherRepository;
    @Override
    public List<Teacher> getTeachers() {
        return (List<Teacher>) teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(Long id) { Optional<Teacher> teacherPicked = teacherRepository.findById(id);
        if (teacherPicked.isPresent()){
        return teacherPicked.get();
    } else {
        throw new ResourceNotFoundException("Teacher with " +id + " is absent!, call in the sub?!");
    }
}

    @Override
    public Teacher updateTeacher(Long id, Teacher teacher) {
        Optional<Teacher>optionalTeacher = teacherRepository.findById(id);
        if(optionalTeacher.isPresent()){
           optionalTeacher.get().setTeacherId(teacher.getTeacherId());
           optionalTeacher.get().setFirstName(teacher.getFirstName());
           optionalTeacher.get().setLastName(teacher.getLastName());
            return teacherRepository.save(optionalTeacher.get());

        }else {
            throw new ResourceNotFoundException("Teacher with " +id + " is absent! Call principle!");
        }
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
    @Override
    public void deleteTeacher(Long id) {
    teacherRepository.deleteById(id);
    }
}
