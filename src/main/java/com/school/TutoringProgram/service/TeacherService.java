package com.school.TutoringProgram.service;

import com.school.TutoringProgram.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getTeachers();

    Teacher getTeacherById(Long id);

    Teacher addTeacher(Teacher teacher);

    void deleteTeacherById(Long id);

    Teacher updateTeacherById(Long id, Teacher teacher);
}
