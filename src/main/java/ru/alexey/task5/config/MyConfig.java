package ru.alexey.task5.config;
/* 
22.05.2022: Alexey created this file inside the package: ru.alexey.task5.config 
*/

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Component
@ComponentScan("ru.alexey.task5")
@EnableWebMvc
public class MyConfig {
}
