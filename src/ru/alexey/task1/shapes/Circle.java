package ru.alexey.task1.shapes;
/* 
25.04.2022: Alexey created this file inside the package: ru.alexey.task1.shapes 
*/

public class Circle implements Shape {
    private int radius = 10;

    @Override
    public void info() {
        System.out.println("radius is - " + radius);
    }
}
