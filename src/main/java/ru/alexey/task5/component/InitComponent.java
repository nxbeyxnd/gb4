package ru.alexey.task5.component;
/* 
23.05.2022: Alexey created this file inside the package: ru.alexey.task5.component 
*/

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.alexey.task5.DTO.StudentRequestUpdate;
import ru.alexey.task5.sevice.StudentService;

import java.util.Arrays;


@Component
public class InitComponent implements ApplicationListener<ContextRefreshedEvent> {
    private final StudentService studentService;

    public InitComponent(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (studentService.getCountData() < 100L) {
            StudentRequestUpdate[] students = new StudentRequestUpdate[1000];
            Arrays.fill(students, 0, 1000, new StudentRequestUpdate("text", 4));
            studentService.addAll(Arrays.stream(students).toList());
        }
    }
}
