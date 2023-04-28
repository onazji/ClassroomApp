package com.Classroom.ClassroomApp;
import com.Classroom.ClassroomApp.entity.Student;
import com.Classroom.ClassroomApp.entity.Teacher;
import com.Classroom.ClassroomApp.repository.StudentRepository;
import com.Classroom.ClassroomApp.repository.TeacherRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.List;
@SpringBootApplication
@OpenAPIDefinition
public class ClassroomAppApplication implements CommandLineRunner {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private TeacherRepository teacherRepository;

	private static final Logger logger = LoggerFactory.getLogger(com.Classroom.ClassroomApp.ClassroomAppApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(com.Classroom.ClassroomApp.ClassroomAppApplication.class, args);
		logger.info("Application started");
	}

	@Override
	public void run(String... args) throws Exception {

		Teacher teacher1 = new Teacher("Philip", "Dragon");
		Teacher teacher2 = new Teacher("Cresha", "Honey");
		teacherRepository.saveAll(Arrays.asList(teacher1, teacher2));
		List<Student> students = Arrays.asList(

				new Student(11111, "Nazji", "Fling", "A+", 1, 14, teacher1),
				new Student(11112, "Broceli", "Smoothie", "B", 2, 15, teacher2),
				new Student(11111, "Cammie", "Treesnap", "C", 1, 15, teacher1),
				new Student(11112, "Bashir", "Dragon", "D", 2, 16, teacher2)
		);
//		StudentRepository.saveAll(students);
//		StudentRepository.findAll().forEach(Classroom -> logger.info(Classroom.getId() + " " + Classroom.getName()));

		studentRepository.saveAll(students);
		studentRepository.findAll().forEach(student -> logger.info(student.getId()+" "+ student.getName()));


	}
}