package ru.alexey.task1.T2;
/* 
25.04.2022: Alexey created this file inside the package: ru.alexey.task1.refactoring 
*/

class LightWeightCar extends Car {
    public LightWeightCar(Engine engine, String color, String name) {
        super(engine, color, name);
    }

    @Override
    void open() {
        System.out.println("Car is open");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopped");
    }
}

