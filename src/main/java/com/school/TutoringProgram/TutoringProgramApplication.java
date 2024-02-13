package com.school.TutoringProgram;

import com.school.TutoringProgram.entity.Student;
import com.school.TutoringProgram.entity.Teacher;
import com.school.TutoringProgram.repository.StudentRepository;
import com.school.TutoringProgram.repository.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TutoringProgramApplication implements CommandLineRunner {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private TeacherRepository teacherRepository;
private static final Logger logger = LoggerFactory.getLogger(TutoringProgramApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TutoringProgramApplication.class, args);
		logger.info("Application started.");
	}

	@Override
	public void run(String... args) throws Exception {
		Teacher t1 = new Teacher("Jane", "Smith", "Math", "female");
		Teacher t2 = new Teacher("Robert", "Robinson","Physics","male");
		teacherRepository.save(t1);
		teacherRepository.save(t2);
		List<Student> students = Arrays.asList(
				new Student("Caleb", "Johnson", 14, "male", t2),
				new Student("Katie", "Willis", 16,"female", t1),
				new Student("Maggie", "Thompson", 15, "female", t1),
				new Student("Tyler", "Hunter", 17, "male", t2)
		);
		studentRepository.saveAll(students);
		teacherRepository.findAll().forEach(t->logger.info(t.getLastName()));
		studentRepository.findAll().forEach(s->logger.info(s.getFirstName()+" "+s.getLastName()));
	}

}
