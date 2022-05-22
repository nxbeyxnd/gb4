package ru.alexey.task5.dao;
/* 
22.05.2022: Alexey created this file inside the package: ru.alexey.task5.DAO 
*/

import ru.alexey.task5.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDAO {
    List<Student> getAllStudent();

    Optional<Student> getStudentByID(Long id);

    Student saveStudent(Student student);

    List<Student> addAll(List<Student> students);

    void deleteStudentById(Long id);

    Long getCountData();

}
