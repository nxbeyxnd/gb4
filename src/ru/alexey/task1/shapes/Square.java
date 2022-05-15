package ru.alexey.task1.shapes;
/* 
25.04.2022: Alexey created this file inside the package: ru.alexey.task1.shapes 
*/

public class Square implements Shape {
    private int corner = 4;

    @Override
    public void info() {
        System.out.println("corners: " + this.corner);
    }
}
