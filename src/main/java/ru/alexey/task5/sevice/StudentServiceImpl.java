package ru.alexey.task5.sevice;
/* 
22.05.2022: Alexey created this file inside the package: ru.alexey.task5.sevice 
*/

import org.springframework.stereotype.Service;
import ru.alexey.task5.dao.StudentDAO;
import ru.alexey.task5.DTO.StudentRequestUpdate;
import ru.alexey.task5.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentDAO.getAllStudent();
    }

    //Should return exception instead null
    @Override
    public Student getStudentByID(Long id) {
        Optional<Student> student = studentDAO.getStudentByID(id);
        return student.orElse(null);
    }

    @Override
    public Student saveStudent(StudentRequestUpdate studentRequestUpdate) {
        Student student = new Student(studentRequestUpdate.name(), studentRequestUpdate.mark());
        return studentDAO.saveStudent(student);
    }

    @Override
    public List<Student> addAll(List<StudentRequestUpdate> studentRequestUpdates) {
        List<Student> studentsToAdd = new ArrayList<>();
        for (StudentRequestUpdate s : studentRequestUpdates) {
            studentsToAdd.add(new Student(s.name(), s.mark()));
        }
        return studentDAO.addAll(studentsToAdd);
    }

    @Override
    public Student updateStudent(Long id, StudentRequestUpdate studentRequestUpdate) {
        Optional<Student> student = studentDAO.getStudentByID(id);
        if (student.isPresent()) {
            student.get().setName(studentRequestUpdate.name());
            student.get().setMark(studentRequestUpdate.mark());
            return studentDAO.saveStudent(student.get());
        }
        return studentDAO.saveStudent(new Student(studentRequestUpdate.name(), studentRequestUpdate.mark()));
    }

    @Override
    public void deleteStudentById(Long id) {
        studentDAO.deleteStudentById(id);
    }

    @Override
    public Long getCountData() {
        return studentDAO.getCountData();
    }
}
