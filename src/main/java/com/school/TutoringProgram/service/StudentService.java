package com.school.TutoringProgram.service;

import com.school.TutoringProgram.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();

    Student getStudentById(Long id);

    Student addStudent(Student student);

    void deleteStudentById(Long id);

    Student updateStudentById(Long id, Student student);
}
