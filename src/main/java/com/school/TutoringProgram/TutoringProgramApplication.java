package com.school.TutoringProgram;

import com.school.TutoringProgram.repository.StudentRepository;
import com.school.TutoringProgram.repository.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

	}

}
