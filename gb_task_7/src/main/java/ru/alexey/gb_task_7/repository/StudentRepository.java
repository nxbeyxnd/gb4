package ru.alexey.gb_task_7.repository;
/* 
27.05.2022: Alexey created this file inside the package: ru.alexey.gb_task_7.repository 
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.alexey.gb_task_7.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("FROM Student ORDER BY id ASC")
    @Override
    List<Student>findAll();
}
