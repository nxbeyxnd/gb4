package ru.alexey.gb_task_7.service;
/* 
27.05.2022: Alexey created this file inside the package: ru.alexey.gb_task_7.service 
*/

import ru.alexey.gb_task_7.dto.StudentRequestDto;
import ru.alexey.gb_task_7.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student addNewStudent(StudentRequestDto studentRequestDto);

    Student updateStudent(Long id, StudentRequestDto studentRequestDto);

    void removeStudentById(Long id);
}
