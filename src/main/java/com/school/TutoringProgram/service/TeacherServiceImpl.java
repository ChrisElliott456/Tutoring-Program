package com.school.TutoringProgram.service;

import com.school.TutoringProgram.entity.Teacher;
import com.school.TutoringProgram.exception.ResourceNotFoundException;
import com.school.TutoringProgram.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{
    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Teacher with id " + id + " could not be found."));
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacherById(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public Teacher updateTeacherById(Long id, Teacher teacher) {
        Teacher existingTeacher = getTeacherById(id);
        existingTeacher.setFirstName(teacher.getFirstName());
        existingTeacher.setLastName(teacher.getLastName());
        existingTeacher.setSubject(teacher.getSubject());
        existingTeacher.setGender(teacher.getGender());
        teacherRepository.save(existingTeacher);
        return existingTeacher;
    }
}
