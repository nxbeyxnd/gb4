package ru.alexey.gb_task_7.controller;
/* 
27.05.2022: Alexey created this file inside the package: ru.alexey.gb_task_7.controller 
*/

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.alexey.gb_task_7.dto.StudentRequestDto;
import ru.alexey.gb_task_7.entity.Student;
import ru.alexey.gb_task_7.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "student")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public ResponseEntity<List<Student>> findAllStudents(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return ResponseEntity.ok(service.getAllStudents());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(service.getStudentById(id));
    }

    @PostMapping(path = "")
    public ResponseEntity<Student> addNewStudent(@RequestBody StudentRequestDto studentRequestDto) {
        return ResponseEntity.ok(service.addNewStudent(studentRequestDto));
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Student> updateUserById(@PathVariable(name = "id") Long id,
                                                  @RequestBody StudentRequestDto studentRequestDto) {
        return ResponseEntity.ok(service.updateStudent(id, studentRequestDto));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable(name = "id") Long id) {
        service.removeStudentById(id);
        return ResponseEntity.noContent().build();
    }

}
