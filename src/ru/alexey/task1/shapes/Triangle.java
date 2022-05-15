package ru.alexey.task1.shapes;
/* 
25.04.2022: Alexey created this file inside the package: ru.alexey.task1.shapes 
*/

public class Triangle extends Square{
    private int corner = 3;

    @Override
    public void info() {
        System.out.println("corners: " + corner);
    }
}
