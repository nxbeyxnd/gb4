package ru.alexey.task5.controller;
/* 
22.05.2022: Alexey created this file inside the package: ru.alexey.task5.controller 
*/

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alexey.task5.DTO.StudentRequestUpdate;
import ru.alexey.task5.entity.Student;
import ru.alexey.task5.sevice.StudentService;

import java.util.List;

@RestController
@RequestMapping(path = "user")
public class MainController {

    private final StudentService studentService;

    public MainController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(studentService.getStudentByID(id));
    }

    @PostMapping(path = "")
    public ResponseEntity<Student> saveUser(@RequestBody StudentRequestUpdate studentRequestUpdate) {
        return ResponseEntity.ok(studentService.saveStudent(studentRequestUpdate));
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Student> updateUser(@PathVariable("id") Long id, @RequestBody StudentRequestUpdate studentRequestUpdate) {
        return ResponseEntity.ok(studentService.updateStudent(id, studentRequestUpdate));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "t")
    public Object test() {
        return studentService.getCountData();
    }
}
