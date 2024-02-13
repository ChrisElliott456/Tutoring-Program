package com.school.TutoringProgram.service;

import com.school.TutoringProgram.entity.Student;
import com.school.TutoringProgram.exception.ResourceNotFoundException;
import com.school.TutoringProgram.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student with id " + id + " not found."));
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudentById(Long id, Student student) {
        Student existingStudent = getStudentById(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setAge(student.getAge());
        existingStudent.setGender(student.getGender());
        studentRepository.save(existingStudent);
        return existingStudent;
    }
}
