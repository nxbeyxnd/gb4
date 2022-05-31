package ru.alexey.gb_task_7.controller;
/* 
27.05.2022: Alexey created this file inside the package: ru.alexey.gb_task_7.controller 
*/

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.alexey.gb_task_7.dto.StudentRequestDto;
import ru.alexey.gb_task_7.service.StudentService;

@Controller
@RequestMapping(path = "")
public class MainController {
    private final StudentService service;

    public MainController(StudentService service) {
        this.service = service;
    }

    @GetMapping()
    public String showAllStudents(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "index";
    }

    @GetMapping(path = "{id}")
    public String getStudentById(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("student", service.getStudentById(id));
        return "student";
    }

    @PutMapping(path = "{id}")
    public String updateStudentById(@PathVariable(name = "id") Long id,
                                    @ModelAttribute() StudentRequestDto studentRequestDto, Model model) {
        model.addAttribute("student", service.updateStudent(id, studentRequestDto));
        return "student";
    }

    @DeleteMapping(path = "{id}")
    public String deleteStudentById(@PathVariable(name = "id") Long id) {
        service.removeStudentById(id);
        return "index";
    }

    @PostMapping(path = "/")
    public String addNewStudent(@ModelAttribute() StudentRequestDto studentRequestDto, Model model) {
        model.addAttribute("student", service.addNewStudent(studentRequestDto));
        return "index";
    }
}
