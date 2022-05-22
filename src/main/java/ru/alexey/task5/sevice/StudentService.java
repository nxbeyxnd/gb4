package ru.alexey.task5.sevice;/* 
22.05.2022: Alexey created this file inside the package: ru.alexey.task5.sevice 
*/

import ru.alexey.task5.DTO.StudentRequestUpdate;
import ru.alexey.task5.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();

    Student getStudentByID(Long id);

    Student saveStudent(StudentRequestUpdate studentRequestUpdate);

    List<Student> addAll(List<StudentRequestUpdate> studentRequestUpdates);

    Student updateStudent(Long id, StudentRequestUpdate student);

    void deleteStudentById(Long id);

    Long getCountData();
}
