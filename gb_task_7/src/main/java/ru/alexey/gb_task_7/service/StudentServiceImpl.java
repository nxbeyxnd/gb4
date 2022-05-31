package ru.alexey.gb_task_7.service;
/* 
27.05.2022: Alexey created this file inside the package: ru.alexey.gb_task_7.service 
*/

import org.springframework.stereotype.Service;
import ru.alexey.gb_task_7.dto.StudentRequestDto;
import ru.alexey.gb_task_7.entity.Student;
import ru.alexey.gb_task_7.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("SWW"));
    }

    @Override
    public Student addNewStudent(StudentRequestDto studentRequestDto) {
        Student student = new Student(studentRequestDto.name(),
                studentRequestDto.age());
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, StudentRequestDto studentRequestDto) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            student.get().setName(studentRequestDto.name());
            student.get().setAge(studentRequestDto.age());
            return studentRepository.save(student.get());
        }
        return student.get();
    }

    @Override
    public void removeStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
