package com.school.TutoringProgram.web;

import com.school.TutoringProgram.entity.Student;
import com.school.TutoringProgram.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/school/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById (@PathVariable Long id){
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Student> addStudent (@RequestBody Student student){
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> deleteStudentById (@PathVariable Long id){
        studentService.deleteStudentById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudentById (@PathVariable Long id, @RequestBody Student student){
        return new ResponseEntity<>(studentService.updateStudentById(id, student), HttpStatus.ACCEPTED);
    }
}
