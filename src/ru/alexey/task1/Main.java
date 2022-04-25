package ru.alexey.task1;
/*
23.04.2022: Alexey created this file inside the package: ru.alexey 
*/

import ru.alexey.task1.T2.Car;
import ru.alexey.task1.T2.Engine;
import ru.alexey.task1.T2.Lorry;
import ru.alexey.task1.shapes.Shape;
import ru.alexey.task1.shapes.Square;
import ru.alexey.task1.shapes.Triangle;

public class Main {
    public static void main(String[] args) {
        Car car = new Lorry(new Engine(), "b", "b");
    }
}
