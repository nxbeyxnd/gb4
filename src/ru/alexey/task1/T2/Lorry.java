package ru.alexey.task1.T2;
/* 
25.04.2022: Alexey created this file inside the package: ru.alexey.task1.refactoring 
*/

public class Lorry extends Car {

    public Lorry(Engine engine, String color, String name) {
        super(engine, color, name);
    }

    public void move() {
        System.out.println("Car is moving");
    }

    public void stop() {
        System.out.println("Car is stop");
    }

    @Override
    void open() {
        System.out.println("Car is open");
    }
}
